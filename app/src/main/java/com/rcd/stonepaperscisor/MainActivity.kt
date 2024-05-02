package com.rcd.stonepaperscisor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var stone: ImageView? = null
    var scissor: ImageView? = null
    var paper: ImageView? = null
    var computer: ImageView? = null
    var player: ImageView? = null
    var comScore = 0
    var playScore = 0
    var computerScore: TextView? = null
    var playerScore: TextView? = null
    var restart: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stone = findViewById(R.id.rock)
        paper = findViewById(R.id.paper)
        scissor = findViewById(R.id.scissors)
        computer = findViewById(R.id.computr)
        player = findViewById(R.id.playr)
        computerScore = findViewById(R.id.computer_score)
        playerScore = findViewById(R.id.player_score)
        restart = findViewById(R.id.restart)
        click()
    }
    fun compareMoves(userMoveResId: Int, computerMoveResId: Int) {
        if ((userMoveResId == R.drawable.scisor && computerMoveResId == R.drawable.paper) ||
            (userMoveResId == R.drawable.rock && computerMoveResId == R.drawable.scisor) ||
            (userMoveResId == R.drawable.paper && computerMoveResId == R.drawable.rock)
        ) {
            playScore++
            playerScore?.text = playScore.toString()


        } else if ((computerMoveResId == R.drawable.scisor && userMoveResId == R.drawable.paper) ||
            (computerMoveResId == R.drawable.rock && userMoveResId == R.drawable.scisor) ||
            (computerMoveResId == R.drawable.paper && userMoveResId == R.drawable.rock)
        ) {
            comScore++
            computerScore?.text = comScore.toString()


        } else {
            computerScore
            playerScore
        }
    }
    @SuppressLint("MissingInflatedId")
    fun click() {
        setContentView(R.layout.activity_main)
        stone = findViewById(R.id.rock)
        paper = findViewById(R.id.paper)
        scissor = findViewById(R.id.scissors)
        computer = findViewById(R.id.computr)
        player = findViewById(R.id.playr)
        computerScore = findViewById(R.id.computer_score)
        playerScore = findViewById(R.id.player_score)
        restart = findViewById(R.id.restart)
        stone?.setOnClickListener {
            computer?.animate()?.apply {
                duration = 500
                rotationYBy(90f)


            }?.withEndAction {
                computer?.animate()?.apply {
                    duration = 500
                    rotationYBy(90f)

                }

            }?.start()
            player?.animate()?.apply {
                duration = 500
                rotationYBy(90f)


            }?.withEndAction {
                player?.animate()?.apply {
                    duration = 500
                    rotationYBy(90f)

                }

            }?.start()
            var random1 = (0..2).random()
            var userMoveResId = R.drawable.rock
            player?.setImageResource(userMoveResId)
            var imageList1 = listOf(R.drawable.rock, R.drawable.paper, R.drawable.scisor)
            var computerMoveResId = imageList1[random1]
            computer?.setImageResource(computerMoveResId)
            compareMoves(userMoveResId, computerMoveResId)
            winner()
        }
        paper?.setOnClickListener {
            computer?.animate()?.apply {
                duration = 500
                rotationYBy(90f)


            }?.withEndAction {
                computer?.animate()?.apply {
                    duration = 500
                    rotationYBy(90f)

                }?.start()
                player?.animate()?.apply {
                    duration = 150
                    rotationYBy(90f)

                }?.withEndAction {
                    player?.animate()?.apply {
                        duration = 150
                        rotationYBy(90f)

                    }

                }?.start()


            }?.start()
            var random2 = (0..2).random()
            var userMoveResId = R.drawable.paper
            player?.setImageResource(userMoveResId)
            var imageList2 = listOf(R.drawable.rock, R.drawable.paper, R.drawable.scisor)
            var computerMoveResId = imageList2[random2]
            computer?.setImageResource(computerMoveResId)
            compareMoves(userMoveResId, computerMoveResId)
            winner()

        }
        scissor?.setOnClickListener {
            computer?.animate()?.apply {
                duration = 500
                rotationYBy(90f)


            }?.withEndAction {
                computer?.animate()?.apply {
                    duration = 500
                    rotationYBy(90f)

                }

            }?.start()
            player?.animate()?.apply {
                duration = 500
                rotationYBy(90f)


            }?.withEndAction {
                player?.animate()?.apply {
                    duration = 500
                    rotationYBy(90f)

                }

            }?.start()
            var random3 = (0..2).random()
            var userMoveResId = R.drawable.scisor
            player?.setImageResource(userMoveResId)
            var imageList3 = listOf(R.drawable.rock, R.drawable.paper, R.drawable.scisor)
            var computerMoveResId = imageList3[random3]
            computer?.setImageResource(computerMoveResId)
            compareMoves(userMoveResId, computerMoveResId)
            winner()
        }
    }
    fun winner() {
        if (playScore == 5) {
            setContentView(R.layout.activity_main1)
        } else if (comScore == 5) {
            setContentView(R.layout.activity_main2)
        }
    }
    fun restart(view: View) {
        click()
        playScore = 0
        comScore = 0
    }
}




