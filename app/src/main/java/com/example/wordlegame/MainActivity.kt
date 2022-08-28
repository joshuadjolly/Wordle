package com.example.wordlegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView13).text=wordToGuess
        findViewById<TextView>(R.id.textView13).visibility= View.GONE
        findViewById<TextView>(R.id.resetButton).visibility= View.GONE
       findViewById<Button>(R.id.button2).setOnClickListener {
           val input = findViewById<EditText>(R.id.inputText).getText().toString()
           inputPopulate(input)
       }
    }

    fun inputPopulate(Answer: String){
        val guess1=findViewById<TextView>(R.id.textView3)
        val guess2=findViewById<TextView>(R.id.textView9)
        val guess3=findViewById<TextView>(R.id.textView11)

        if(Answer.toString().length < 4){
            Toast.makeText(this, "please enter a 4 letter word!", Toast.LENGTH_SHORT).show()
        }else{
            if(guess1.text.isEmpty()){
                val input = findViewById<EditText>(R.id.inputText).getText().toString()
                val word = findViewById<TextView>(R.id.textView3)
                word.text = input
                val check1 = checkGuess(input)

                findViewById<TextView>(R.id.textView8).text = check1
                findViewById<EditText>(R.id.inputText).text.clear()
                if(guess1.text==wordToGuess){
                    Toast.makeText(this, "Congratualtions you guessed right!!!!", Toast.LENGTH_SHORT).show()
                    findViewById<TextView>(R.id.textView13).visibility= View.VISIBLE
                    findViewById<Button>(R.id.button2).isEnabled=false
                    findViewById<TextView>(R.id.resetButton).visibility= View.VISIBLE
                    findViewById<Button>(R.id.resetButton).setOnClickListener {
                        finish()
                        startActivity(getIntent())
                    }
                }

            }else if(guess2.text.isEmpty()){
                val input = findViewById<EditText>(R.id.inputText).getText().toString()
                val word = findViewById<TextView>(R.id.textView9)
                word.text = input
                val check1 = checkGuess(input)

                findViewById<TextView>(R.id.textView10).text = check1
                findViewById<EditText>(R.id.inputText).text.clear()
                if(guess2.text==wordToGuess){
                    Toast.makeText(this, "Congratualtions you guessed right!!!!", Toast.LENGTH_SHORT).show()
                    findViewById<Button>(R.id.button2).isEnabled=false
                    findViewById<TextView>(R.id.resetButton).visibility= View.VISIBLE
                    findViewById<Button>(R.id.resetButton).setOnClickListener {
                        finish()
                        startActivity(getIntent())
                    }
                }

            }else if(guess3.text.isEmpty()){
                val input = findViewById<EditText>(R.id.inputText).getText().toString()
                val word = findViewById<TextView>(R.id.textView11)
                word.text = input
                val check1 = checkGuess(input)

                findViewById<TextView>(R.id.textView12).text = check1
                findViewById<EditText>(R.id.inputText).text.clear()
                if(guess2.text==wordToGuess){
                    Toast.makeText(this, "Congratualtions you guessed right!!!!", Toast.LENGTH_SHORT).show()
                    findViewById<Button>(R.id.button2).isEnabled=false
                    findViewById<TextView>(R.id.resetButton).visibility= View.VISIBLE
                    findViewById<Button>(R.id.resetButton).setOnClickListener {
                        finish()
                        startActivity(getIntent())
                    }
                }

            }
            if((guess1.text.isNotEmpty()) && (guess2.text.isNotEmpty()) && (guess3.text.isNotEmpty())){
                Toast.makeText(this, "You Have ran out of chances!", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.textView13).visibility= View.VISIBLE
                findViewById<TextView>(R.id.resetButton).visibility= View.VISIBLE
                findViewById<Button>(R.id.button2).isEnabled=false
                findViewById<Button>(R.id.resetButton).setOnClickListener {
                    finish()
                    startActivity(getIntent())
                }
            }
        }



    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    //var wordToGuess=FourLetterWordList.getRandomFourLetterWord()
    private fun checkGuess(guess: String): String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            } else if (guess[i] in wordToGuess) {
                result += "+"
            } else {
                result += "X"
            }
        }
        return result
    }
}