package com.azabost.quest.posts.ui.list

import com.azabost.posts.model.PostsRepository
import com.azabost.share.Post

class FailingPostsRepository : PostsRepository {
    override suspend fun getPosts(): List<Post> = throw RuntimeException("Network error")
    override suspend fun getPost(id: Int): Post? = throw RuntimeException("Network error")
}