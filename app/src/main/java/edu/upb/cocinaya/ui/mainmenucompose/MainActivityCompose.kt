package edu.upb.cocinaya.ui.mainmenucompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import edu.upb.cocinaya.model.Post
import edu.upb.cocinaya.ui.mainmenu.tabs.feed.FeedViewModel
import edu.upb.cocinaya.ui.mainmenucompose.ui.theme.CocinaYaTheme


enum class MainScreenTabs {
    PROFILE,
    FEED,
    CHAT
}

class MainActivityCompose : ComponentActivity() {

    val feedViewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentScreen by mutableStateOf(MainScreenTabs.PROFILE)
            var name by mutableStateOf("Android")
            var posts = feedViewModel.posts.observeAsState()

            CocinaYaTheme {
                Scaffold(
                    topBar = {
                        TopAppBar {
                            Title(name)
                        }
                    },
                    bottomBar = {
                        BottomNavigation {
                            Text("Profile", Modifier.clickable {
                                currentScreen = MainScreenTabs.PROFILE
                                name = "Profile"
                            })
                            Text("Feed", Modifier.clickable {
                                currentScreen = MainScreenTabs.FEED
                                name = "Feed"
                            })
                            Text("Chat", Modifier.clickable {
                                currentScreen = MainScreenTabs.CHAT
                                name = "Chat"
                            })
                        }
                    }
                ) {
                    when(currentScreen) {
                        MainScreenTabs.PROFILE -> ProfileScreen()
                        MainScreenTabs.FEED -> FeedScreen(posts.value ?: listOf())
                        MainScreenTabs.CHAT -> ChatScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Surface(color = Color.Green, modifier = Modifier.fillMaxSize()) {
        Text("Profile")
    }
}

@Composable
fun FeedScreen(posts: List<Post>) {
    val scrollState = rememberScrollState()
    Surface(color = Color.Cyan, modifier = Modifier.fillMaxSize()) {
        Column(Modifier.scrollable(scrollState, Orientation.Vertical)) {
            posts.forEach {
                FeedItem(it)
            }
        }
    }
}

@Composable
fun FeedItem(post: Post) {
    Card(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()) {
        Column {
            Image(
                painter = rememberImagePainter(post.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Text(post.shortDescription, modifier = Modifier.padding(30.dp))
        }
    }
}

@Composable
fun ChatScreen() {
    Surface(color = Color.Yellow, modifier = Modifier.fillMaxSize()) {
        Text("Chat")
    }
}

@Composable
fun Title(name: String) {
    Text(text = "$name!", fontSize = 18.sp, fontWeight = FontWeight.Bold)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CocinaYaTheme {
        Title("Android")
    }
}