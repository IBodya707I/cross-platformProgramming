package com.example.application3.domain.posts.create

import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.PostRepository
import com.example.application3.data.common.Result

internal class CreatePostUseCase (
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(post: NewPost): Result<String> {
        return postRepository.addPost(post)
    }
}