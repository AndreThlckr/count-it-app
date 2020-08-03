package com.andrethlckr.countit.di

import com.andrethlckr.countit.domain.usecase.getcashflows.GetCashFlowUseCaseImpl
import com.andrethlckr.countit.domain.usecase.getcashflows.GetCashFlowsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class UseCaseModule{

    @Singleton
    @Binds
    abstract fun bindGetCashFlowsUseCase(
        getCashFlowUseCaseImpl: GetCashFlowUseCaseImpl
    ): GetCashFlowsUseCase
}