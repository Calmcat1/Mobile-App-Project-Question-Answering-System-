package com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringEvents
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringStates
import com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages.AlertBoxes.answerAlertInputBox


@Composable
fun answerNavigationPage(
    state : QuestionAnsweringStates,
    onEvent : (QuestionAnsweringEvents) -> Unit
){

    // main scaffold holding the page
    Scaffold(
        modifier = Modifier
            .background(Color.White)
    ) { innerPadding ->

        if(state.isAddingQuestionAndAnswer == true){
            answerAlertInputBox(state = state, onEvent = onEvent)
        }


        // lazyColumn holding content
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //item  holding the Answers heading
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Answers",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .padding(top = 20.dp)
                        )
                    }
                }

                //Item holding the "+" button for adding answers

                item{
                    Box(){
                        Button( onClick = { onEvent(QuestionAnsweringEvents.ShowDialog) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Delete",
                                tint = Color.Black
                            )
                        }
                    }

                }

                // Item holding the answer content
                items(state.questionsAndAnswers) { answers ->

                    // Box holding the answer content
                    Box(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillParentMaxWidth()

                    ) {
                        
                        // Row holding the answer content except the delete button
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // column holding text elements
                            Column() {
                                Text(
                                    text = "Answers",
                                    modifier = Modifier
                                        .padding(bottom = 10.dp, top = 25.dp, start = 25.dp),
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold

                                )

                                Text(
                                    text = answers.answer,
                                    modifier = Modifier
                                        .padding(bottom = 10.dp, start = 25.dp)
                                )

                                // Row holding the 'delete item elements

                                Row(){

                                    Button( onClick = { onEvent(QuestionAnsweringEvents.DeleteQuestionAndAnswer(answers)) },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete",
                                            tint = Color.White
                                        )
                                    }
                                }


                            }

                        }



                    }
                }

            }

    }


}