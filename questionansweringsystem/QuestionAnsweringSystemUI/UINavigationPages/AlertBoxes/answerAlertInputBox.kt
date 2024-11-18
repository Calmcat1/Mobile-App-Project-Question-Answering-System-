package com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages.AlertBoxes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringEvents
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringStates


@Composable
fun answerAlertInputBox(
    state : QuestionAnsweringStates,
    onEvent : (QuestionAnsweringEvents) -> Unit
){

    var textInput1 by remember {
        mutableStateOf("")
    }

    AlertDialog(onDismissRequest = {
        onEvent(QuestionAnsweringEvents.HideDialog)
    },
        confirmButton = { /*TODO*/ },
        modifier = Modifier,
        text = {

            LazyColumn(
                contentPadding = PaddingValues(10.dp)
            ) {

                item {

                    TextField(
                        label = { Text(text = "question") },
                        value = state.question,
                        onValueChange = { onEvent(QuestionAnsweringEvents.SetQuestion(it)) },
                        modifier = Modifier
                            .padding(bottom = 20.dp))

                }

                item {
                    TextField(
                        label = { Text(text = "Answer") },
                        value = state.answer,
                        onValueChange = { onEvent(QuestionAnsweringEvents.SetAnswer(it)) },
                        modifier = Modifier
                            .padding(bottom = 20.dp))



                }


                item {
                    Button(onClick = {
                        onEvent(QuestionAnsweringEvents.SaveQuestionAndAnswer)

                    }) {
                        Text(text = "Save")
                    }
                }

            }
        }




    )

}