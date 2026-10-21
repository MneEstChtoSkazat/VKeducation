package com.example.myapplication.pages

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.myapplication.code.App
import com.example.myapplication.repository.Repository

@Composable
fun AppDetailsScreen(modifier: Modifier, id: Int?) {
    val app = Repository.data.find { it.id == id }
    Column(modifier.verticalScroll(rememberScrollState())) {
        IconApp(icon = app!!.iconLink, modifier = Modifier.align(Alignment.CenterHorizontally))
        TitleApp(Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp), app)
        CompanyName(Modifier.padding(bottom = 7.dp, start = 15.dp, end = 15.dp), app)
        Download(
            Modifier
                .height(45.dp)
                .padding(start = 15.dp, end = 15.dp)
        )

        Screenshot(
            Modifier.padding(top = 20.dp), app.screenshotsLink
        )

        Description(
            Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp),
            string = app.description
        )

    }
}

@Composable
private fun Screenshot(
    modifier: Modifier = Modifier,
    screenshotList: List<String>?

) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            screenshotList?.forEach {
                Box(
                    modifier = Modifier
                        .size(width = 200.dp, height = 350.dp)


                ) {
                    AsyncImage(
                        contentScale = ContentScale.FillBounds,
                        model = it,
                        contentDescription = "another screen",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        }

    }
}


@Composable
private fun IconApp(modifier: Modifier = Modifier, icon: String) {

    AsyncImage(
        modifier = modifier
            .size(90.dp)
            .clip(RoundedCornerShape(22.dp)),
        model = icon,
        contentDescription = "vkIcon",
        alignment = Alignment.Center,
    )

}

@Composable
private fun Download(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = { },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xff0774fb))
        ) {
            Text(text = "Скачать", color = Color.White)
        }
    }
}

@Composable
private fun TitleApp(modifier: Modifier = Modifier, app: App) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = app.appName,
        textAlign = TextAlign.Center
        )
}

@Composable
private fun CompanyName(modifier: Modifier = Modifier, app: App) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = app.developerName,
        textAlign = TextAlign.Center,
        color = Color.Gray
    )
}

@Composable
fun NavigationMenu(modifier: Modifier = Modifier) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    val items = listOf("Интересное", "Приложения", "Игры", "Киоск", "Моё")
    val selectedIcons =
        listOf(
            Icons.Filled.ThumbUp,
            Icons.Filled.AccountBox,
            Icons.Filled.Favorite,
            Icons.Filled.Build,
            Icons.Filled.Call
        )
    val unselectedIcons =
        listOf(
            Icons.Outlined.ThumbUp,
            Icons.Outlined.AccountBox,
            Icons.Outlined.Favorite,
            Icons.Outlined.Build,
            Icons.Outlined.Call
        )
    NavigationBar(containerColor = Color.White){
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item,
                    )
                },
                label = { Text(item, fontSize = 9.sp) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}

@Composable
fun Description(modifier: Modifier, string: String) {
    Box(modifier) {
        Text(string)
    }
}