package com.azabost.posts.posts.model

import com.azabost.share.share.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post?
}