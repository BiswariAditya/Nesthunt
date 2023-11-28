package com.example.nesthunt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nesthunt.databinding.ActivityClickingPageBinding

@Suppress("DEPRECATION")
class clickingPage : AppCompatActivity() {
    private lateinit var binding: ActivityClickingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name= intent.getParcelableExtra<dataclass>("name")
        if (name!=null){
            binding.hsotelName.text=name.name
            binding.Hostelimage.setImageResource(name.image)
        }

    }

}