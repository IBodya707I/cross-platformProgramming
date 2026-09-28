package com.example.application3.data.posts.service

import com.example.application3.data.common.safeRequest
import com.example.application3.data.posts.model.requests.NewPost
import com.example.application3.data.posts.model.responses.Post
import com.example.application3.data.posts.model.responses.Posts
import com.example.application3.data.common.Result
import com.example.application3.data.posts.model.responses.DeletedPost
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class AppPostApiService (
    private val client: HttpClient
) : PostApiService {

    override suspend fun getAllPosts(): Result<Posts> {
        return client.safeRequest {
            get("$BASE_URL$POSTS_API") {
                accept(ContentType.Application.Json)
            }
        }
    }

    override suspend fun addPost(post: NewPost): Result<Post> {
        return client.safeRequest {
            post("$BASE_URL$POSTS_API/$ADD_POST") {
                contentType(ContentType.Application.Json)
                setBody(post)
            }
        }
    }

    override suspend fun updatePost(post: Post): Result<Post> {
        return client.safeRequest {
            put("$BASE_URL$POSTS_API/${post.id}") {
                contentType(ContentType.Application.Json)
                setBody(post)
            }
        }
    }

    override suspend fun deletePost(postId: Int): Result<DeletedPost> {
        return client.safeRequest {
            delete("$BASE_URL$POSTS_API/$postId") {
                accept(ContentType.Application.Json)
            }
        }
    }
}