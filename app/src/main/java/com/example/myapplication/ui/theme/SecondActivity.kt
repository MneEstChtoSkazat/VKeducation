package com.example.myapplication.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import com.example.myapplication.AppDetailsScreen
import com.example.myapplication.NavigationMenu
import com.example.myapplication.PrintListApps
import com.example.myapplication.R

class SecondActivity : ComponentActivity() {
    val list = mutableListOf<App>(
        App(R.drawable.icon, "VK", 4.2f),
        App(R.drawable.google, "Google", 4.5f),
        App(R.drawable.reddit, "Reddit", 3.0f),
        App(R.drawable.google_meet, "Google Meet", 5.0f)
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier
                        .padding(), bottomBar = { NavigationMenu() },
                    topBar = {
                        TopAppBar(
                            title = { },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                        contentDescription = "Back Button"
                                    )
                                }
                            }, actions = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.Send,
                                        contentDescription = "right Button"
                                    )
                                }
                            }
                        )
                    }
                ) { paddingValues ->
                    PrintListApps(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(), list
                    )
                }
            }
        }
    }
}