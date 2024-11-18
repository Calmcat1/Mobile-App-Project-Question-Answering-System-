package com.example.questionansweringsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAnswerDatabase
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringSystemViewModel
import com.example.questionansweringsystem.QuestionAnsweringSystemUI.MainScreen
import com.example.questionansweringsystem.ui.theme.QuestionAnsweringSystemTheme

class MainActivity : ComponentActivity() {
    private val db by lazy {

        Room.databaseBuilder(
            applicationContext,
            QuestionAnswerDatabase::class.java,
            "Q_A_T_1Database"
        ).build()
    }


    private val viewModel by viewModels<QuestionAnsweringSystemViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return QuestionAnsweringSystemViewModel(db.dao) as T
                }
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestionAnsweringSystemTheme {
                val state by viewModel.state.collectAsState()

                MainScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}

