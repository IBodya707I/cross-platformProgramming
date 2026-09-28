package com.example.application3.data.posts.service

import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.model.responses.DeletedPost
import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.model.responses.Posts
import com.example.application3.data.common.Result

internal const val BASE_URL = "https://dummyjson.com/"
internal const val POSTS_API = "posts"

internal const val ADD_POST = "add"

interface PostApiService {
    suspend fun getAllPosts(): Result<Posts>
    suspend fun addPost(post: NewPost): Result<Post>
    suspend fun updatePost(post: Post): Result<Post>
    suspend fun deletePost(postId: Int): Result<DeletedPost>
}