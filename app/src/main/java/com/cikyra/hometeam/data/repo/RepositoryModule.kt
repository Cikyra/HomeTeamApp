 package com.cikyra.hometeam.data.repo

 import com.cikyra.hometeam.data.repo.features.home.HomeScreenRepository
 import com.cikyra.hometeam.data.repo.features.home.impl.HomeScreenRepositoryImpl
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
    fun provideHomeScreenRepository(): HomeScreenRepository {
        return HomeScreenRepositoryImpl()
    }
 }