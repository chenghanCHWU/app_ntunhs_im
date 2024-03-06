package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.Guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num:Int
        val MAXIMUM:Int=100
        var maximum:Int =MAXIMUM
        var minimum:Int =0
        var secret: Int = Random().nextInt(maximum)+1


        guess_button.setOnClickListener{
            validate_num=editText.text.toString().toInt()-secret
            var ans_str: String="你猜對了喔"

            if(validate_num>0){
                maximum=editText.text.toString().toInt()
                ans_str=minimum.toString()+"-"+maximum.toString()
            }else if(validate_num<0){
                minimum=editText.text.toString().toInt()
                ans_str=minimum.toString()+"-"+maximum.toString()
            }

            textView.text=ans_str
        }

        reset_button.setOnClickListener{
            maximum=MAXIMUM
            minimum=0
            secret = Random().nextInt(maximum)+1
            textView.text=minimum.toString()+"-"+maximum.toString()
        }
    }
}