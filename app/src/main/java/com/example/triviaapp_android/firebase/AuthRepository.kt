package com.example.triviaapp_android.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth
) {
    suspend fun register(email: String, password: String): Result<FirebaseUser> =
        suspendCancellableCoroutine { cont ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener { cont.resume(Result.success(it.user!!)) }
                .addOnFailureListener { cont.resume(Result.failure(it)) }
        }


    suspend fun login(email: String, password: String): Result<FirebaseUser> =
        suspendCancellableCoroutine { cont ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { cont.resume(Result.success(it.user!!)) }
                .addOnFailureListener { cont.resume(Result.failure(it)) }
        }

    fun isUserLoggedIn(): Boolean = auth.currentUser != null
    fun signOut() = auth.signOut()
}
