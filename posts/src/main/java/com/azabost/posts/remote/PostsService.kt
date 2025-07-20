package com.azabost.posts.remote

import com.azabost.posts.remote.model.PostsResponse
import com.azabost.posts.remote.model.UsersResponse
import retrofit2.http.GET

interface PostsService {

    @GET("posts")
    suspend fun getPosts(): PostsResponse

    @GET("users")
    suspend fun getUsers(): UsersResponse

}