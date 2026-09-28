package com.example.application3.domain.posts.edit

import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.PostRepository
import com.example.application3.data.common.Result

internal class EditPostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(post: Post): Result<String> {
        return postRepository.updatePost(post)
    }
}