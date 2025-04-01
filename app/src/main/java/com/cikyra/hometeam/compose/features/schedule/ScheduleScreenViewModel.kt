package com.cikyra.hometeam.compose.features.schedule

import androidx.lifecycle.ViewModel
import com.cikyra.hometeam.data.repo.features.schedule.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleScreenViewModel @Inject constructor(
    scheduleScreenRepo: ScheduleRepository
): ViewModel() {

}