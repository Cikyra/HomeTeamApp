package com.cikyra.hometeam.compose.features.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.cikyra.hometeam.compose.nav.AppRoutes
import com.cikyra.hometeam.data.repo.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Hilt is kotlin wrapper around Dagger, Dagger is a Dependency Injection (DI) library
// SOLID principles
@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    homeScreenRepo: HomeScreenRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val exampleId: AppRoutes.HomeScreen = savedStateHandle.toRoute<AppRoutes.HomeScreen>()

    val greeting = homeScreenRepo.returnGreeting()
}

