package com.example.androidpracticumcustomview.screen3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.androidpracticumcustomview.theme.AndroidPracticumCustomViewTheme

class ThirdScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPracticumCustomViewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ThirdScreenContent(Modifier.padding(innerPadding))
                }
            }
        }
    }
}