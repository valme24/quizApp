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
            "What Country this flag Represent ",
            R.drawable.antartica,
            "Argentina","America","Antartica","Australia",3
            )
       questionsList.add(quest1)

        val quest2 = Questions(2,
            "What Country this flag Represent",
            R.drawable.argentina,
            "Antartica","Benin","Cameroon","Argentina",4
        )
        questionsList.add(quest2)
        val quest3 = Questions(3,
            "What Country this flag Represent ",
            R.drawable.benin,
            "Antartica","Benin","Cameroon","Argentina",2
        )
        questionsList.add(quest3)
        val quest4 = Questions(4,
            "What Country this flag Represent ",
            R.drawable.cameroon,
            "Antartica","Benin","Cameroon","Argentina",3
        )
        questionsList.add(quest4)
        val quest5 = Questions(5,
            "What Country this flag Represent ",
            R.drawable.niger,
            "Niger","Singapore","Russia","Argentina",1
        )
        questionsList.add(quest5)

        val quest6 = Questions(6,
            "What Country this flag Represent ",
            R.drawable.brazil,
            "Malaysia","Brazil","Turkey","Canada",2
        )
        questionsList.add(quest6)

        val quest7 = Questions(7,
            "What Country this flag Represent ",
            R.drawable.bhutan,
            "Mauritius","India","Bhutan","Nigeria",3
        )
        questionsList.add(quest7)

        val quest8 = Questions(8,
            "What Country this flag Represent ",
            R.drawable.sweden,
            "Singapore","UK","Italy","Sweden",4
        )

        questionsList.add(quest8)

        val quest9 = Questions(9,
            "What Country this flag Represent ",
            R.drawable.combodia,
            "Mauritius","India","Cambodia","Canada",3
        )
        questionsList.add(quest9)

        val quest10 = Questions(10,
            "What Country this flag Represent ",
            R.drawable.canada,
            "Spain","Vatican City","Cambodia","Canada",4
        )
        questionsList.add(quest10)








        return questionsList
    }
}