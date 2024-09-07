package org.jesperancinha.vtcc

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import org.jesperancinha.vtcc.userservice.Comment
import org.jesperancinha.vtcc.userservice.Post
import org.jesperancinha.vtcc.userservice.ProcessedData
import org.jesperancinha.vtcc.userservice.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicReference

@Service
class UserService {

    val dummySystem: AtomicReference<MutableSet<ProcessedData>> = AtomicReference(mutableSetOf())

    fun getAllUsers() = dummySystem.get().asFlow()

    suspend fun loadUserData(userId: Long) = CoroutineScope(IO).launch {
        val userDeferred = async { fetchUser(userId) }
        val postsDeferred = async { fetchUserPosts(userId) }
        val commentsDeferred = async { fetchUserComments(userId) }
        val user = userDeferred.await()
        val posts = postsDeferred.await()
        val comments = commentsDeferred.await()
        val processedData = processUserData(user, posts, comments)
        updateSytem(processedData)
        logger.info("Complete!")
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

    private fun updateSytem(data: ProcessedData) = run {
        logger.info("This is the data $data")
        dummySystem.get().add(data)
    }

    private fun handleError(e: Exception) {
        logger.error("An error occurred while processing user data", e)
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(UserService::class.java)
    }
}
