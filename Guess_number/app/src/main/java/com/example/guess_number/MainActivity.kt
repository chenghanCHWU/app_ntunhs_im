package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guess_button=findViewById<Button>(R.id.Guess_button)

        guess_button.setOnClickListener{
            Log.e("MainActivity","this is error")

        }
    }
}