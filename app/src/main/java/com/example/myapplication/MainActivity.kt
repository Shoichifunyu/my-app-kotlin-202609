package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Study(
    val title: String,
    val progress: Int,
    val studyHours: Int,
    val questionCount: Int
)



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val studies = listOf(
        Study(
            title = "AWS SAA",
            progress = 65,
            studyHours = 32,
            questionCount = 420
        ),
        Study(
            title = "AWS DEA",
            progress = 65,
            studyHours = 32,
            questionCount = 420
        ),
        Study(
            title = "応用情報技術者",
            progress = 65,
            studyHours = 32,
            questionCount = 420
        )
    )

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = "Study Dashboard",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        for (study in studies) {
            Text(study.title)
            Text("進捗: ${study.progress}%")
            Text("学習時間: ${study.studyHours}時間")
            Text("問題数: ${study.questionCount}問")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}