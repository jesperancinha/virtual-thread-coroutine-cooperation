package org.jesperancinha.vtcc


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jesperancinha.vtcc.userservice.Comment
import org.jesperancinha.vtcc.userservice.Post
import org.jesperancinha.vtcc.userservice.ProcessedData
import org.jesperancinha.vtcc.userservice.User

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography()
    ) {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    var name by remember { mutableStateOf("") }
    var post by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    // Coroutine scope to handle suspend functions
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            val userId = 1000L
            launch { name = fetchUser(userId).name }
            launch { post = fetchUserPosts(userId).first().content }
            launch { comment = fetchUserComments(userId).first().content }
        }
    }

    // UI Layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Name TextField
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )
        // Post TextField
        OutlinedTextField(
            value = post,
            onValueChange = { post = it },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )
        // Comment TextField
        OutlinedTextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Entered Data:")
        Text(text = "Name: $name")
        Text(text = "Post: $post")
        Text(text = "Comment: $comment")
    }

}


suspend fun fetchUser(userId: Long): User {
    delay(1)
    return User(userId, "John Doe")
}

suspend fun fetchUserPosts(userId: Long): List<Post> {
    delay(1)
    return listOf(Post(userId, "Post 1"), Post(userId, "Post 2"))
}

suspend fun fetchUserComments(userId: Long): List<Comment> {
    delay(1)
    return listOf(Comment(userId, "Comment 1"), Comment(userId, "Comment 2"))
}

fun processUserData(user: User, posts: List<Post>, comments: List<Comment>): ProcessedData {
    return ProcessedData(user, posts, comments)
}

fun handleError(e: Exception) {
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyApp()
}