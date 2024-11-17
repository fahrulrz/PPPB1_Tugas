package com.example.broadcastandnotification

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastandnotification.databinding.ActivityHanipGantengBinding

class HanipGanteng : AppCompatActivity() {
    private lateinit var binding: ActivityHanipGantengBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHanipGantengBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("Hanip_Ganteng", Context.MODE_PRIVATE)
        val likeCount = sharedPreferences.getInt("like", 0)
        val dislikeCount = sharedPreferences.getInt("dislike", 0)

        binding.likeTotal.text = likeCount.toString()
        binding.dislikeTotal.text = dislikeCount.toString()
    }
}