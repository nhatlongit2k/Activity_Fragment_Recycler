package com.example.lonhatlong_activity_fragment_recycler

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OnBoardingActivity : AppCompatActivity() {

    var userName: String? = null
    var password: String? = null
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        sharedPreferences = getSharedPreferences("onboarding", MODE_PRIVATE)
    }
}