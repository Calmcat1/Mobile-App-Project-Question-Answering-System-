package com.example.questionansweringsystem.QuestionAnsweringSystemDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionAnsweringSystemDAO {

    @Upsert
    suspend fun upsertQuestionAndAnswer(questionAndAnswer : QuestionAndAnswerEntity) : Void

    @Upsert
    suspend fun upsertQuestion1AndTopic(questionAndTopic : QuestionAndTopicEntity) : Void



    @Delete
    suspend fun deleteQuestionAndAnswer(questionAndAnswer: QuestionAndAnswerEntity) : Void

    @Delete
    suspend fun deleteQuestion1AndTopic(questionAndAnswer: QuestionAndTopicEntity) : Void



    @Query("SELECT * FROM QuestionAndAnswerEntity")
    fun getQuestionsAndAnswers(): Flow<List<QuestionAndAnswerEntity>>

    @Query("SELECT * FROM QuestionAndTopicEntity")
    fun getQuestionsAndTopics(): Flow<List<QuestionAndTopicEntity>>




}