package com.example.castrosincoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CastroSinCoilApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CastroSinCoilApp() {
    Scaffold(
        topBar = { AppTopBar() },
        content = { paddingValues ->
            FeedScreen(modifier = Modifier.padding(paddingValues))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Castrinho Sin Coil",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF33EA8C)
        )
    )
}

@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PostCard(
                username = "j.zanetti",
                profileImageRes = R.drawable.profile,
                postImageRes = R.drawable.landscape,
                description = "ALLEZ INTER"
            )
        }
        item {
            PostCard(
                username = "chelsea",
                profileImageRes = R.drawable.team_image,
                postImageRes = R.drawable.promo_image,
                description = "UP THE CHELS"
            )
        }
    }
}

@Composable
fun PostCard(
    username: String,
    profileImageRes: Int,
    postImageRes: Int,
    description: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF33EA8C)
        ),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = profileImageRes),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = username,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            Image(
                painter = painterResource(id = postImageRes),
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            InteractionBar()
            Text(
                text = description,
                modifier = Modifier.padding(8.dp),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun InteractionBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Favorite, contentDescription = "Like", tint = Color.Red)
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Comment, contentDescription = "Comment")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Share, contentDescription = "Share")
            }
        }
        IconButton(onClick = {}) {
            Icon(Icons.Default.Bookmark, contentDescription = "Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCastroSinCoilApp() {
    CastroSinCoilApp()
}

