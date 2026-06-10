package com.example.application3.data.posts.model.requests

import com.example.application3.data.posts.model.responses.Reactions
import kotlinx.serialization.Serializable

@Serializable
data class NewPost(
    val body: String = "",
    val reactions: Reactions,
    val tags: List<String> = emptyList(),
    val title: String = "",
    val userId: Int,
    val views: Int = 0
)