package com.example.guess_number


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())

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

            handler.postDelayed({
                Toast.makeText(this, "5秒後的操作執行了！", Toast.LENGTH_SHORT).show()
            }, 5000)
            validate_num=editText.text.toString().toInt()-secret
            var ans_str: String= getString(R.string.yes_you_got_the_answer)

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

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

}
