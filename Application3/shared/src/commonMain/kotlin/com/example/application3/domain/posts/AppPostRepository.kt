package com.example.application3.domain.posts

import com.example.application3.data.common.NetworkResult
import com.example.application3.data.posts.PostApiService
import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.model.responses.DeletedPost
import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.model.responses.Posts

internal class AppPostRepository(
    private val postApiService: PostApiService
) : PostRepository {

    override suspend fun getAllPosts(): NetworkResult<Posts> {
        return postApiService.getAllPosts()
    }

    override suspend fun addPost(post: NewPost): NetworkResult<Post> {
        return postApiService.addPost(post)
    }

    override suspend fun updatePost(post: Post): NetworkResult<Post> {
        return postApiService.updatePost(post)
    }

    override suspend fun deletePost(postId: Int): NetworkResult<DeletedPost> {
        return postApiService.deletePost(postId)
    }
}