package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

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

    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        item{
            Text(
                text = "Study Dashboard",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(studies) { study ->
            StudyCard(study)
            Text("学習時間: ${study.studyHours}時間")
            Text("問題数: ${study.questionCount}問")
        }
    }
}

@Composable
fun StudyCard(study: Study) {
    Text(text = study.title)
    Text(text = "進捗: ${study.progress}%")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}