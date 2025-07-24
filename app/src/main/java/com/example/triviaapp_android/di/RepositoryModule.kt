package com.example.triviaapp_android.di


import com.example.triviaapp_android.data.contracts.StatsRepository
import com.example.triviaapp_android.data.contracts.TriviaRepository
import com.example.triviaapp_android.data.repository.StatsRepositoryImpl
import com.example.triviaapp_android.data.repository.TriviaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTriviaRepository(
        impl: TriviaRepositoryImpl
    ): TriviaRepository

    @Binds @Singleton
    abstract fun bindStatsRepository(
        impl: StatsRepositoryImpl
    ): StatsRepository
}
