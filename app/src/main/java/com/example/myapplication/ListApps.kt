package com.example.myapplication


import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.myapplication.ui.theme.App


@Composable
fun PrintListApps(
    modifier: Modifier = Modifier,
    list: List<App>
) {
    LazyColumn(
        modifier
            .padding(top = 10.dp, start = 15.dp, end = 15.dp)
            .background(Color.Yellow),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        items(list.size) { index ->
            DrawApp(list[index])
        }
    }
}


@Composable
fun DrawApp(app: App) {
    Box() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier

                    .size(65.dp)
                    .clip(RoundedCornerShape(17.dp)),
                model = app.icon,
                contentDescription = "AppIcon",

                )
            Column() {
                Text(app.name)
                Text(text = "☆${app.rating}")
            }
            Button(
                modifier = Modifier.padding(),
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            )
            { Text(text = "Скачать", color = Color.Blue) }
        }

    }
}
