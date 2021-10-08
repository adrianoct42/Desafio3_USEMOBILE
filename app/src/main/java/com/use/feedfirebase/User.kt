package com.use.feedfirebase

import android.widget.ImageView

data class User(
    val name: String,
    val number_posts: Int,
    val post: List<Post>
)