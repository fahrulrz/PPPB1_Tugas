package com.example.tiketkereta

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiketkereta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var locations: Array<String>
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_TIME = "extra_time"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_LOCATION = "extra_location"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // array tujuan
        locations = resources.getStringArray(R.array.tujuan)

        with(binding) {
            val adapterLocation = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, locations)
            adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.inputDestination.adapter = adapterLocation

            inputDestination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {
                    if(position == 0) {
                        (view as? TextView)?.setTextColor(Color.GRAY)
                    } else {
                        (view as? TextView)?.setTextColor(Color.BLACK)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Tidak melakukan apa apa
                }
            }

            inputHour.setOnClickListener {
                showTimePicker()
            }

            inputDate.setOnClickListener {
                showDatePicker()
            }

            btnPesanTiket.setOnClickListener {
                // Ambil nilai dari EditText dan Spinner
                val username = binding.inputUsername.text.toString()
                val hour = binding.inputHour.text.toString()
                val date = binding.inputDate.text.toString()
                val selectedLocation = binding.inputDestination.selectedItem.toString()

                // Validasi input
                if (username.isEmpty() || hour.isEmpty() || date.isEmpty() || selectedLocation == locations[0]) {
                    // Tampilkan pesan kesalahan (misalnya, menggunakan Toast)
                    Toast.makeText(this@MainActivity, "Mohon isi semua kolom dan pilih tujuan!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Jika semua validasi lolos, tampilkan dialog konfirmasi
                val dialog = DialogConfirm()
                val bundle = Bundle()
                bundle.putString(EXTRA_NAME, username)
                bundle.putString(EXTRA_TIME, hour)
                bundle.putString(EXTRA_DATE, date)
                bundle.putString(EXTRA_LOCATION, selectedLocation)
                dialog.arguments = bundle
                dialog.show(supportFragmentManager, "DialogExit")
            }
        }
    }



    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
            // Set formatted time to inputHour EditText
            binding.inputHour.setText(String.format("%02d:%02d", selectedHour, selectedMinute))
        }, hour, minute, true)

        timePickerDialog.show()
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            // Set formatted date to inputDate EditText
            binding.inputDate.setText(String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear))
        }, year, month, day)

        datePickerDialog.show()
    }
}