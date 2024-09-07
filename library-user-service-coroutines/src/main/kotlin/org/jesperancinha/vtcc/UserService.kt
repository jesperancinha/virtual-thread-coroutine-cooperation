package org.jesperancinha.vtcc

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UserService {
    suspend fun loadUserData(userId: Long) = coroutineScope {
        try {
            val user = withContext(IO) { fetchUser(userId) }
            val postsDeferred = async(IO) { fetchUserPosts(user.id) }
            val commentsDeferred = async(IO) { fetchUserComments(user.id) }
            val posts = postsDeferred.await()
            val comments = commentsDeferred.await()
            val processedData = processUserData(user, posts, comments)
            withContext(IO) {
                updateUI(processedData)
            }
        } catch (e: Exception) {
            handleError(e)
        }
    }

    private suspend fun fetchUser(userId: Long): User {
        delay(1000)
        return User(userId, "John Doe")
    }

    private suspend fun fetchUserPosts(userId: Long): List<Post> {
        delay(1000)
        return listOf(Post("Post 1"), Post("Post 2"))
    }

    private suspend fun fetchUserComments(userId: Long): List<Comment> {
        delay(1000)
        return listOf(Comment("Comment 1"), Comment("Comment 2"))
    }

    private fun processUserData(user: User, posts: List<Post>, comments: List<Comment>): ProcessedData {
        return ProcessedData(user, posts, comments)
    }

    private fun updateUI(data: ProcessedData) {
        logger.info("This is the data $data")
    }

    private fun handleError(e: Exception) {
        logger.error("An error occurred while processing user data", e)
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(UserService::class.java)
    }
}
