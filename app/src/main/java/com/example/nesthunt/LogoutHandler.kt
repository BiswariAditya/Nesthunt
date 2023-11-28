package com.example.nesthunt

import android.content.Context
import android.content.Intent
import com.google.firebase.auth.FirebaseAuth

class LogoutHandler(private val context: Context) {
    fun performLogout() {
        clearUserCredentials()
        navigateToLoginScreen()
    }
    private fun clearUserCredentials() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(context, loginpage::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }
}