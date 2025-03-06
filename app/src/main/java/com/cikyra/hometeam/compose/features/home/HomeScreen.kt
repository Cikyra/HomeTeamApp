package com.cikyra.hometeam.compose.features.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.cikyra.hometeam.data.model.domain.Announcement

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        when (val state = uiState) {
            HomeScreenState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is HomeScreenState.Loaded -> {
                HomeScreenContent(announcements = state.announcements)
            }
            is HomeScreenState.Error -> {
                Toast.makeText(LocalContext.current, "Error loading pantry items: ${state.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun HomeScreenContent(announcements: List<Announcement>) {
    Text(stringResource(R.string.my_week), style = MaterialTheme.typography.headlineMedium)
    Row(modifier = Modifier.fillMaxWidth()
        .height(50.dp)
        .padding(top = 2.dp, bottom = 2.dp)
        .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = "Thursday March 6 - 4:30pm",
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
    Row(modifier = Modifier.fillMaxWidth()
        .height(50.dp)
        .padding(top = 2.dp, bottom = 2.dp)
        .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = "Friday March 7 - 5:30pm",
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
    Row(modifier = Modifier.fillMaxWidth()
        .height(50.dp)
        .padding(top = 2.dp, bottom = 2.dp)
        .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            text = "Saturday March 8 - 3:30pm",
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
    Text(stringResource(R.string.announcements), style = MaterialTheme.typography.headlineMedium)
    LazyColumn {
        items(items = announcements, key = { announcement -> announcement.id}) { announcement ->
            ListItem(modifier = Modifier.fillMaxWidth().padding(4.dp).clickable {
                Log.d("HomeScreen", "Item clicked: ${announcement.subtitle}")
            },
                headlineContent = { Text(text = announcement.title)},
                supportingContent = { Text(text = announcement.body)}
            )
        }
    }
    Text(stringResource(R.string.events), style = MaterialTheme.typography.headlineMedium)
    LazyColumn {
        items(items = announcements, key = { announcement -> announcement.id}) { announcement ->
            ListItem(modifier = Modifier.fillMaxWidth().padding(4.dp).clickable {
                Log.d("HomeScreen", "Item clicked: ${announcement.subtitle}")
            },
                headlineContent = { Text(text = announcement.title)},
                supportingContent = { Text(text = announcement.body)}
            )
        }
    }

}
