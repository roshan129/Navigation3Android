package com.roshanadke.navigation3android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.roshanadke.navigation3android.NoteListScreen
import kotlinx.serialization.Serializable

@Serializable
data object NoteListScreen : NavKey

@Serializable
data class NoteDetailScreen(val id: Int) : NavKey

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(NoteListScreen)
    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator(),
        ),
        modifier = modifier,
        entryProvider = { key ->
            when (key) {
                is NoteListScreen -> {
                    NavEntry(
                        key = key,
                    ) {
                        NoteListScreen()
                    }
                }

                is NoteDetailScreen -> {
                    NavEntry(
                        key = key,
                    ) {
                        NoteDetailScreen(id = key.id)
                    }
                }

                else -> throw RuntimeException("Invalid NavKey")
            }
        }
    )

}