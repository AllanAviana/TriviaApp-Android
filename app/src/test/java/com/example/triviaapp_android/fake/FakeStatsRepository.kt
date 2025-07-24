package com.example.triviaapp_android.fake

import com.example.triviaapp_android.data.contracts.StatsRepository
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import com.example.triviaapp_android.presentation.UIStates.progress.ProgressUIState

class FakeStatsRepository : StatsRepository {
    var saveStatsCalls = 0
    var saveLastPlayedCalls = 0
    var lastSavedStats: ProgressUIState? = null
    var lastSavedHome: HomeUIState? = null

    override suspend fun saveStats(state: ProgressUIState) {
        saveStatsCalls++
        lastSavedStats = state
    }

    override suspend fun loadStats(): ProgressUIState? = null

    override suspend fun saveLastPlayed(homeState: HomeUIState) {
        saveLastPlayedCalls++
        lastSavedHome = homeState
    }

    override suspend fun loadLastPlayed(): HomeUIState? = null
}