package com.example.questionansweringsystem.QuestionAnsweringSystemUI.UINavDataClass

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItems(
    val title: String,
    val selectedImageIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews : Boolean,
    val badgeCount : Int? = null

)