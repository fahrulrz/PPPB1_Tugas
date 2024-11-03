package com.example.recycleviewfilm

import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewfilm.databinding.FilmCardBinding

class DisasterAdapter(private val listMovie: List<Movie>) : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {
    inner class ItemDisasterViewHolder(private val binding: FilmCardBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(binding.root.context, DetailFilm::class.java)
                    intent.putExtra("movie", listMovie[position]) // Kirim data film ke DetailActivity
                    binding.root.context.startActivity(intent)
                }
            }
        }

        fun bind(data: Movie) {
            with(binding) {
                filmTitle.text = data.filmTitle
                duration.text = data.duration
                ageRating.text = data.ageRating
                filmCover.setImageResource(data.cover)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = FilmCardBinding.inflate(android.view.LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

}



//itemView.setOnClickListener {
//    val intent = Intent(itemView.context, DetailFilm::class.java)
//    intent.putExtra(DetailFilm.EXTRA_DATA, data)
//    itemView.context.startActivity(intent)
//}

