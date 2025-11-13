package com.example.myapplication.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Practice13Screen() {
    var currentStep by remember { mutableStateOf(1) }
    var messages by remember { mutableStateOf(listOf<String>()) }
    var showSurvey by remember { mutableStateOf(false) }
    var surveyAnswers by remember { mutableStateOf(listOf(false, false, false)) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Практика 13 - Основы Views") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (currentStep >= 1) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 1: Hello World",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Blue
                        )
                        Text("Hello world!", modifier = Modifier.padding(vertical = 8.dp))
                    }
                }
            }

            if (currentStep >= 2) {
                LaunchedEffect(currentStep) {
                    if (currentStep == 2) {
                        messages = emptyList()
                        repeat(5) { index ->
                            delay(1000)
                            messages = messages + "Сообщение ${index + 1}"
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 2: 5 надписей с паузой",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Blue
                        )
                        messages.forEach { message ->
                            Text(message, modifier = Modifier.padding(4.dp))
                        }
                    }
                }
            }

            if (currentStep >= 3) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 3: Кнопка для смены надписей",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Blue
                        )
                        Button(
                            onClick = {
                                messages = List(5) { "Новое сообщение ${it + 1}" }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                        ) {
                            Text("Сменить надписи")
                        }
                    }
                }
            }

            if (currentStep >= 4) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 4: Кнопка с картинкой",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Blue
                        )
                        IconButton(
                            onClick = {
                                messages = List(5) { "Сообщение от иконки ${it + 1}" }
                            },
                            modifier = Modifier
                                .size(64.dp)
                                .background(Color.Cyan, CircleShape)
                        ) {
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = "Обновить",
                                tint = Color.White
                            )
                        }
                    }
                }
            }

            if (currentStep >= 7) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 7: Опрос с вариантами ответа",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Blue
                        )

                        Text("Выберите правильные утверждения:")

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = surveyAnswers[0],
                                onCheckedChange = { surveyAnswers = surveyAnswers.toMutableList().apply { set(0, it) } }
                            )
                            Text("Android использует Java/Kotlin")
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = surveyAnswers[1],
                                onCheckedChange = { surveyAnswers = surveyAnswers.toMutableList().apply { set(1, it) } }
                            )
                            Text("Compose - это новый UI toolkit")
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = surveyAnswers[2],
                                onCheckedChange = { surveyAnswers = surveyAnswers.toMutableList().apply { set(2, it) } }
                            )
                            Text("iOS лучше Android")
                        }

                        Button(
                            onClick = { showSurvey = true },
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text("Проверить ответы")
                        }

                        if (showSurvey) {
                            val correct = surveyAnswers[0] && surveyAnswers[1] && !surveyAnswers[2]
                            Text(
                                if (correct) "✅ Все верно!" else "❌ Есть ошибки!",
                                modifier = Modifier.padding(top = 8.dp),
                                color = if (correct) Color.Green else Color.Red
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { if (currentStep > 1) currentStep-- },
                    enabled = currentStep > 1
                ) {
                    Text("Назад")
                }

                Text("Шаг $currentStep/7", modifier = Modifier.align(Alignment.CenterVertically))

                Button(
                    onClick = { if (currentStep < 7) currentStep++ },
                    enabled = currentStep < 7
                ) {
                    Text("Вперед")
                }
            }
        }
    }
}