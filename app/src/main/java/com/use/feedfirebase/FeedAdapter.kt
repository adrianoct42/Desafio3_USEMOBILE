package com.use.feedfirebase

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

// SHIFT F6 muda todos os nomes selecionados

class FeedAdapter: RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private var posts: List<Post> = emptyList()
    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // QUARTO
        fun bindPosts(post: Post) {
            Log.d("FeedAdapter", "TO NO ADAPTEEEEEER")
            // USANDO BINDING: binding.text_postagem_rv.text = post.textoDaPostagem
            itemView.findViewById<TextView>(R.id.texto_postagem_rv).text = post.textoDaPostagem
        }
    }

    // SEGUNDO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.rv_feed, parent, false)
        )
    }

    // PRIMEIRO
    override fun getItemCount(): Int {
        return posts.size
    }

    // TERCEIRO
    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bindPosts(posts[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: List<Post>){
        posts = newList
        notifyDataSetChanged()
    }

}
