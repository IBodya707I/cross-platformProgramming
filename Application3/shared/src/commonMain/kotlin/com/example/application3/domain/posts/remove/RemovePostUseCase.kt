package com.example.application3.domain.posts.remove

import com.example.application3.data.posts.PostRepository
import com.example.application3.data.common.Result

internal class RemovePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: Int): Result<String> {
        return postRepository.deletePost(postId)
    }
}