package com.example.application3.data.posts

import com.example.application3.data.common.Result
import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.model.responses.Posts

internal interface PostRepository {
    suspend fun getAllPosts(): Result<Posts>
    suspend fun addPost(post: NewPost): Result<String>
    suspend fun updatePost(post: Post): Result<String>
    suspend fun deletePost(postId: Int): Result<String>
}