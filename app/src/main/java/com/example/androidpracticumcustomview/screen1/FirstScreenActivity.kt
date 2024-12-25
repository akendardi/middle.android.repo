package com.example.androidpracticumcustomview.screen1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.androidpracticumcustomview.theme.AndroidPracticumCustomViewTheme
import com.example.androidpracticumcustomview.screen2.SecondScreenActivity
import com.example.androidpracticumcustomview.screen3.ThirdScreenActivity

class FirstScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPracticumCustomViewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstScreenContent(
                        modifier = Modifier.padding(innerPadding),
                        startSecondActivity = {
                            startActivity(
                                Intent(
                                    this,
                                    SecondScreenActivity::class.java
                                )
                            )
                        },
                        startThirdActivity = {
                            startActivity(
                                Intent(
                                    this,
                                    ThirdScreenActivity::class.java
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}