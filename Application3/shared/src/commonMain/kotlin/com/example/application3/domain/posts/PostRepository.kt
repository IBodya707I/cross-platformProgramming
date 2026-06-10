package com.example.application3.domain.posts

import com.example.application3.data.common.NetworkResult
import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.model.responses.DeletedPost
import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.model.responses.Posts

internal interface PostRepository {
    suspend fun getAllPosts(): NetworkResult<Posts>
    suspend fun addPost(post: NewPost): NetworkResult<Post>
    suspend fun updatePost(post: Post): NetworkResult<Post>
    suspend fun deletePost(postId: Int): NetworkResult<DeletedPost>
}