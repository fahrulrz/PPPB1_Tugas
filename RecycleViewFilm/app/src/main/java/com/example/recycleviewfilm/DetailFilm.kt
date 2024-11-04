package com.example.recycleviewfilm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewfilm.databinding.ActivityDetailFilmBinding

class DetailFilm : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFilmBinding
    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra("movie", Movie::class.java)
            if (movie != null) {
                with(binding){
                    val filmTitle = findViewById<TextView>(R.id.film_title)
                    val duration = findViewById<TextView>(R.id.duration)
                    val ageRating = findViewById<TextView>(R.id.age_rating)
                    val filmCover = findViewById<ImageView>(R.id.film_cover)
                    val synopsis = findViewById<TextView>(R.id.synopsis)

                    filmTitle.text = movie.filmTitle
                    duration.text = movie.duration
                    ageRating.text = movie.ageRating
                    filmCover.setImageResource(movie.cover)
                    filmTitle.text = movie.filmTitle
                    synopsis.text = movie.synopsis

                    val includedLayout = findViewById<View>(R.id.nav_detail)
                    val btnBack = includedLayout.findViewById<ImageView>(R.id.btn_back)
                    btnBack.setOnClickListener {
                        val intentToMainActivity = Intent(this@DetailFilm, MainActivity::class.java)
                        startActivity(intentToMainActivity)
                        finish()
                    }

                    btnBook.setOnClickListener {
                        val intentToMainActivity = Intent(this@DetailFilm, MainActivity::class.java)
                        startActivity(intentToMainActivity)
                        finish()
                    }
                }

        }


    }
}