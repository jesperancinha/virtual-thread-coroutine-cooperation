package org.jesperancinha.vtcc

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.internal.AtomicOp
import kotlinx.coroutines.launch
import org.jesperancinha.vtcc.UserService.Companion.logger
import org.jesperancinha.vtcc.userservice.Comment
import org.jesperancinha.vtcc.userservice.Post
import org.jesperancinha.vtcc.userservice.ProcessedData
import org.jesperancinha.vtcc.userservice.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.Thread.sleep
import java.util.concurrent.StructuredTaskScope.ShutdownOnFailure
import java.util.concurrent.atomic.AtomicReference

@Service
class UserServiceVT {

    val dummySystem: AtomicReference<MutableSet<ProcessedData>> = AtomicReference(mutableSetOf())

    fun getAllUsers() = dummySystem.get()

    fun loadUserData(userId: Long) = ShutdownOnFailure().use { scope ->
        val userDeferred = scope.fork { fetchUser(userId) }
        val postsDeferred = scope.fork { fetchUserPosts(userId) }
        val commentsDeferred = scope.fork {
            fetchUserComments(
                userId
            )
        }
        scope.join()
        scope.throwIfFailed()
        val processedData = processUserData(
            userDeferred.get(), postsDeferred.get(), commentsDeferred.get()
        )
        updateSytem(processedData)
        logger.info("Complete!")
    }

    private fun fetchUser(userId: Long): User {
        sleep(1000)
        return User(userId, "John Doe")
    }

    private fun fetchUserPosts(userId: Long): List<Post> {
        sleep(1000)
        return listOf(Post("Post 1"), Post("Post 2"))
    }

    private fun fetchUserComments(userId: Long): List<Comment> {
        sleep(1000)
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
        val logger: Logger = LoggerFactory.getLogger(UserServiceVT::class.java)
    }
}
