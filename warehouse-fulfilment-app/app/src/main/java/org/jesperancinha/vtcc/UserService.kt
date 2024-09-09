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
import java.util.concurrent.atomic.AtomicReference

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
    }

    private suspend fun fetchUser(userId: Long): User {
        delay(1000)
        return User(userId, "John Doe")
    }

    private suspend fun fetchUserPosts(userId: Long): List<Post> {
        delay(1000)
        return listOf(Post(userId, "Post 1"), Post(userId, "Post 2"))
    }

    private suspend fun fetchUserComments(userId: Long): List<Comment> {
        delay(1000)
        return listOf(Comment(userId, "Comment 1"), Comment(userId, "Comment 2"))
    }

    private fun processUserData(user: User, posts: List<Post>, comments: List<Comment>): ProcessedData {
        return ProcessedData(user, posts, comments)
    }

    private fun updateSytem(data: ProcessedData) = run {
        dummySystem.get().add(data)
    }

    private fun handleError(e: Exception) {
    }

}
