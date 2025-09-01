package com.roshanadke.navigation3android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.roshanadke.navigation3android.data.sampleNoteList

@Composable
internal fun NoteDetailsScreenUi(
    id: Int,
    modifier: Modifier = Modifier
) {
    val note = sampleNoteList.find {note ->
        note.id == id
    }
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        note?.let {
            Text("Details for note #${note.title}")
        }
    }
}