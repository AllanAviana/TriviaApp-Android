package com.example.triviaapp_android.data.repository

import android.util.Log
import com.example.triviaapp_android.R
import com.example.triviaapp_android.data.contracts.StatsRepository
import com.example.triviaapp_android.presentation.UIStates.home.HomeUIState
import com.example.triviaapp_android.presentation.UIStates.home.LastPlayedState
import com.example.triviaapp_android.presentation.UIStates.progress.ProgressCard
import com.example.triviaapp_android.presentation.UIStates.progress.ProgressUIState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StatsRepositoryImpl @Inject constructor(
    private val db: FirebaseFirestore,
    private val auth: FirebaseAuth
): StatsRepository {
    /* ------------------------------------------------------------------ */
    /*  Helpers de referências                                            */
    /* ------------------------------------------------------------------ */
    private val uid get() = auth.currentUser?.uid          // String ou null

    private fun statsDoc() =
        uid?.let { db.collection("users").document(it) }
            ?.collection("stats")?.document("default")

    private fun lastPlayedDoc() =
        uid?.let { db.collection("users").document(it) }
            ?.collection("ui")?.document("lastPlayed")

    /* ------------------------------------------------------------------ */
    /*  Progress / Estatísticas                                           */
    /* ------------------------------------------------------------------ */
    override suspend fun saveStats(state: ProgressUIState) {
        val doc = statsDoc() ?: run {
            Log.w("StatsRepo", "saveStats cancelado – user==null")
            return
        }

        val data = mapOf(
            "points"   to state.points,
            "progress" to state.progress,
            "medal"    to state.medal,
            "cardList" to state.cardList.map { card ->
                mapOf(
                    "category"  to card.category,
                    "image"     to card.image,
                    "gameCount" to card.gameCount,
                    "score"     to card.score
                )
            }
        )
        withContext(Dispatchers.IO) { doc.set(data, SetOptions.merge()).await() }
    }

    override suspend fun loadStats(): ProgressUIState? {
        Log.d("StatsRepo", uid.toString())
        val doc = statsDoc() ?: return null
        return try {
            val snap = doc.get().await()
            if (!snap.exists()) return null

            val points   = snap.getLong("points")?.toInt() ?: 0
            val progress = snap.getDouble("progress")?.toFloat() ?: 0f
            val medal    = (snap.getLong("medal") ?: R.drawable.medal).toInt()
            val list     = (snap["cardList"] as? List<Map<String, Any?>>)?.map { m ->
                ProgressCard(
                    category  = m["category"]  as String,
                    image     = (m["image"]     as Long).toInt(),
                    gameCount = (m["gameCount"] as Long).toInt(),
                    score     = (m["score"]     as Long).toInt()
                )
            } ?: emptyList()

            ProgressUIState(progress = progress, points = points,
                medal = medal, cardList = list)

        } catch (e: Exception) {
            Log.w("StatsRepo", "loadStats falhou", e)
            null
        }
    }

    /* ------------------------------------------------------------------ */
    /*  Last-Played                                                       */
    /* ------------------------------------------------------------------ */
   override suspend fun saveLastPlayed(homeState: HomeUIState) {
        Log.d("StatsRepo", uid.toString())

        val doc = lastPlayedDoc() ?: run {
            Log.w("StatsRepo", "saveLastPlayed cancelado – user==null")
            return
        }

        val lp = homeState.lastPlayed
        val data = mapOf(
            "category"   to lp.category,
            "categoryId" to lp.categoryId,
            "image"      to lp.image,
            "mainImage"  to lp.mainImage,
            "isPlayed"   to homeState.isPlayed
        )
        withContext(Dispatchers.IO) { doc.set(data, SetOptions.merge()).await() }
    }

    override suspend fun loadLastPlayed(): HomeUIState? {
        val doc = lastPlayedDoc() ?: return null
        return try {
            val snap = doc.get().await()
            if (!snap.exists()) return null

           val lastPlayed = LastPlayedState(
                category   = snap.getString("category") ?: "",
                categoryId = snap.getLong("categoryId")?.toInt() ?: 0,
                image      = (snap.getLong("image")     ?: 0).toInt(),
                mainImage  = (snap.getLong("mainImage") ?: 0).toInt()
            )

            val isPlayed = snap.getBoolean("isPlayed") ?: false

            HomeUIState(lastPlayed = lastPlayed, isPlayed = isPlayed)

        } catch (e: Exception) {
            Log.w("StatsRepo", "loadLastPlayed falhou", e)
            null
        }
    }
}
