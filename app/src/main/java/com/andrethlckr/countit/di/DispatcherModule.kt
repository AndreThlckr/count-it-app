package com.andrethlckr.countit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DispatcherModule {

    @Provides
    @Singleton
    fun provideIoDispatcher() = Dispatchers.IO
}
