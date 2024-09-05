package org.jesperancinha.vtcc

data class User(val id: Long, val name: String)
data class Post(val content: String)
data class Comment(val content: String)
data class ProcessedData(val user: User, val posts: List<Post>, val comments: List<Comment>)
