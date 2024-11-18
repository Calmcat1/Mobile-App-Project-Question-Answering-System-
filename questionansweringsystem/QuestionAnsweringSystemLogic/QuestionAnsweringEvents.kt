package com.example.questionansweringsystem.QuestionAnsweringSystemLogic


import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAndAnswerEntity
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAndTopicEntity


interface QuestionAnsweringEvents {
    object SaveQuestionAndAnswer: QuestionAnsweringEvents
    object SaveQuestionAndTopic: QuestionAnsweringEvents

    data class SetQuestion (val question : String) : QuestionAnsweringEvents
    data class SetQuestion1(val question1 : String) : QuestionAnsweringEvents
    data class SetAnswer (val answer : String) : QuestionAnsweringEvents
    data class SetTopic(val topic: String) : QuestionAnsweringEvents


    object ShowDialog : QuestionAnsweringEvents
    object HideDialog : QuestionAnsweringEvents

    data class DeleteQuestionAndAnswer(val questionAndAnswer: QuestionAndAnswerEntity) : QuestionAnsweringEvents
    data class DeleteQuestionAndTopic(val question1AndTopic: QuestionAndTopicEntity) : QuestionAnsweringEvents

}