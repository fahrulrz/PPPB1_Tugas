package com.example.api

import android.content.Intent
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api.databinding.CardProfilBinding
import com.example.api.model.Data

class CardProfileDisaster(private val listUserData: List<Data>): RecyclerView.Adapter<CardProfileDisaster.ItemDisasterAdapterViewHolder>() {

    inner class ItemDisasterAdapterViewHolder(private val binding: CardProfilBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(binding.root.context, DetailUser::class.java)
                    intent.putExtra("user", listUserData[position]) //mengirim data ke DetailUser
                    binding.root.context.startActivity(intent)
                }
            }
        }

        fun bind(data: Data) {
            with(binding) {
                firstName.text = data.firstName
                lastName.text = data.lastName
                email.text = data.email
                Glide
                    .with(binding.root.context)
                    .load(data.avatar)
                    .centerCrop()
                    .into(photoProfile);
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemDisasterAdapterViewHolder {
        val binding = CardProfilBinding.inflate(android.view.LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listUserData.size
    }

    override fun onBindViewHolder(holder: ItemDisasterAdapterViewHolder, position: Int) {
        holder.bind(listUserData[position])
    }
}