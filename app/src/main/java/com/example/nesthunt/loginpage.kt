package com.example.nesthunt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nesthunt.databinding.ActivityLoginpageBinding
import com.google.firebase.auth.FirebaseAuth


class loginpage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginpageBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.button.setOnClickListener {
            if (binding.phoneNumber.text!!.isEmpty()) {
                Toast.makeText(this, "Please enter a correct number", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, secondpage::class.java)
                intent.putExtra("number", binding.phoneNumber.text!!.toString())
                startActivity(intent)
            }
        }
    }
}