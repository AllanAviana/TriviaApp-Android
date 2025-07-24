package com.example.triviaapp_android.data.contracts

import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import com.example.triviaapp_android.presentation.UIStates.progress.ProgressUIState

interface StatsRepository {
    suspend fun saveStats(state: ProgressUIState)
    suspend fun loadStats(): ProgressUIState?
    suspend fun saveLastPlayed(homeState: HomeUIState)
    suspend fun loadLastPlayed(): HomeUIState?
}