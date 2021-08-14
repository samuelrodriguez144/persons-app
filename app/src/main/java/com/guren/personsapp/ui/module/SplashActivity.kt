package com.guren.personsapp.ui.module

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.guren.personsapp.R

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut :Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, PersonsActivity::class.java)
            startActivity(intent)

        }, splashTimeOut)
    }
}