package com.roshanadke.navigation3android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roshanadke.navigation3android.data.Note

@Composable
internal fun NoteListScreenUi(
    modifier: Modifier = Modifier,
    onNoteClick: (Int) -> Unit = {},
    noteList: List<Note>,
) {
    Column(modifier.fillMaxSize()) {
        LazyColumn {
            items(noteList) { item ->
                Text(
                    text = "${item.title}\n${item.content}",
                    modifier = Modifier
                        .background(color = item.color)
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clickable {
                            onNoteClick(item.id)
                        },
                )
            }
        }
    }
}