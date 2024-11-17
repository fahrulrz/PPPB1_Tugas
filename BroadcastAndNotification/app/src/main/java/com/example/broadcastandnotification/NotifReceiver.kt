package com.example.broadcastandnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotifReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            val sharedPreferences = it.getSharedPreferences("Hanip_Ganteng", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            when (intent?.action) {
                "Like" -> {
                    val currentLike = sharedPreferences.getInt("like", 0)
                    editor.putInt("like", currentLike + 1)
                }
                "Dislike" -> {
                    val currentDislike = sharedPreferences.getInt("dislike", 0)
                    editor.putInt("dislike", currentDislike + 1)
                }
            }
            editor.apply()
        }
    }
}