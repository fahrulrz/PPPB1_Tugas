package com.example.api

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.api.databinding.ActivityDetailUserBinding
import com.example.api.databinding.CardProfilBinding
import com.example.api.model.Data

class DetailUser : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra("user", Data::class.java)
        if (user != null) {
            with(binding) {
                val photoProfile = findViewById<ImageView>(R.id.photo_profile)
                val username = findViewById<TextView>(R.id.username)
                val email = findViewById<TextView>(R.id.email)

                username.text = "Name : ${user.firstName} ${user.lastName}"
                email.text = "Email : ${user.email}"
                Glide.with(binding.root.context).load(user.avatar).centerCrop().into(photoProfile)
            }
        }

    }
}