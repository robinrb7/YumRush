package com.example.epiceats.data.repoImpl

import com.example.epiceats.common.ResultState
import com.example.epiceats.common.USER_COLLECTION
import com.example.epiceats.data.models.UserData
import com.example.epiceats.domain.repo.Repo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class RepoImpl @Inject constructor(
    var firebaseAuth: FirebaseAuth,
    var firebaseFirestore: FirebaseFirestore
): Repo {

    override fun registerWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>
    = callbackFlow{
        trySend(ResultState.Loading)
        firebaseAuth.createUserWithEmailAndPassword(userData.email,userData.password)
            .addOnCompleteListener {it ->
                if(it.isSuccessful){
                    val uid = it.result.user?.uid ?: return@addOnCompleteListener

                    firebaseFirestore.collection(USER_COLLECTION)
                        .document(uid).set(userData)
                        .addOnCompleteListener { it ->
                            if(it.isSuccessful){
                                trySend(ResultState.Success("User Registered Successfully"))
                            }else{
                                if(it.exception != null){
                                    trySend(ResultState.Error(it.exception?.localizedMessage ?: "Unknown Firestore error"))
                                }
                            }
                        }
                }else{
                    if(it.exception != null){
                        trySend(ResultState.Error(it.exception?.localizedMessage?: "Auth Failed"))
                    }
                }
            }

        awaitClose{
            close()
        }
    }

    override fun loginWithEmailAndPassword(userData: UserData): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)
            firebaseAuth.signInWithEmailAndPassword(userData.email, userData.password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        trySend(ResultState.Success("User Logged In Successfully"))
                    } else {
                        if (it.exception != null) {
                            trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                        }
                    }
                }
            awaitClose {
                close()
            }

        }

    }