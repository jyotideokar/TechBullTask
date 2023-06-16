package com.example.techbullassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.techbullassignment.databinding.RowMovieListItemBinding
import com.example.techbullassignment.model.Search

class MovieAdapter(var list: ArrayList<Search>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            RowMovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameTxt.text = list[position].Title
        holder.binding.yearTxt.text = list[position].Year
        Glide.with(holder.itemView).load(list[position].Poster)
            .into(holder.binding.movieImg)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(var binding: RowMovieListItemBinding) : RecyclerView.ViewHolder(binding.root)

}