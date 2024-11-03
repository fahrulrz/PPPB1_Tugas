package com.example.recycleviewfilm

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recycleviewfilm.databinding.FilmCardBinding

class DetailFilm : AppCompatActivity() {
    private lateinit var binding: DetailFilm
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        val movie = intent.getParcelableExtra("movie", Movie::class.java)

        if (movie != null) {
            val filmTitle = findViewById<TextView>(R.id.film_title)
            filmTitle.text = movie.filmTitle
        }
    }
}