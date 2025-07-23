package com.example.quizapp.utils
import com.example.quizapp.R
import com.example.quizapp.model.Questions

object Constants{
const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val SCORE = "correct answers"

    fun getQuestions(): MutableList<Questions>{
        val questionsList = mutableListOf<Questions>()
        val quest1 = Questions(1,
            "What Country this Falg ",
            R.drawable.antartica,
            "Argentina","America","Antartica","Australia",2
            )
       questionsList.add(quest1)

        val quest2 = Questions(2,
            "What Country this Falg ",
            R.drawable.argentina,
            "Antartica","Benin","Cameroon","Argentina",4
        )
        questionsList.add(quest2)
        val quest3 = Questions(3,
            "What Country this Falg ",
            R.drawable.benin,
            "Antartica","Benin","Cameroon","Argentina",2
        )
        questionsList.add(quest3)
        val quest4 = Questions(4,
            "What Country this Falg ",
            R.drawable.cameroon,
            "Antartica","Benin","Cameroon","Argentina",3
        )
        questionsList.add(quest2)

        return questionsList
    }
}