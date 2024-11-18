package com.example.questionansweringsystem.QuestionAnsweringSystemDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

    @Database(
        entities = [QuestionAndAnswerEntity::class, QuestionAndTopicEntity::class],
        version = 1
    )

    abstract class QuestionAnswerDatabase : RoomDatabase() {
        abstract val dao : QuestionAnsweringSystemDAO


    }
