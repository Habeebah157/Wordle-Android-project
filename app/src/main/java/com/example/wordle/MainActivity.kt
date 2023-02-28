package com.example.wordle

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord();
    var numberOfGuesses = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessbutton = findViewById<Button>(R.id.button)
        val userguess = findViewById<View>(R.id.guesstexbox) as EditText
        val guessonecheck = findViewById<TextView>(R.id.onecheck)
        val guessone = findViewById<TextView>(R.id.guessone)
        val guesstwo = findViewById<TextView>(R.id.guesstwo)
        val guesstwocheck = findViewById<TextView>(R.id.twocheck)
        val guessthree = findViewById<TextView>(R.id.guessthree)
        val guessthreecheck = findViewById<TextView>(R.id.threecheck)
        val answer = findViewById<TextView>(R.id.answer)

        guessbutton.setOnClickListener{

            if(userguess.length() != 4){
                Toast.makeText(it.context, "Please input a four letter word", Toast.LENGTH_SHORT).show()
            }else{

                var userguess = userguess.text.toString().uppercase();
                if(numberOfGuesses == 0){
                    guessone.text = userguess
                    guessonecheck.text = checkGuess(userguess)
                }else if (numberOfGuesses == 1){
                    guesstwo.text = userguess
                    guesstwocheck.text = checkGuess(userguess)
                }else if(numberOfGuesses == 2){
                    guessthree.text = userguess
                    guessthreecheck.text = checkGuess(userguess)
                }
                numberOfGuesses++


            }
            if (numberOfGuesses == 3){
                answer.text = wordToGuess
            }



        }





    }
    fun checkGuess(guess: String) : String {

        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}