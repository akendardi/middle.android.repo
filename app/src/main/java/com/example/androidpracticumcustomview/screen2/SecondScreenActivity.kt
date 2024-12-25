package com.example.androidpracticumcustomview.screen2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticumcustomview.databinding.ActivitySecondScreenBinding

class SecondScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}