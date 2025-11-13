package com.example.myapplication.Screen


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Practice14Screen() {
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Практика 14 - Расположение элементов") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (currentStep >= 1) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(200.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Green)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            "↖ Левый верх",
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(8.dp)
                                .background(Color.White)
                                .padding(4.dp),
                            color = Color.Red
                        )

                        Text(
                            "Правый верх ↗",
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp)
                                .background(Color.White)
                                .padding(4.dp),
                            color = Color.Blue
                        )

                        Text(
                            "↙ Левый низ",
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(8.dp)
                                .background(Color.White)
                                .padding(4.dp),
                            color = Color.Green
                        )

                        Text(
                            "Правый низ ↘",
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(8.dp)
                                .background(Color.White)
                                .padding(4.dp),
                            color = Color.Magenta
                        )
                    }
                }
            }

            if (currentStep >= 2) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(150.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Green)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            "Верх ↑",
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(8.dp)
                                .border(2.dp, Color.Red, androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                                .padding(4.dp),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            "Низ ↓",
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(8.dp)
                                .border(2.dp, Color.Blue, androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                                .padding(4.dp),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            "← Лево",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(8.dp)
                                .border(2.dp, Color.Green, androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                                .padding(4.dp)
                        )

                        Text(
                            "Право →",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(8.dp)
                                .border(2.dp, Color.Magenta, androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                                .padding(4.dp)
                        )
                    }
                }
            }

            if (currentStep >= 6) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Разные стили текста:",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Обычный текст")

                        Text(
                            "Подчеркнутый текст",
                            style = androidx.compose.ui.text.TextStyle(textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline)
                        )

                        Text(
                            "Курсивный текст",
                            fontStyle = FontStyle.Italic
                        )

                        Text(
                            "Жирный текст",
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "Разноцветный текст",
                            color = Color(0xFF4CAF50)
                        )

                        Text(
                            "Текст разного размера - 12sp",
                            fontSize = 12.sp
                        )
                        Text(
                            "Текст разного размера - 18sp",
                            fontSize = 18.sp
                        )
                        Text(
                            "Текст разного размера - 24sp",
                            fontSize = 24.sp
                        )
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

                Text("Шаг $currentStep/10", modifier = Modifier.align(Alignment.CenterVertically))

                Button(
                    onClick = { if (currentStep < 10) currentStep++ },
                    enabled = currentStep < 10
                ) {
                    Text("Вперед")
                }
            }
        }
    }
}