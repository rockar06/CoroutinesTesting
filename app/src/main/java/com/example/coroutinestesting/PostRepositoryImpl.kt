package com.example.coroutinestesting

import kotlinx.coroutines.delay

class PostRepositoryImpl : PostRepository {

    private val listOfPosts = mutableListOf<Post>()

    override suspend fun getPost(): Post {
        delay(1000)
        return Post("Title")
    }

    override suspend fun createPost(title: String): Post {
        delay(1000)
        val newPost = Post(title)
        listOfPosts.add(newPost)
        return newPost
    }

    override suspend fun getAllPosts(): List<Post> {
        delay(1000)
        return listOfPosts
    }
}