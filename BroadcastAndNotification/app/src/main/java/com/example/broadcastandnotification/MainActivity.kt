package com.example.broadcastandnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.broadcastandnotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val channelId = "TEST_NOTIF"
    private val notifId = 90


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val sharedPreferences = getSharedPreferences("Hanip_Ganteng", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putInt("like", 0)
        editor.putInt("dislike", 0)
        editor.apply()

        binding.btnCekGanteng.setOnClickListener{
            val intent = Intent(this, HanipGanteng::class.java)
            startActivity(intent)
        }

        binding.btnNotif.setOnClickListener {

            val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.FLAG_IMMUTABLE
            } else {
                0
            }

            val likeIntent = Intent(this, NotifReceiver::class.java)
            likeIntent.action = "Like"

            val likePendingIntent = PendingIntent.getBroadcast(this, 0, likeIntent, flag)

            val dislikeIntent = Intent(this, NotifReceiver::class.java)
            dislikeIntent.action = "Dislike"

            val dislikePendingIntent = PendingIntent.getBroadcast(this, 1, dislikeIntent, flag)

            val intent = Intent(this, HanipGanteng::class.java) // Untuk mengarahkan ketika notifikasi di klik ke activity terserah

//            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, flag)

            val klikIntent = PendingIntent.getActivity(this, 2, intent, flag)

            val imgHanipGanteng = BitmapFactory.decodeResource(resources, R.drawable.hanip)

            val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.fluent_emoji_pregnant_man_light)
                .setContentTitle("Notif Ciihuuyy") //title notif
                .setContentText("Apakah Mas Hanip Sangat Ganteng?") // Isi pesan bebas
                .setAutoCancel(true)
                .setStyle(
                    NotificationCompat.BigPictureStyle().bigPicture(imgHanipGanteng)
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.like_icon, "Insyaallah", likePendingIntent)  // Tambahkan action jika ingin menambahkan action button
                .addAction(R.drawable.like_icon, "TIDAK", dislikePendingIntent)
                .setContentIntent(klikIntent)

            val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //membuat notifikasi channel
                val notifChannel = NotificationChannel(
                    channelId, // Id channel
                    "Notifikasi Cihuyyyy", // Nama channel notifikasi
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "Ini adalah channel untuk notifikasi cihuyyyy"
                    enableLights(true)
                    lightColor = android.graphics.Color.BLUE
                    enableVibration(true)
                }
//                with(notifManager) {
//                    createNotificationChannel(notifChannel)
//                    notify(notifId, builder.build())
//                }

                notifManager.createNotificationChannel(notifChannel)
            }
            else {
                notifManager.notify(notifId, builder.build())
            }

            notifManager.notify(notifId, builder.build())
        }
    }
}