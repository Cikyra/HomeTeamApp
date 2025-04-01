package com.cikyra.hometeam

import android.app.Application
import android.content.SharedPreferences
import com.cikyra.hometeam.data.datasource.local.HomeTeamLocalDataSource
import com.cikyra.hometeam.data.model.domain.Announcement
import com.cikyra.hometeam.data.model.domain.Event
import com.cikyra.hometeam.data.model.domain.School
import com.cikyra.hometeam.utils.AppPreferences
import com.cikyra.hometeam.utils.now
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import java.util.UUID
import javax.inject.Inject
import androidx.core.content.edit
import com.cikyra.hometeam.data.model.domain.User

@HiltAndroidApp
class MainApplication: Application() {

    @Inject lateinit var localDataSource: HomeTeamLocalDataSource
    @Inject lateinit var sharedPreferences: SharedPreferences

    override fun onCreate() {
        super.onCreate()

        // val isFirstLaunch = sharedPreferences.getBoolean(AppPreferences.FIRST_LAUNCH, true)
        val runSeedDB = false // toggle true/false to seed
        if (runSeedDB) {
            CoroutineScope(Dispatchers.IO).launch {
                seedDB()
            }

            sharedPreferences.edit() { putBoolean(AppPreferences.FIRST_LAUNCH, false) }
        }
    }

    private suspend fun seedDB() {
        val school = School(
            id = UUID.randomUUID().toString(),
            name = "Jujutsu High",
            address = "145 SomewhereInTokyo",
            classes = emptyList(),
            events = emptyList(),
            announcements = emptyList(),
            users = emptyList(),
            levels = emptyList(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        localDataSource.createSchool(school)

        val announcement = Announcement(
            id = UUID.randomUUID().toString(),
            schoolId = school.id,
            title = "Gojo is still alive",
            subtitle = "Copium",
            body = "MAPPA will fix this",
            photoUrl = null,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        localDataSource.createAnnouncement(announcement)

        val event = Event(
            id = UUID.randomUUID().toString(),
            schoolId = school.id,
            title = "Come See Ethan Impulse Buy a SteamDeck",
            subtitle = "Who needs a laptop!",
            body = "The cats will love watching the gameplay on the tv!",
            photoUrls = emptyList(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        localDataSource.createEvent(event)

        val userExists = sharedPreferences.getString(AppPreferences.CURRENT_USER_ID, null)
        if (userExists == null) {
            val user = User(
                id = UUID.randomUUID().toString(),
                schoolIds = listOf(school.id),
                name = "Gojo Satoru",
                photoUrl = "https://butwhytho.net/wp-content/uploads/2023/09/Gojo-Jujutsu-Kaisen-But-Why-Tho-2.jpg",
                children = listOf(),
                registeredEvents = listOf(event.id),
                registeredClasses = listOf(),
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )

            localDataSource.createUser(user)

            sharedPreferences.edit() { putString(AppPreferences.CURRENT_USER_ID, user.id) }
        }

    }
}