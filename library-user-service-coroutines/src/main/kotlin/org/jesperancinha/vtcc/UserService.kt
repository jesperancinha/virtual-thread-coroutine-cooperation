package org.jesperancinha.vtcc

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserService {
    suspend fun loadUserData(userId: Long): ProcessedData =
        runCatching {
            withContext(IO) {
                val user = fetchUser(userId)
                val postsDeferred = async { fetchUserPosts(user.id) }
                val commentsDeferred = async { fetchUserComments(user.id) }
                val posts = postsDeferred.await()
                val comments = commentsDeferred.await()
                val processedData = processUserData(user, posts, comments)
                async {
                    updateUI(processedData)
                }
                processedData
            }

        }.getOrThrow()

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
