package com.example.coroutinestesting

interface PostRepository {

    suspend fun getPost(): Post

    suspend fun createPost(title: String): Post

    suspend fun getAllPosts(): List<Post>
}