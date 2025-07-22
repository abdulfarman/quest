package com.azabost.quest.posts.model

import com.azabost.posts.model.PostsRepository
import com.azabost.share.Post

class SimplePostsRepository(var posts: List<Post>) : PostsRepository {
    override suspend fun getPosts(): List<Post> = posts
    override suspend fun getPost(id: Int): Post? = posts.find { it.id == id }
}