package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.pages.AppDetailsScreen
import com.example.myapplication.pages.NavigationMenu
import com.example.myapplication.pages.PrintListApps
import com.example.myapplication.repository.Routes
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.repository.Repository

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = Repository.readData(this)
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
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.homeScreen,
                        builder = {
                            composable("ListApps") {
                                PrintListApps(
                                    modifier = Modifier.padding(paddingValues),
                                    navController,
                                    repository
                                )
                            }
                            composable(Routes.appDetail + "/{id}") {
                                val id = it.arguments?.getString("id")
                                AppDetailsScreen(
                                    modifier = Modifier.padding(paddingValues),
                                    id?.toInt()
                                )

                            }
                        })
                }
            }
        }
    }
}

