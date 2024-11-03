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
                duration = "2h 28m",
                ageRating = "13+",
                synopsis = "A skilled thief, Dom Cobb, who is the best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, is given a chance to erase his criminal record. He must plant an idea in someone’s mind, a task considered impossible, called inception. Cobb and his team must pull off the perfect crime in a world where dreams are their ultimate playground.",
                cover = R.drawable.inception_cover
            ),
            Movie(
                filmTitle = "The Godfather",
                genre = "Crime",
                duration = "2h 55m",
                ageRating = "17+",
                synopsis = "The aging patriarch of the powerful Corleone crime family, Don Vito Corleone, hands over control to his reluctant son, Michael. The epic tale of family, power, loyalty, and betrayal follows Michael as he becomes the ruthless new godfather, transforming into a man very different from the one he had hoped to be. The family must navigate complex and dangerous relationships within the mafia world.",
                cover = R.drawable.the_godfather_cover
            ),
            Movie(
                filmTitle = "The Dark Knight",
                genre = "Action",
                duration = "2h 32m",
                ageRating = "13+",
                synopsis = "In Gotham City, the criminal mastermind known as the Joker wreaks havoc and tests the moral limits of Batman, a vigilante hero, as well as the citizens he strives to protect. Batman must come face-to-face with this nemesis who represents pure chaos. Their clash becomes an exploration of justice, fear, and the thin line between heroism and villainy in a city on the brink of collapse.",
                cover = R.drawable.the_dark_knight_cover
            ),
            Movie(
                filmTitle = "Forrest Gump",
                genre = "Drama",
                duration = "2h 22m",
                ageRating = "13+",
                synopsis = "Forrest Gump, a man of limited intellect but boundless kindness, finds himself present at crucial historical moments, shaping them in unexpected ways. His journey is one of resilience and sincerity, overcoming obstacles and finding love, as he changes the lives of everyone around him. Through the eyes of Forrest, we see the transformative power of hope and the unexpected beauty in a life of simplicity.",
                cover = R.drawable.forrest_gump_cover
            ),
            Movie(
                filmTitle = "Interstellar",
                genre = "Sci-Fi",
                duration = "2h 49m",
                ageRating = "13+",
                synopsis = "As Earth becomes increasingly uninhabitable, a team of explorers embark on a journey through a newly discovered wormhole, venturing into unknown realms of space and time to secure a future for humanity. Led by Cooper, the mission confronts unprecedented scientific challenges, testing their survival instincts, personal sacrifices, and the unbreakable bonds of love that transcend time and space.",
                cover = R.drawable.interstellar_cover
            ),
            Movie(
                filmTitle = "Parasite",
                genre = "Thriller",
                duration = "2h 12m",
                ageRating = "17+",
                synopsis = "A destitute family, the Kims, infiltrates the opulent lives of the wealthy Park family by taking on various household roles. As they manipulate the Parks to secure better lives for themselves, class tension escalates, and the twisted plan spirals out of control. This thrilling social satire unveils the depths of inequality and the inevitable clash between wealth and poverty.",
                cover = R.drawable.parasite_cover
            ),
            Movie(
                filmTitle = "Pulp Fiction",
                genre = "Crime",
                duration = "2h 34m",
                ageRating = "17+",
                synopsis = "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in a chaotic yet stylish blend of dark humor and intense drama. Through a series of interconnected stories, Pulp Fiction explores themes of redemption, loyalty, and fate, all set against the gritty underworld of Los Angeles. Each character’s journey leads to unexpected and unforgettable outcomes.",
                cover = R.drawable.pulp_fiction_cover
            ),
            Movie(
                filmTitle = "The Matrix",
                genre = "Sci-Fi",
                duration = "2h 16m",
                ageRating = "17+",
                synopsis = "Computer hacker Neo discovers the truth about his reality: it's a simulated world controlled by machines that enslave humanity. With the guidance of Morpheus, he joins a rebellion to liberate human minds. As he embraces his role in the war, Neo confronts questions of identity, choice, and the meaning of freedom in a dystopian reality.",
                cover = R.drawable.the_matrix_cover
            ),
            Movie(
                filmTitle = "Titanic",
                genre = "Romance",
                duration = "3h 15m",
                ageRating = "13+",
                synopsis = "Set against the backdrop of the infamous maiden voyage of the R.M.S. Titanic, young lovers Jack and Rose come from drastically different social worlds but find connection and hope in each other. Their love blossoms amidst the tragic sinking, and they must fight for survival as the grand ship meets its watery end. Their journey speaks to the triumph of love over adversity.",
                cover = R.drawable.titanic_cover
            ),
            Movie(
                filmTitle = "Schindler's List",
                genre = "Historical",
                duration = "3h 15m",
                ageRating = "17+",
                synopsis = "During the Holocaust, Oskar Schindler, a German businessman, courageously saves over a thousand Jewish refugees from certain death by employing them in his factories. His transformation from a self-interested profiteer to a hero of conscience unfolds against the harrowing realities of World War II, illustrating the profound impact one individual can make in the face of unspeakable atrocities.",
                cover = R.drawable.schindlers_list_cover
            )

        )
    }

}