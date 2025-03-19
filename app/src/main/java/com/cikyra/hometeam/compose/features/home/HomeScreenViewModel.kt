package com.cikyra.hometeam.compose.features.home

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.cikyra.hometeam.compose.nav.AppRoutes
import com.cikyra.hometeam.data.model.domain.Announcement
import com.cikyra.hometeam.data.model.domain.Event
import com.cikyra.hometeam.data.repo.features.home.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

// Hilt is kotlin wrapper around Dagger, Dagger is a Dependency Injection (DI) library
// SOLID principles
@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    homeScreenRepo: HomeScreenRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val exampleId: AppRoutes.Home = savedStateHandle.toRoute<AppRoutes.Home>()

    val uiState: StateFlow<HomeScreenState> = flow {
        emit(HomeScreenState.Loading)
        val announcementsResult = homeScreenRepo.getAnnouncements()
        if(announcementsResult.isFailure) {
            Log.e("HomeScreenViewModel", "Error fetching announcements: ${announcementsResult.exceptionOrNull()?.message}")
            emit(HomeScreenState.Error(announcementsResult.exceptionOrNull()?.message))
        } else {
            emit(HomeScreenState.Loaded(
                announcements = announcementsResult.getOrDefault(emptyList()),
                events = emptyList()
            ))
        }
        val eventsResult = homeScreenRepo.getEvents()
        if(eventsResult.isFailure) {
            Log.e("HomeScreenViewModel", "Error fetching events: ${eventsResult.exceptionOrNull()?.message}")
            emit(HomeScreenState.Error(eventsResult.exceptionOrNull()?.message))
        } else {
            emit(HomeScreenState.Loaded(
                announcements = announcementsResult.getOrDefault(emptyList()),
                events = eventsResult.getOrDefault(emptyList())
            ))
        }
    }.onStart {
        Log.d("HomeScreenViewModel", "Get Announcements Flow Started")
    }.onCompletion { error ->
        if(error != null) {
            Log.e("HomeScreenViewModel", "Error fetching announcements: ${error.message}")
            emit(HomeScreenState.Error(error.message))
        } else {
            Log.d("HomeScreenViewModel", "Successfully fetched!")
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = HomeScreenState.Loading
    )
}

sealed interface HomeScreenState {
    data object Loading : HomeScreenState
    data class Loaded(val announcements: List<Announcement>, val events: List<Event>) : HomeScreenState
    data class Error(val message: String?) : HomeScreenState
}

