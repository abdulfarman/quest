package com.azabost.posts.model

import com.azabost.share.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post?
}