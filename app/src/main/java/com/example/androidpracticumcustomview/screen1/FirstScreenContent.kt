package com.example.androidpracticumcustomview.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FirstScreenContent(
    startSecondActivity: () -> Unit,
    startThirdActivity: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        ScreenNavigationButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Navigate to XML screen",
            onClick = startSecondActivity
        )
        ScreenNavigationButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Navigate to Compose screen",
            onClick = startThirdActivity
        )
    }
}

@Composable
fun ScreenNavigationButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier, onClick = onClick
    ) {
        Text(
            text = text
        )
    }
}