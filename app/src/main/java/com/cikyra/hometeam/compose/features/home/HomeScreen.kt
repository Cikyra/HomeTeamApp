package com.cikyra.hometeam.compose.features.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("HOME SCREEN: NAV ID: ${viewModel.exampleId}")

        when (val state = uiState) {
            HomeScreenState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is HomeScreenState.Loaded -> {
                LazyColumn {
                    items(items = state.announcements, key = { announcement -> announcement.id}) { announcement ->
                        ListItem(modifier = Modifier.fillMaxWidth().padding(4.dp).clickable {
                            Log.d("HomeScreen", "Item clicked: ${announcement.subtitle}")
                        },
                            headlineContent = { Text(text = announcement.title)},
                            supportingContent = { Text(text = announcement.body)}
                        )
                    }
                }
            }
            is HomeScreenState.Error -> {
                Toast.makeText(LocalContext.current, "Error loading pantry items: ${state.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
