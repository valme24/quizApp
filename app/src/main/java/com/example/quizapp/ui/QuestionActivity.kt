package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Questions
import com.example.quizapp.utils.Constants

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressbar: ProgressBar
    private lateinit var viewProgress: TextView
    private lateinit var viewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView
    private lateinit var checkButton : Button

    private var questionCounter = 1
    private lateinit var questionList: MutableList<Questions>
    private var selectedOptionPosition = 0
    private lateinit var currentQuestion: Questions
    private var  answered  = false
    private lateinit var username :String
    private  var score : Int = 0
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        progressbar = findViewById(R.id.progressbar)
        viewProgress = findViewById(R.id.textviewprogress)
        viewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById(R.id.flagImage)
        checkButton = findViewById(R.id.check_button)

        option1 = findViewById(R.id.textview_option1)
        option2 = findViewById(R.id.textview_option2)
        option3 = findViewById(R.id.textview_option3)
        option4 = findViewById(R.id.textview_option4)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        // Initialize the property directly
        questionList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionList.size}")
        showNextQuestion()

        if(intent.hasExtra(Constants.USER_NAME)){
            username = intent.getStringExtra(Constants.USER_NAME).toString()

        }

    }

private fun showNextQuestion() {
    resetOptions()
    currentQuestion = questionList[questionCounter - 1]
    flagImage.setImageResource(currentQuestion.image)
    progressbar.progress = questionCounter
    viewProgress.text = "$questionCounter/${progressbar.max}"
    viewQuestion.text = currentQuestion.question
    option1.text = currentQuestion.optionOne
    option2.text = currentQuestion.optionTwo
    option3.text = currentQuestion.optionThree
    option4.text = currentQuestion.optionFour

    if (questionCounter == questionList.size) {
        checkButton.text = "FINISH"
        Intent(this@QuestionActivity, ResultActivity::class.java).also {
            it.putExtra(Constants.USER_NAME, username)
            it.putExtra(Constants.SCORE,score)
            it.putExtra(Constants.TOTAL_QUESTIONS,questionList.size)
            startActivity(it)
            finish()
        }
    } else {
        checkButton.text = "CHECK"
    }
}
    private fun resetOptions(){
        val options = listOf<TextView>(option1, option2, option3, option4)
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.option_bg)

        }

    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        resetOptions()
        selectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_bg)


    }
override fun onClick(v: View?) {
    when (v?.id) {
        R.id.textview_option1 -> selectedOptionView(option1,1)
        R.id.textview_option2 -> selectedOptionView(option2,2)
        R.id.textview_option3 -> selectedOptionView(option3,3)
        R.id.textview_option4 -> selectedOptionView(option4,4)
        R.id.check_button -> {
            if (!answered) {
                // 1. Check answer
                checkAnswer()
                answered = true
            } else {
                // 2. Go to next question or finish
                questionCounter++
                if (questionCounter <= questionList.size) {
                    showNextQuestion()
                    answered = false
                    selectedOptionPosition = 0
                } else {
                    // Finished all questions - handle result or finish activity
                }
            }
        }
    }
}
private fun checkAnswer() {
    answered = true

    if (selectedOptionPosition == currentQuestion.correctAnswer) {
        score++
        when (selectedOptionPosition) {
            1 -> { option1.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
            2 -> { option2.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
            3 -> { option3.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
            4 -> { option4.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
        }
    } else {
        when (selectedOptionPosition) {
            1 -> { option1.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_bg) }
            2 -> { option2.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_bg) }
            3 -> { option3.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_bg) }
            4 -> { option4.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_bg) }
        }
        // Highlight correct answer as well if you want
    }
    checkButton.text = if (questionCounter == questionList.size) "FINISH" else "NEXT"
    showSolution()
}
    private fun showSolution() {
        selectedOptionPosition = currentQuestion.correctAnswer
        when (selectedOptionPosition) {
            1 -> { option1.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
            2 -> { option2.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
            3 -> { option3.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
            4 -> { option4.background = ContextCompat.getDrawable(this, R.drawable.correct_option_bg) }
        }
    }
}
