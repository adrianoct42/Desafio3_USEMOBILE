package com.use.feedfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FeedAdapter (
    private val posts: List<Post>, private val function: (post: Post) -> Unit
) : RecyclerView.Adapter<FeedAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // QUARTO
        fun bindPosts(post: Post) {

        }
    }

    // SEGUNDO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.rv_feed, parent, false)
        )
    }

    // PRIMEIRO
    override fun getItemCount(): Int {
        return posts.size
    }

    // TERCEIRO
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindPosts(posts[position])
        holder.itemView.setOnClickListener {
            function(posts[position])
        }
    }
}