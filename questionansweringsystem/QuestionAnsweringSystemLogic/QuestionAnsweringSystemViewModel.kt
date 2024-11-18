package com.example.questionansweringsystem.QuestionAnsweringSystemLogic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAndAnswerEntity
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAndTopicEntity
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAnsweringSystemDAO
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringEvents.SetQuestion
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringEvents.SetAnswer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class QuestionAnsweringSystemViewModel(private val dao : QuestionAnsweringSystemDAO) : ViewModel() {

    val _state = MutableStateFlow(QuestionAnsweringStates())

    private val _questionsAndAnswers : Flow<List<QuestionAndAnswerEntity>> = dao.getQuestionsAndAnswers()
    private val _question1AndTopics : Flow<List<QuestionAndTopicEntity>> = dao.getQuestionsAndTopics()

    val state = combine(_state, _questionsAndAnswers, _question1AndTopics){
            state, questionAndAnswers, question1AndTopics ->
            state.copy(
                 questionsAndAnswers = questionAndAnswers,
                 question1AndTopics = question1AndTopics
             )

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), QuestionAnsweringStates())

    fun onEvent(event: QuestionAnsweringEvents){
        when(event){

            is QuestionAnsweringEvents.DeleteQuestionAndAnswer ->{
                viewModelScope.launch {
                    dao.deleteQuestionAndAnswer(event.questionAndAnswer)
                }

            }

            is QuestionAnsweringEvents.DeleteQuestionAndTopic ->{
                viewModelScope.launch {
                    dao.deleteQuestion1AndTopic(event.question1AndTopic)
                }

            }



            is SetQuestion -> {
                _state.update {
                    it.copy(
                        question = event.question
                    )
                }

            }

            is QuestionAnsweringEvents.SetQuestion1 ->{
                _state.update {
                    it.copy(
                        question1 = event.question1
                    )
                }
            }

            is SetAnswer ->{
                _state.update {
                    it.copy(
                        answer = event.answer
                    )
                }
            }

            is QuestionAnsweringEvents.SetTopic ->{
                _state.update{
                    it.copy(
                        topic = event.topic
                    )
                }
            }

            QuestionAnsweringEvents.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingQuestionAndAnswer = true
                    )
                }
            }

            QuestionAnsweringEvents.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingQuestionAndAnswer = false
                    )
                }
            }

            QuestionAnsweringEvents.SaveQuestionAndAnswer -> {
                val question = _state.value.question
                val answer = _state.value.answer


                if(question.isBlank() || answer.isBlank()){
                    return
                }


                val questionAndAnswer = QuestionAndAnswerEntity(
                    question = question,
                    answer = answer,

                )

                viewModelScope.launch {
                    dao.upsertQuestionAndAnswer(questionAndAnswer)
                }

                _state.update {
                    it.copy(
                        isAddingQuestionAndAnswer = false,
                        question = "",
                        answer = "",
                    )
                }




            }

            QuestionAnsweringEvents.SaveQuestionAndTopic -> {
                val question1 = _state.value.question1
                val topic = _state.value.topic


                if(question1.isBlank() || topic.isBlank()){
                    return
                }


                val questionAndTopic = QuestionAndTopicEntity(
                    question1 = question1,
                    topic = topic

                    )

                viewModelScope.launch {
                    dao.upsertQuestion1AndTopic(questionAndTopic)
                }

                _state.update {
                    it.copy(
                        isAddingQuestionAndAnswer = false,
                        question1 = "",
                        topic = ""
                    )
                }




            }


        }
    }






}