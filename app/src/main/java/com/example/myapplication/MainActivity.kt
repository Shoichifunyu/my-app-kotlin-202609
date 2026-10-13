package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Card


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
    val questionCount: Int,
    val targetDate: String,
    val plannedProgress: Int
)



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val studies = listOf(
        Study(
            title = "AWS SAA",
            progress = 65,
            studyHours = 32,
            questionCount = 420,
            targetDate = "2026/9/30",
            plannedProgress = 10
        ),
        Study(
            title = "AWS DEA",
            progress = 65,
            studyHours = 32,
            questionCount = 420,
            targetDate = "2026/9/30",
            plannedProgress = 10

        ),
        Study(
            title = "応用情報技術者",
            progress = 65,
            studyHours = 32,
            questionCount = 420,
            targetDate = "2026/9/30",
            plannedProgress = 10
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
        }
    }
}

@Composable
fun StudyCard(study: Study) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            InfoRow(
                label = "進捗",
                value = "${study.progress}%"
            )
            InfoRow(
                label = "計画進捗",
                value = "${study.plannedProgress}%"
            )

            InfoRow(
                label = "学習時間",
                value = "${study.studyHours}時間"
            )
            InfoRow(
                label = "問題数",
                value = "${study.questionCount}問"
            )

            InfoRow(
                label = "合格目標日",
                value = study.targetDate
            )
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

@Composable
fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = label)

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(text = value)

    }
}