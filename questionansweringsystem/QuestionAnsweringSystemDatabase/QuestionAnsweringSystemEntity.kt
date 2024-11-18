package com.example.questionansweringsystem.QuestionAnsweringSystemDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "QuestionAndAnswerEntity")
data class QuestionAndAnswerEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val question : String,
    val answer : String,

)

@Entity(tableName = "QuestionAndTopicEntity")
data class QuestionAndTopicEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    val question1 : String,
    val topic : String
)



