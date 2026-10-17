package com.example.myapplication

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import coil3.compose.AsyncImage

@Composable
fun AppDetailsScreen(modifier: Modifier) {

    Column(modifier) {
        IconApp(icon = R.drawable.icon, modifier = Modifier.align(Alignment.CenterHorizontally))
        TitleApp(Modifier.padding(top = 10.dp, start = 15.dp, end = 15.dp))
        CompanyName(Modifier.padding(bottom = 7.dp, start = 15.dp, end = 15.dp))
        Download(Modifier.height(45.dp).padding(start = 15.dp, end = 15.dp))

        Screenshot(modifier = Modifier.padding(top = 20.dp),
            screenshotList = listOf(
                R.drawable.vkscrenshot1,
                R.drawable.vkscrenshot2,
                R.drawable.vkscrenshot3,
                R.drawable.vkscren4,
            )
        )

    }
}

@Composable
private fun Screenshot(
    screenshotList: List<Int>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()).padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            screenshotList.forEach {
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
private fun IconApp(modifier: Modifier = Modifier, icon: Int) {

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
            Text(text = "Скачать")
        }
    }
}

@Composable
private fun TitleApp(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = "ВКонтакте: чаты, видео, музыка",
        textAlign = TextAlign.Center,

        )
}

@Composable
private fun CompanyName(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = "VK",
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
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item,
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}

@Composable
private fun Describe(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxHeight(),
        text = "ВКонтакте — это общение, бесплатные звонки, мессенджер и чат, музыка и видео, игры и мини-приложения для любых задач, десятки миллионов людей и безграничные возможности для развлечений, бизнеса и обмена новостями из любой точки мира.\n" +
                "\n" +
                "Отправляйте сообщения.\n" +
                "В мессенджере можно общаться не только с друзьями ВКонтакте, но и с контактами из вашей телефонной книги. Не забывайте заводить знакомства в соцсети и использовать мессенджер для общения! В чатах есть видеосообщения, персональные стикеры, яркие фоны, исчезающие и голосовые сообщения.\n" +
                "\n" +
                "Звоните бесплатно.\n" +
                "В звонках ждёт общение без ограничений. Собирайте сколько угодно людей, включайте камеры и разговаривайте в видеозвонках, не думая о времени.\n" +
                "\n" +
                "Открывайте новую музыку и слушайте любимые треки.\n" +
                "В библиотеке VK Музыки каждый найдёт что-то своё: от популярных хитов до первых альбомов начинающих талантов. Подобрать саундтрек под настроение помогут рекомендации — подборки собирают и люди, и алгоритмы. А с подпиской музыка будет производиться офлайн - музыка без ограничений с VK.\n" +
                "\n" +
                "Выбирайте, что посмотреть, в VK Видео.\n" +
                "На платформе есть фильмы и сериалы, мультфильмы и телешоу, ролики пользователей и эксклюзивные проекты. Ролики можно сохранить себе и смотреть видео без интернета. А высокое качество даже у мемов из нулевых — благодаря технологии NeuroHD.\n" +
                "\n" +
                "Когда хочется отвлечься от дел, заходите в «Клипы».\n" +
                "Здесь собраны вертикальные видео на любые темы: развлекательные, образовательные, о культуре, искусстве, спорте. Кстати, вы тоже можете стать автором — нужен только телефон с камерой и приложение ВКонтакте.\n" +
                "\n" +
                "Станьте частью крупнейшей соцсети в России.\n" +
                "Вы можете завести знакомства и подписаться на обновления пабликов и знаменитостей, найти друзей и писать им сообщения в чат. А ещё поддерживать сообщества или запускать собственные — и демонстрировать свой талант многомиллионной аудитории ВКонтакте.\n" +
                "\n" +
                "Решайте разные повседневные вопросы с помощью одного приложения.\n" +
                "Найти скидки и получить кешбэк можно в VK Чекбэке, а узнать прогноз погоды — в сервисе «Погода». Ещё приложение позволяет оплачивать счета за интернет или телефон, вести дневник своего питомца, весело проводить время, соревноваться с друзьями в играх и многое другое.\n" +
                "\n" +
                "Следите за здоровьем и будьте в форме.\n" +
                "Сервис «Шаги ВКонтакте» подскажет, когда стоит сделать перерыв и прогуляться, а сервис «Бег» поможет начать бегать, поддерживать форму и полезную привычку. В «Тренировках» можно найти упражнения на все группы мышц от профессиональных инструкторов, а питаться сбалансированно поможет «Дневник питания».\n" +
                "\n" +
                "Оформите подписку на VK Музыку.\n" +
                "С подпиской на VK Музыку вы сможете слушать музыку офлайн, без рекламы и сколько угодно в фоновом режиме, а ещё скачивать песни и плейлисты в приложении.\n" +
                "\n" +
                "Социальная сеть \u200B\u200B«ВКонтакте» — это сообщения, бесплатные звонки, мессенджер и чат, музыка и видео, игры и мини-приложения для любых задач, десятки миллионов людей и безграничные возможности для развлечений, бизнеса и обмена новостями из любой точки мира в одной соцсети."
    )
}

