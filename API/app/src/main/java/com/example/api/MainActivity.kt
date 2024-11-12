package com.example.api

import android.os.Bundle
import android.service.autofill.UserData
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.databinding.ActivityMainBinding
import com.example.api.databinding.CardProfilBinding
import com.example.api.model.Data
import com.example.api.model.Users
import com.example.api.network.ApiClient
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        val userList = ArrayList<Data>()

        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {

                val responBody = response.body()

                if (responBody != null) {
                    for (i in response.body()!!.data) {
                        userList.add(Data(i.id, i.email, i.firstName, i.lastName, i.avatar))
                    }
                    val adapterDisaster = CardProfileDisaster(userList)
                    with(binding) {
                        usersData.apply {
                            adapter = adapterDisaster
                            layoutManager = LinearLayoutManager(this@MainActivity)
                        }
                    }

                } else {
                    Toast.makeText(this@MainActivity, "Gagal mengambil data", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_LONG).show()
            }
        })
    }
}