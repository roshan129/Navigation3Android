package com.roshanadke.navigation3android.data

import androidx.compose.ui.graphics.Color

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val color: Color,
)

val sampleNoteList = List(100) {
    Note(
        id = it,
        title = "Note Title #$it",
        content = "This is the content of note #$it.",
        color = Color(
            red = (0..255).random(),
            green = (0..255).random(),
            blue = (0..255).random(),
            alpha = 255
        )
    )
}