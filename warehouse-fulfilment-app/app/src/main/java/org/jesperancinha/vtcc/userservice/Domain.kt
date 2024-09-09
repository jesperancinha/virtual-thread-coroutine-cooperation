package org.jesperancinha.vtcc.userservice

data class User(val id: Long, val name: String)
data class Post(val id: Long, val content: String)
data class Comment(val id: Long, val content: String)
data class ProcessedData(
    val user: User? = null, val posts: List<Post> = emptyList(), val comments: List<Comment> = emptyList()
)
