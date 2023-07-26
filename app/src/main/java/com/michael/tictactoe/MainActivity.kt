package com.michael.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.michael.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.restButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun buttonClick(view: View) {
        val buttonSelected: Button = view as Button
        var cellId = 0

        when (buttonSelected.id) {
            R.id.B1 -> cellId = 1
            R.id.B2 -> cellId = 2
            R.id.B3 -> cellId = 3
            R.id.B4 -> cellId = 4
            R.id.B5 -> cellId = 5
            R.id.B6 -> cellId = 6
            R.id.B7 -> cellId = 7
            R.id.B8 -> cellId = 8
            R.id.B9 -> cellId = 9
        }

        playGame(cellId, buttonSelected)
    }

    var activePlayer = 1
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()
    fun playGame(cellId: Int, buttonSelected: Button) {
        if (activePlayer == 1) {
            binding.winnerTextView.text = " Player 2 Turn "
            buttonSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
            buttonSelected.setBackgroundColor(Color.YELLOW)
        } else {
            binding.winnerTextView.text = " Player 1 Turn "
            buttonSelected.text = "O"
            player2.add(cellId)
            activePlayer = 1
            buttonSelected.setBackgroundColor(Color.BLUE)
        }
        buttonSelected.isEnabled = false
        win()
    }

    fun win() {
        var whoWonTheGame = 0 //draw(neither player 1 nor player 2 won the game)

        //1 2 3
        //4 5 6
        //7 8 9
        when {
            // when player 1 wins:
            //horizontal
            binding.B4.text == "X" && binding.B5.text == "X" && binding.B6.text == "X" -> whoWonTheGame = 1
            binding.B7.text == "X" && binding.B8.text == "X" && binding.B9.text == "X" -> whoWonTheGame = 1
            binding.B3.text == "X" && binding.B5.text == "X" && binding.B7.text == "X" -> whoWonTheGame = 1
            //diagonal
            binding.B1.text == "X" && binding.B5.text == "X" && binding.B9.text == "X" -> whoWonTheGame = 1
            binding.B1.text == "X" && binding.B2.text == "X" && binding.B3.text == "X" -> whoWonTheGame = 1
            //vertical
            binding.B1.text == "X" && binding.B4.text == "X" && binding.B7.text == "X" -> whoWonTheGame = 1
            binding.B2.text == "X" && binding.B5.text == "X" && binding.B8.text == "X" -> whoWonTheGame = 1
            binding.B3.text == "X" && binding.B6.text == "X" && binding.B9.text == "X" -> whoWonTheGame = 1

            // when player 2 wins:
            //horizontal
            binding.B4.text == "O" && binding.B5.text == "O" && binding.B6.text == "O" -> whoWonTheGame = 2
            binding.B7.text == "O" && binding.B8.text == "O" && binding.B9.text == "O" -> whoWonTheGame = 2
            binding.B3.text == "O" && binding.B5.text == "O" && binding.B7.text == "O" -> whoWonTheGame = 2
            //diagonal
            binding.B1.text == "O" && binding.B5.text == "O" && binding.B9.text == "O" -> whoWonTheGame = 2
            binding.B1.text == "O" && binding.B2.text == "O" && binding.B3.text == "O" -> whoWonTheGame = 2
            //vertical
            binding.B1.text == "O" && binding.B4.text == "O" && binding.B7.text == "O" -> whoWonTheGame = 2
            binding.B2.text == "O" && binding.B5.text == "O" && binding.B8.text == "O" -> whoWonTheGame = 2
            binding.B3.text == "O" && binding.B6.text == "O" && binding.B9.text == "O" -> whoWonTheGame = 2
        }

        when {
            whoWonTheGame == 0 && player1.size + player2.size == 9 -> binding.winnerTextView.text = "Draw"
            whoWonTheGame == 1 -> binding.winnerTextView.text = "Player 1 won"
            whoWonTheGame == 2 -> binding.winnerTextView.text = "Player 2 won"
        }
    }

}