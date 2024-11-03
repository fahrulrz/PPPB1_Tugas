package com.example.recycleviewfilm

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
//import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recycleviewfilm.databinding.FilmCardBinding

class DetailFilm : AppCompatActivity() {
    private lateinit var binding: DetailFilm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        val movie = intent.getParcelableExtra< Movie> ( " movie")

            if (movie != null) {
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
        }
    }
}