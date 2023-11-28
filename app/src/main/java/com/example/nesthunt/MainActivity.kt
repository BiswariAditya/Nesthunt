package com.example.nesthunt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesthunt.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: adapter
    private lateinit var floatingActionButton: FloatingActionButton

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

        adapter.setOnClickListener(object : adapter.OnClickListener {
            override fun onClick(position: Int, model: dataclass) {
                val intent = Intent(this@MainActivity, clickingPage::class.java)
                intent.putExtra("image", model.image)
                intent.putExtra("name", model.name)
                intent.putExtra("rate", model.rate)
                startActivity(intent)
            }
        })
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle the query submission if needed
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                // Assuming dataInput.getData() returns a list of dataclass objects
                val filteredList = dataInput.getData().filter { it.name.contains(newText.orEmpty(), true) }
                adapter.setData(filteredList)
                return true
            }
        })

        floatingActionButton=findViewById(R.id.fab)
        binding.fab.setOnClickListener{
            val intent=Intent(this, bottom_navigate::class.java)
            startActivity(intent)
        }

    }
}
