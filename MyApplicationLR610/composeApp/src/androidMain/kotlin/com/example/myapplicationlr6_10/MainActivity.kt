package com.example.myapplicationlr6_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationlr6_10.ui.root.AppScaffold
import com.example.myapplicationlr6_10.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme() {
                AppScaffold()
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AppScaffold()
}