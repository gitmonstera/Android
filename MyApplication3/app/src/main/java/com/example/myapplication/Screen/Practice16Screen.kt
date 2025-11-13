package com.example.myapplication.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Practice16Screen() {
    var currentStep by remember { mutableStateOf(1) }
    var calculatorValue by remember { mutableStateOf("0") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Практика 16 - Программные Views") })
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
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 1: Programmed TextView",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Hello Programmed-View!",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .background(Color(0xFFE8F5E8))
                                .padding(8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            if (currentStep >= 2) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 2: 10 TextViews циклом",
                            style = MaterialTheme.typography.titleMedium
                        )
                        LazyColumn(
                            modifier = Modifier.height(200.dp)
                        ) {
                            items(10) { index ->
                                Text(
                                    "TextView $index",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp)
                                        .background(
                                            Color(
                                                Random.nextFloat(),
                                                Random.nextFloat(),
                                                Random.nextFloat(),
                                                0.3f
                                            )
                                        )
                                        .padding(8.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
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
                            "Шаг 3: 10 кнопок",
                            style = MaterialTheme.typography.titleMedium
                        )
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.height(200.dp)
                        ) {
                            items(10) { index ->
                                Button(
                                    onClick = { },
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .height(40.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF2196F3)
                                    )
                                ) {
                                    Text("Кнопка $index")
                                }
                            }
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
                            "Шаг 4-5: Калькулятор",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            calculatorValue,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .background(Color(0xFFF5F5F5))
                                .padding(16.dp),
                            textAlign = TextAlign.End,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        val buttons = listOf(
                            "7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "0", "C", "=", "+"
                        )

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            modifier = Modifier.height(300.dp)
                        ) {
                            items(buttons) { button ->
                                Button(
                                    onClick = {
                                        when (button) {
                                            "C" -> calculatorValue = "0"
                                            "=" -> {
                                                calculatorValue = "52"
                                            }
                                            else -> {
                                                if (calculatorValue == "0") {
                                                    calculatorValue = button
                                                } else {
                                                    calculatorValue += button
                                                }
                                            }
                                        }
                                    },
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .height(60.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = when (button) {
                                            "C" -> Color(0xFFF44336)
                                            "=" -> Color(0xFF4CAF50)
                                            else -> Color(0xFF2196F3)
                                        }
                                    ),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        button,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
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
                            "Шаг 6: Стили для элементов",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                            ) {
                                Text("Красная")
                            }

                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                            ) {
                                Text("Зеленая")
                            }

                            Button(
                                onClick = { },
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 10.dp,
                                    pressedElevation = 2.dp
                                )
                            ) {
                                Text("С тенью")
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Text(
                                "Жирный текст",
                                fontWeight = FontWeight.Bold,
                                color = Color.Blue
                            )
                            Text(
                                "Курсивный текст",
                                fontStyle = FontStyle.Italic,
                                color = Color.Green
                            )
                            Text(
                                "Большой текст",
                                fontSize = 24.sp,
                                color = Color.Red
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

                Text("Шаг $currentStep/6", modifier = Modifier.align(Alignment.CenterVertically))

                Button(
                    onClick = { if (currentStep < 6) currentStep++ },
                    enabled = currentStep < 6
                ) {
                    Text("Вперед")
                }
            }
        }
    }
}