package com.use.feedfirebase

import android.widget.ImageView

data class User(
    val name: String,
    var numberPosts: Int,
    val post: MutableList<Post>
)