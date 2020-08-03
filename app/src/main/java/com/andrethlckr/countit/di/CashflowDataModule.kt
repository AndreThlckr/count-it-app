package com.andrethlckr.countit.di

import com.andrethlckr.countit.data.cashflow.CashFlowRepositoryImpl
import com.andrethlckr.countit.data.cashflow.source.firestore.FirestoreCashFlow
import com.andrethlckr.countit.data.cashflow.source.firestore.FirestoreCashFlowDataSource
import com.andrethlckr.countit.data.cashflow.source.firestore.FirestoreCashFlowDataSourceImpl
import com.andrethlckr.countit.data.cashflow.source.firestore.FirestoreCashFlowMapper
import com.andrethlckr.countit.domain.cashflow.CashFlow
import com.andrethlckr.countit.domain.cashflow.CashFlowRepository
import com.andrethlckr.countit.domain.common.mapper.AbstractMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class CashflowDataModule {

    @Binds
    abstract fun bindFirestoreCashFlowMapper(
        firestoreCashFlowMapper: FirestoreCashFlowMapper
    ): AbstractMapper<CashFlow, FirestoreCashFlow>

    @Binds
    @Singleton
    abstract fun bindFirestoreCashFlowDataSource(
        firestoreCashFlowDataSourceImpl: FirestoreCashFlowDataSourceImpl
    ): FirestoreCashFlowDataSource

    @Binds
    abstract fun bindCashFlowRepository(
        cashFlowRepositoryImpl: CashFlowRepositoryImpl
    ): CashFlowRepository

    @Provides
    @Singleton
    fun provideIoDispatcher() = Dispatchers.IO
}