package com.example.tiketkereta

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tiketkereta.databinding.DialogConfirmBinding

class DialogConfirm : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val binding = DialogConfirmBinding.inflate(inflater)

        // Retrieve data from MainActivity
        val name = arguments?.getString(MainActivity.EXTRA_NAME)
        val time = arguments?.getString(MainActivity.EXTRA_TIME)
        val date = arguments?.getString(MainActivity.EXTRA_DATE)
        val location = arguments?.getString(MainActivity.EXTRA_LOCATION)


        with(binding){
            if(location == "Jakarta") binding.txtTarif.text = "Rp230.000" else if (location == "Aceh") binding.txtTarif.text = "Rp250.000" else if (location == "Bali") binding.txtTarif.text = "Rp300.000" else if(location == "Jawa Tengah") binding.txtTarif.text = "Rp350.000"
            btnBatal.setOnClickListener{
                dismiss()
            }
            btnBeli.setOnClickListener{
                val intentSecondActivity = Intent(requireActivity(), SecondActivity::class.java)
                intentSecondActivity.putExtra(MainActivity.EXTRA_NAME,name)
                intentSecondActivity.putExtra(MainActivity.EXTRA_DATE,date)
                intentSecondActivity.putExtra(MainActivity.EXTRA_TIME,time)
                intentSecondActivity.putExtra(MainActivity.EXTRA_LOCATION,location)
                startActivity(intentSecondActivity)
                dismiss()
            }
        }
        builder.setView(binding.root)
        return builder.create()
    }
}