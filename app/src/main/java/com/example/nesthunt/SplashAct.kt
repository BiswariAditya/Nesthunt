package com.example.nesthunt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation

@Suppress("DEPRECATION")
class SplashAct : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this,loginpage::class.java)
            startActivity(intent)
        },3000)
//        animation()
        }

    fun animation(view: View){
        val anim= AlphaAnimation(0.0f,1.0f)
        anim.duration=1500
        view.startAnimation(anim)
    }
    }