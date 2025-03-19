package com.cikyra.hometeam.compose.features.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cikyra.hometeam.R
import com.cikyra.hometeam.compose.composables.HomeTeamHeaderListView
import com.cikyra.hometeam.compose.composables.HomeTeamHeaderListViewItem
import com.cikyra.hometeam.compose.composables.MyWeekView
import com.cikyra.hometeam.data.model.domain.Announcement
import com.cikyra.hometeam.data.model.domain.Event

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

//    Column(
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState())
//    ) {
        when (val state = uiState) {
            HomeScreenState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is HomeScreenState.Loaded -> {
                HomeScreenContent(
                    announcements = state.announcements,
                    events = state.events
                )
            }
            is HomeScreenState.Error -> {
                Log.e("HomeScreen", "Error: ${state.message}")
                Toast.makeText(LocalContext.current, "Error loading HomeScreen", Toast.LENGTH_LONG).show()
            }
        }
//    }
}

@Composable
fun HomeScreenContent(
    announcements: List<Announcement>,
    events: List<Event>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, top = 4.dp, end = 24.dp, bottom = 16.dp)
    ) {
        // MY WEEK
        item {
            MyWeekView()
        }

        // Announcements Section
        item {
            Box(modifier = Modifier.padding(start = 0.dp, top = 24.dp, end = 0.dp, bottom = 0.dp)) {
                HomeTeamHeaderListView(
                    header = stringResource(R.string.announcements),
                    items = announcements.map {
                        HomeTeamHeaderListViewItem(
                            id = it.id,
                            title = it.title,
                            subtitle = it.subtitle
                        )
                    },
                    onItemClicked = { id ->
                        // TODO: Navigate to AnnouncementDetailScreen once it exists
                        Log.d("HomeScreen", "Announcement clicked: $id")
                    },
                    onArrowClicked = {
                        // TODO: Navigate to AllAnnouncementsScreen once it exists
                        Log.d("HomeScreen", "Announcements Arrow Clicked")
                    }
                )
            }
        }

        // Events Section
        item {
            Box(modifier = Modifier.padding(start = 0.dp, top = 16.dp, end = 0.dp, bottom = 0.dp)) {
                HomeTeamHeaderListView(
                    header = stringResource(R.string.events),
                    items = events.map {
                        HomeTeamHeaderListViewItem(
                            id = it.id,
                            title = it.title,
                            subtitle = it.subtitle
                        )
                    },
                    onItemClicked = { id ->
                        // TODO: Navigate to EventDetailScreen once it exists
                        Log.d("HomeScreen", "Event clicked: $id")
                    },
                    onArrowClicked = {
                        // TODO: Navigate to AllEventsScreen once it exists
                        Log.d("HomeScreen", "Events Arrow Clicked")
                    }
                )
            }
        }
    }
}
