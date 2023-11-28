package com.example.nesthunt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nesthunt.databinding.ActivitySecondpageBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class secondpage : AppCompatActivity() {
    private lateinit var binding: ActivitySecondpageBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var verificationId: String
    private lateinit var dialog: AlertDialog
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Please wait")
        builder.setTitle("Loading")
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.show()

        val phoneNumber = "+91" + intent.getStringExtra("number")
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    Log.d("Verification", "Verification completed successfully")
                    dialog.dismiss()
                    Toast.makeText(this@secondpage, "Verification Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@secondpage, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }
                override fun onVerificationFailed(p0: FirebaseException) {
                    dialog.dismiss()
                    Toast.makeText(this@secondpage, "Please Try Again", Toast.LENGTH_SHORT).show()
                }

                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(p0, p1)
                    dialog.dismiss()
                    verificationId = p0
                    resendToken=p1
                }
            }).build()
        PhoneAuthProvider.verifyPhoneNumber(options)

        
        binding.resendOtp.setOnClickListener{
            resendOTP()
        }

        binding.button.setOnClickListener {
            val otpText = binding.otp.text.toString().trim()
            if (otpText.isEmpty()) {
                Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show()
            } else {
                val credential =
                    PhoneAuthProvider.getCredential(verificationId, otpText)
                auth.signInWithCredential(credential)
                    .addOnFailureListener {
                        Log.e("Authentication", "Failed: ${it.message}", it)
                        Toast.makeText(this, "Authentication Failed. Please Try Again", Toast.LENGTH_SHORT).show()
                    }
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Successful!!!", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(this, "Error ${it.exception}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
    private fun resendOTP() {
        val phoneNumber = "+91" + intent.getStringExtra("number")
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    // Handle verification completion if needed
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    // Handle verification failure if needed
                }

                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(p0, p1)
                    verificationId = p0
                    Toast.makeText(this@secondpage, "OTP resent", Toast.LENGTH_SHORT).show()
                }
            })
            .setForceResendingToken(resendToken) // This token is obtained during the initial OTP request
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}