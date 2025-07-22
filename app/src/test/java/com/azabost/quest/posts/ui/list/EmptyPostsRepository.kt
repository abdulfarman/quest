package com.azabost.quest.posts.ui.list

import com.azabost.posts.model.PostsRepository
import com.azabost.share.Post

class EmptyPostsRepository : PostsRepository {
    override suspend fun getPosts(): List<Post> = emptyList()
    override suspend fun getPost(id: Int): Post? = null
}