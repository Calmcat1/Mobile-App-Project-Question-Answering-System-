package com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavigationPages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun settingsNavigationPage(){

    // main container for the application
    Scaffold {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)


        ) {

            //items for the view
            item {
                Box(
                    modifier = Modifier
                        .padding(start = 30.dp, top = 30.dp)
                ){

                    // columns holding the text box
                    Column {

                        // box holding the settings Cog
                        Box(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(bottom = 20.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(imageVector = Icons.Default.Settings,
                                contentDescription = "settings",
                                modifier = Modifier
                                    .size(50.dp),
                                tint = Color.Gray)

                        }

                        // Box holding text item 1
                        Box(
                            modifier = Modifier
                                .padding(bottom = 20.dp),
                        ) {
                            Text(
                                text = "App Information",
                                fontSize = 30.sp,

                            )
                        }

                        // Box holding text item 2
                        Box(
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        ) {
                            Text(
                                text = "Light Mode",
                                fontSize = 30.sp
                            )
                        }

                        // Box holding text item 3
                        Box(
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        ) {
                            Text(
                                text = "Version no.",
                                fontSize = 30.sp
                            )
                        }
                    }
                }
            }

        }

    }
}