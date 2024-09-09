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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
    // Use Material 3 Theme
    MaterialTheme(
        colorScheme = lightColorScheme(), // You can customize the color scheme
        typography = Typography()
    ) {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    // State variables for text fields
    var name by remember { mutableStateOf("") }
    var post by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    // UI Layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Outer padding
        verticalArrangement = Arrangement.spacedBy(12.dp) // Spacing between items
    ) {
        // Name TextField
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        // Post TextField
        OutlinedTextField(
            value = post,
            onValueChange = { post = it },
            label = { Text("Post") },
            modifier = Modifier.fillMaxWidth()
        )
        // Comment TextField
        OutlinedTextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text("Comment") },
            modifier = Modifier.fillMaxWidth()
        )
        // Optional: Display entered data
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Entered Data:")
        Text(text = "Name: $name")
        Text(text = "Post: $post")
        Text(text = "Comment: $comment")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyApp()
}
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            WarehouseFulfilmentAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WarehouseFulfilmentAppTheme {
//        Greeting("Android")
//    }
//}