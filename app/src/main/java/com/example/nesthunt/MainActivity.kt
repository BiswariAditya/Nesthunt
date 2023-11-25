package com.example.nesthunt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesthunt.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            startActivity(Intent(this, loginpage::class.java))
            finish()
        }
        adapter = adapter(dataInput.getData(), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
//        **********************NOT WORKING*********************
//        adapter.setOnClickListener(object : View.OnClickListener {
//            fun onClick(position: Int, model: dataInput?) {
//                val intent = Intent(this@MainActivity, clickingPage::class.java)
//                startActivity(intent)
//            }
//
//            override fun onClick(p0: View?) {
//                TODO("Not yet implemented")
//            }
//        })


    }
}