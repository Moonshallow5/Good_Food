package com.example.android_map

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_map.ui.theme.Android_MapTheme
import android.widget.Button
import android.content.Intent



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        val buttonRecipes=findViewById<Button>(R.id.button)
        buttonRecipes.setOnClickListener{
            val intent=Intent(this, RecipeActivity::class.java)
            startActivity(intent)
        }

        
    }
}


