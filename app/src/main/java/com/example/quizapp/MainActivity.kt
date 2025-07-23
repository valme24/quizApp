package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.ui.QuestionActivity
import com.example.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.start_button)
        val edittextname : EditText = findViewById(R.id.name)
        button.setOnClickListener {
            if(!edittextname.text.toString().isEmpty()){
                Intent(this@MainActivity, QuestionActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, edittextname.text.toString())
                    startActivity(it)
                    finish()
                }
                }
            else{
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            }

        }


    }
