package com.cikyra.hometeam.compose.features.home

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.cikyra.hometeam.compose.nav.AppRoutes
import com.cikyra.hometeam.data.model.domain.Announcement
import com.cikyra.hometeam.data.repo.features.home.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    val exampleId: AppRoutes.HomeScreen = savedStateHandle.toRoute<AppRoutes.HomeScreen>()

    val uiState: StateFlow<HomeScreenState> = flow {
        emit(HomeScreenState.Loading)
        //delay(3000L)
        val result = homeScreenRepo.getAnnouncements()
        if(result.isFailure) {
            Log.e("HomeScreenViewModel", "Error fetching announcements: ${result.exceptionOrNull()?.message}")
            emit(HomeScreenState.Error(result.exceptionOrNull()?.message))
        } else {
            emit(HomeScreenState.Loaded(result.getOrDefault(emptyList())))
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
    data class Loaded(val announcements: List<Announcement>) : HomeScreenState
    data class Error(val message: String?) : HomeScreenState
}

