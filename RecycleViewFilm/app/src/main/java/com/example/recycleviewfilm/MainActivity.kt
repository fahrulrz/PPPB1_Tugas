package com.example.recycleviewfilm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewfilm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy())
        with(binding) {
            cardFilm.apply {
                adapter = adapterDisaster
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity, 2, RecyclerView.VERTICAL, false)

            }
        }
    }

    fun generateDummy() : List<Movie> {
        return listOf(
            Movie(
                filmTitle = "Venom : The Last Dance",
                duration = "1h 2m",
                genre = "Action, Horror, Sci-Fi",
                ageRating = "R13+",
                cover = R.drawable.venom_cover,
                synopsis = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."
            ),
            Movie(
                filmTitle = "Inception",
                genre = "Sci-Fi",
                duration = "148 minutes",
                ageRating = "13+",
                synopsis = "A thief who enters the dreams of others to steal secrets is tasked with planting an idea in someone's mind.",
                cover = R.drawable.inception_cover
            ),
            Movie(
                filmTitle = "The Godfather",
                genre = "Crime",
                duration = "175 minutes",
                ageRating = "17+",
                synopsis = "The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son.",
                cover = R.drawable.the_godfather_cover
            ),
            Movie(
                filmTitle = "The Dark Knight",
                genre = "Action",
                duration = "152 minutes",
                ageRating = "13+",
                synopsis = "Batman battles the Joker, a criminal mastermind who wants to plunge Gotham City into anarchy.",
                cover = R.drawable.the_dark_knight_cover
            ),
            Movie(
                filmTitle = "Forrest Gump",
                genre = "Drama",
                duration = "142 minutes",
                ageRating = "13+",
                synopsis = "The story of a slow-witted but kind-hearted man from Alabama who experiences important historical events.",
                cover = R.drawable.forrest_gump_cover
            ),
            Movie(
                filmTitle = "Interstellar",
                genre = "Sci-Fi",
                duration = "169 minutes",
                ageRating = "13+",
                synopsis = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                cover = R.drawable.interstellar_cover
            ),
            Movie(
                filmTitle = "Parasite",
                genre = "Thriller",
                duration = "132 minutes",
                ageRating = "17+",
                synopsis = "A poor family schemes to become employed by a wealthy family and infiltrates their household.",
                cover = R.drawable.parasite_cover
            ),
            Movie(
                filmTitle = "Pulp Fiction",
                genre = "Crime",
                duration = "154 minutes",
                ageRating = "17+",
                synopsis = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                cover = R.drawable.pulp_fiction_cover
            ),
            Movie(
                filmTitle = "The Matrix",
                genre = "Sci-Fi",
                duration = "136 minutes",
                ageRating = "17+",
                synopsis = "A computer hacker learns about the true nature of reality and his role in the war against its controllers.",
                cover = R.drawable.the_matrix_cover
            ),
            Movie(
                filmTitle = "Titanic",
                genre = "Romance",
                duration = "195 minutes",
                ageRating = "13+",
                synopsis = "A young couple from different social backgrounds fall in love aboard the ill-fated R.M.S. Titanic.",
                cover = R.drawable.titanic_cover
            ),
            Movie(
                filmTitle = "Schindler's List",
                genre = "Historical",
                duration = "195 minutes",
                ageRating = "17+",
                synopsis = "The story of Oskar Schindler, who saved the lives of over a thousand Jewish refugees during the Holocaust.",
                cover = R.drawable.schindlers_list_cover
            )
        )
    }

}