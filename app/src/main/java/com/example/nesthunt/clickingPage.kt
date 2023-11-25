package com.example.nesthunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nesthunt.databinding.ActivityClickingPageBinding
import com.example.nesthunt.databinding.ActivityLoginpageBinding

class clickingPage : AppCompatActivity() {
    private lateinit var binding: ActivityClickingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}