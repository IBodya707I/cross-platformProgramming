package com.example.application3.data.posts

import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.service.PostApiService
import com.example.application3.data.posts.PostRepository
import com.example.application3.data.posts.model.responses.Posts
import com.example.application3.data.common.Result
import com.example.application3.data.common.map

internal class AppPostRepository(
    private val postApiService: PostApiService
) : PostRepository {

    override suspend fun getAllPosts(): Result<Posts> {
        return postApiService.getAllPosts()
    }

    override suspend fun addPost(post: NewPost): Result<String> {
        return postApiService.addPost(post).map {
            it.toString()
        }
    }

    override suspend fun updatePost(post: Post): Result<String> {
        return postApiService.updatePost(post).map {
            it.toString()
        }
    }

    override suspend fun deletePost(postId: Int): Result<String> {
        return postApiService.deletePost(postId).map {
            it.toString()
        }
    }
}