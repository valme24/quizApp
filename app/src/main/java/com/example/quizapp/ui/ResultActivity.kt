package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.MainActivity

import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var username :String
    private  var score : Int = 0
    private  var totalQuestions : Int = 0

    private lateinit var scoreView : TextView
    private lateinit var usernameView : TextView
    private lateinit var totalQuestionsView : TextView
    private lateinit var finishButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        scoreView = findViewById(R.id.score_view)
        usernameView = findViewById(R.id.username_view)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        username = intent.getStringExtra(Constants.USER_NAME).toString()
        score = intent.getIntExtra(Constants.SCORE,0)

        scoreView.text = "Your Score is $score out of $totalQuestions"
        usernameView.text = "Congratulations $username"

        finishButton = findViewById(R.id.finish_button)
        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also{
                startActivity(it)


            }

        }

        }
    }
