 package com.cikyra.hometeam.data.repo

 import android.content.SharedPreferences
 import com.cikyra.hometeam.data.datasource.local.HomeTeamLocalDataSource
 import com.cikyra.hometeam.data.repo.features.home.HomeScreenRepository
 import com.cikyra.hometeam.data.repo.features.home.impl.HomeScreenRepositoryImpl
 import com.cikyra.hometeam.data.repo.features.schedule.ScheduleRepository
 import com.cikyra.hometeam.data.repo.features.schedule.impl.ScheduleRepositoryImpl
 import dagger.Module
 import dagger.Provides
 import dagger.hilt.InstallIn
 import dagger.hilt.components.SingletonComponent
 import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideHomeScreenRepository(localDataSource: HomeTeamLocalDataSource): HomeScreenRepository {
        return HomeScreenRepositoryImpl(localDataSource)
    }

    @Singleton
    @Provides
    fun provideScheduleRepository(localDataSource: HomeTeamLocalDataSource, sharedPreferences: SharedPreferences): ScheduleRepository {
        return ScheduleRepositoryImpl(localDataSource, sharedPreferences)
    }
}