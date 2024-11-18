package com.example.questionansweringsystem.QuestionAnsweringSystemUI

import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringStates
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringSystemViewModel
import com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavDataClass.NavigationBarItems
import com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages.answerNavigationPage
import com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages.questionNavigationPage
import androidx.activity.viewModels
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.example.questionansweringsystem.QuestionAnsweringSystemDatabase.QuestionAnswerDatabase
import com.example.questionansweringsystem.QuestionAnsweringSystemLogic.QuestionAnsweringEvents
import com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages.settingsNavigationPage


@Composable
fun MainScreen(
    state : QuestionAnsweringStates,
    onEvent: (QuestionAnsweringEvents) -> Unit
){


    val items = listOf(
        NavigationBarItems(
            title = "Question",
            selectedImageIcon = Icons.Filled.Edit,
            unselectedIcon = Icons.Outlined.Edit,
            hasNews = false,


            ),

        NavigationBarItems(
            title = "Answer",
            selectedImageIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            hasNews = false,
            badgeCount = 1


        ),

        NavigationBarItems(
            title = "Settings",
            selectedImageIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false,
            badgeCount = 1

        )

    )

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        var selectedItemsIndex by rememberSaveable {
            mutableStateOf(0)
        }

        Scaffold(


            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(selected = selectedItemsIndex == index,
                            onClick = {
                                selectedItemsIndex = index
                                //navController.navigate(item.title)
                            },
                            label = {
                                Text(text = item.title)
                            },
                            icon = {
                                BadgedBox(badge = {
                                    if (item.badgeCount != null){
                                        Badge{
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }
                                    else if (item.hasNews){
                                        Badge()
                                    }
                                }) {
                                    Icon(imageVector = if(index == selectedItemsIndex){
                                        item.selectedImageIcon
                                    } else item.unselectedIcon,
                                        contentDescription = item.title)

                                }
                            }
                        )

                    }
                }
            }
        ) { innerPadding ->

            questionAnsweringSystemScreen(modifier = Modifier.padding(innerPadding), index = selectedItemsIndex, state = state, onEvent = onEvent)
        
        }
    }


}




@Composable
fun questionAnsweringSystemScreen(modifier: Modifier = Modifier,
                                  index: Int,
                                  state: QuestionAnsweringStates,
                                  onEvent: (QuestionAnsweringEvents) -> Unit){

    when(index){
        0 -> questionNavigationPage(state = state, onEvent = onEvent)
        1 -> answerNavigationPage(state = state, onEvent = onEvent)
        2 -> settingsNavigationPage()
    }

}