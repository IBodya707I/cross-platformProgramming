package com.example.application3.data.posts.model.responses

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val body: String,
    val id: Int,
    val reactions: Reactions,
    val tags: List<String>,
    val title: String,
    val userId: Int,
    val views: Int = 0
)