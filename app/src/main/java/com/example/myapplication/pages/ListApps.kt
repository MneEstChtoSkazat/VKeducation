package com.example.myapplication.pages


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.myapplication.code.App
import com.example.myapplication.repository.Routes

@Composable
fun PrintListApps(
    modifier: Modifier = Modifier,
    navController: NavController,
    list: List<App>
) {
    LazyColumn(
        modifier
            .padding(top = 10.dp, start = 15.dp, end = 15.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        items(list.size) { index ->
            DrawApp(list[index], navController)
        }
    }
}


@Composable
fun DrawApp(app: App, navController: NavController) {

    Box(Modifier.clickable(onClick = { navController.navigate(Routes.appDetail + "/${app.id}") })) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(end = 15.dp)

                    .size(65.dp)
                    .clip(RoundedCornerShape(17.dp)),
                model = app.iconLink,
                contentDescription = "AppIcon",

                )
            Column(Modifier.weight(1f)) {
                Text(
                    app.appName,
                    maxLines = 1, overflow = TextOverflow.Ellipsis
                )
                Text(text = "☆${app.rating}")
            }
            Button(
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                onClick = {},
                colors = ButtonDefaults.buttonColors(Color(0xFFEBECF1))
            )
            { Text(text = "Скачать", color = Color(0xff1f6bd4)) }
        }


    }
}
