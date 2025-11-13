package com.example.myapplication.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Practice15Screen() {
    var currentStep by remember { mutableStateOf(1) }
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Практика 15 - Layouts") })
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
                            "Шаг 1: AbsoluteLayout эмуляция",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Red
                        )
                        Text(
                            "Недостатки: элементы накладываются друг на друга, нет адаптивности",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .background(Color.LightGray)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .offset(x = 10.dp, y = 10.dp)
                                    .background(Color(0xFFFF9800)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("1", color = Color.White)
                            }

                            Box(
                                modifier = Modifier
                                    .size(70.dp)
                                    .offset(x = 50.dp, y = 30.dp)
                                    .background(Color(0xFF2196F3)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("2", color = Color.White)
                            }

                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .offset(x = 80.dp, y = 50.dp)
                                    .background(Color(0xFF4CAF50)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("3", color = Color.White)
                            }
                        }
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
                            "Шаг 2: FrameLayout",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Элементы накладываются, последний элемент поверх",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(Color.LightGray)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .align(Alignment.CenterStart)
                                    .background(Color(0xFFFF9800)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Сзади", color = Color.White)
                            }

                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .align(Alignment.Center),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Посередине", color = Color.White)
                            }

                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.CenterEnd)
                                    .background(Color(0xFF4CAF50)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Спереди", color = Color.White)
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
                            "Шаг 3: LinearLayout (Row и Column)",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text("Горизонтальное (Row):", modifier = Modifier.padding(top = 8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            repeat(3) { index ->
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .background(Color(0xFFFF9800)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("$index", color = Color.White)
                                }
                            }
                        }

                        Text("Вертикальное (Column):", modifier = Modifier.padding(top = 8.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            repeat(3) { index ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .background(Color(0xFF2196F3)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Элемент $index", color = Color.White)
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
                        .padding(8.dp)
                        .height(200.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .align(Alignment.Center)
                                .background(Color(0xFF4CAF50)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Центр", color = Color.White)
                        }

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.TopCenter)
                                .offset(y = (-30).dp)
                                .background(Color(0xFFF44336)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Сверху", color = Color.White, fontSize = 12.sp)
                        }

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.CenterEnd)
                                .offset(x = 30.dp)
                                .background(Color(0xFF9C27B0)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Справа", color = Color.White, fontSize = 12.sp)
                        }

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.BottomStart)
                                .offset(x = 30.dp)
                                .background(Color(0xFFFF9800)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Слева снизу", color = Color.White, fontSize = 10.sp)
                        }
                    }
                }
            }

            if (currentStep >= 5) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 5: TableLayout",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Объединенные ячейки: по горизонтали, вертикали, и в обоих направлениях",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Box(
                                    modifier = Modifier
                                        .weight(2f)
                                        .height(50.dp)
                                        .background(Color(0xFFF44336)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Объединено по горизонтали", color = Color.White, fontSize = 12.sp)
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp)
                                        .background(Color(0xFF2196F3)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Ячейка 3", color = Color.White)
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp)
                                        .background(Color(0xFF4CAF50)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Ячейка 4", color = Color.White)
                                }
                            }

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(100.dp)
                                        .background(Color(0xFFFF9800)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Объединено по вертикали", color = Color.White, fontSize = 12.sp)
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp)
                                        .background(Color(0xFF9C27B0)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Ячейка 6", color = Color.White)
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp)
                                        .background(Color(0xFF607D8B)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Ячейка 7", color = Color.White)
                                }
                            }

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(50.dp)
                                        .background(Color(0xFF795548)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Ячейка 8", color = Color.White)
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(2f)
                                        .height(50.dp)
                                        .background(Color(0xFFE91E63)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Объединено по горизонтали и вертикали", color = Color.White, fontSize = 10.sp)
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
                        .padding(8.dp)
                        .height(200.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .size(80.dp)
                                .align(Alignment.Center)
                                .background(Color(0xFF4CAF50)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Центр", color = Color.White)
                        }

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.TopCenter)
                                .offset(y = (-30).dp)
                                .background(Color(0xFFF44336)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Сверху", color = Color.White, fontSize = 12.sp)
                        }

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.CenterEnd)
                                .offset(x = 30.dp)
                                .background(Color(0xFF9C27B0)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Справа", color = Color.White, fontSize = 12.sp)
                        }

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.CenterStart)
                                .offset(x = 20.dp)
                                .background(Color(0xFFFF9800)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Слева", color = Color.White, fontSize = 10.sp)
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
                    Column {
                        Text(
                            "Шаг 7: TabLayout",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(16.dp)
                        )

                        TabRow(selectedTabIndex = selectedTab) {
                            Tab(
                                text = { Text("Вкладка 1") },
                                selected = selectedTab == 0,
                                onClick = { selectedTab = 0 }
                            )
                            Tab(
                                text = { Text("Вкладка 2") },
                                selected = selectedTab == 1,
                                onClick = { selectedTab = 1 }
                            )
                            Tab(
                                text = { Text("Вкладка 3") },
                                selected = selectedTab == 2,
                                onClick = { selectedTab = 2 }
                            )
                        }

                        when (selectedTab) {
                            0 -> Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(Color(0xFFE3F2FD)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Содержимое вкладки 1", color = Color(0xFF1976D2))
                            }
                            1 -> Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(Color(0xFFE8F5E8)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Содержимое вкладки 2", color = Color(0xFF388E3C))
                            }
                            2 -> Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(Color(0xFFFFF8E1)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Содержимое вкладки 3", color = Color(0xFFFFA000))
                            }
                        }
                    }
                }
            }

            if (currentStep >= 8) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 8: Прокручиваемый контент",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Контент больше размера экрана - можно прокручивать",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 8.dp)
                        ) {
                            items(20) { index ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = when (index % 3) {
                                            0 -> Color(0xFFE3F2FD)
                                            1 -> Color(0xFFE8F5E8)
                                            else -> Color(0xFFFFF8E1)
                                        }
                                    )
                                ) {
                                    Text(
                                        "Элемент списка $index с длинным текстом для демонстрации прокрутки",
                                        modifier = Modifier.padding(12.dp),
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            if (currentStep >= 9) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Шаг 9: Комбинированная верстка",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Сочетание разных layout подходов в одном экране",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .background(Color(0xFFFF9800)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Левая 1", color = Color.White)
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .background(Color(0xFF2196F3)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Левая 2", color = Color.White)
                                }
                            }

                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                items(4) { index ->
                                    Box(
                                        modifier = Modifier
                                            .background(Color(0xFF4CAF50))
                                            .fillMaxWidth()
                                            .height(30.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("Сетка ${index + 1}", color = Color.White, fontSize = 12.sp)
                                    }
                                }
                            }
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

                Text("Шаг $currentStep/9", modifier = Modifier.align(Alignment.CenterVertically))

                Button(
                    onClick = { if (currentStep < 9) currentStep++ },
                    enabled = currentStep < 9
                ) {
                    Text("Вперед")
                }
            }
        }
    }
}