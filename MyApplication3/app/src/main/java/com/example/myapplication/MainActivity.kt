package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Screen.Practice13Screen
import com.example.myapplication.Screen.Practice14Screen
import com.example.myapplication.Screen.Practice15Screen
import com.example.myapplication.Screen.Practice16Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticesAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {
                    composable("main") { MainScreen(navController) }
                    composable("practice13") { Practice13Screen() }
                    composable("practice14") { Practice14Screen() }
                    composable("practice15") { Practice15Screen() }
                    composable("practice16") { Practice16Screen() }
                }
            }
        }
    }
}

@Composable
fun PracticesAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: androidx.navigation.NavHostController) {
    val practices = listOf(
        "Практическая работа 13 - Основы Views",
        "Практическая работа 14 - Расположение элементов",
        "Практическая работа 15 - Layouts",
        "Практическая работа 16 - Программное создание Views"
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Практические работы") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(practices) { practice ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = {
                        when (practice) {
                            practices[0] -> navController.navigate("practice13")
                            practices[1] -> navController.navigate("practice14")
                            practices[2] -> navController.navigate("practice15")
                            practices[3] -> navController.navigate("practice16")
                        }
                    }
                ) {
                    Text(
                        text = practice,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}