package com.example.application3.domain.posts.obtain

import com.example.application3.data.posts.model.responses.Posts
import com.example.application3.data.posts.PostRepository
import com.example.application3.data.common.Result

internal class ObtainPostsUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(): Result<Posts> {
        return postRepository.getAllPosts()
    }
}