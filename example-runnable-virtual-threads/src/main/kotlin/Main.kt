package org.jesperancinha

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

/**
 * TODO() Multiple messaging sending library
 */
class UserViewModel {

    fun loadUserData(userId: String) {
        runBlocking {
            try {
                val user = withContext(IO) { fetchUser(userId) }

                val postsDeferred = async(IO) { fetchUserPosts(user.id) }
                val commentsDeferred = async(IO) { fetchUserComments(user.id) }

                val posts = postsDeferred.await()
                val comments = commentsDeferred.await()

                val processedData = processUserData(user, posts, comments)

                withContext(Main) {
                    updateUI(processedData)
                }
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }

    private suspend fun fetchUser(userId: String): User {
        delay(1000)
        return User(userId, "John Doe")
    }

    private suspend fun fetchUserPosts(userId: String): List<Post> {
        delay(1000)
        return listOf(Post("Post 1"), Post("Post 2"))
    }

    private suspend fun fetchUserComments(userId: String): List<Comment> {
        delay(1000)
        return listOf(Comment("Comment 1"), Comment("Comment 2"))
    }

    private fun processUserData(user: User, posts: List<Post>, comments: List<Comment>): ProcessedData {
        // Process data
        return ProcessedData(user, posts, comments)
    }

    private fun updateUI(data: ProcessedData) {
        // Update UI with processed data
    }

    private fun handleError(e: Exception) {
        // Handle any errors that occur
    }
}

// Data classes
data class User(val id: String, val name: String)
data class Post(val content: String)
data class Comment(val content: String)
data class ProcessedData(val user: User, val posts: List<Post>, val comments: List<Comment>)

fun main() {
    
}