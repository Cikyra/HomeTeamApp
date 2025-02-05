 package com.cikyra.hometeam.data.repo

 import com.cikyra.hometeam.data.repo.impl.HomeScreenRepositoryImpl
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