package com.example.questionansweringsystem.QuestionAnsweringSystemLogic

import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAndAnswerEntity
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAndTopicEntity


data class QuestionAnsweringStates(

    val questionsAndAnswers: List<QuestionAndAnswerEntity> = emptyList(),
    val question1AndTopics: List<QuestionAndTopicEntity> = emptyList(),
    val question : String = "",
    val question1 : String = "",
    val answer : String = "",
    val topic : String = "",
    val isAddingQuestionAndAnswer : Boolean = false


    )
