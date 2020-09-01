package bj1

import java.lang.IllegalStateException

class Card(val value: Int, val suit: Int) {

    init {

        val msg1 = fun(): String {
            return "Bad face"
        }

        val msg2 = fun(): String {
            return "Bad suit"
        }

        require(value in 1..13, msg1)
        require(suit in 1..4, msg2) //throws an IllegalArgumentException
        //check(suit in 1..4) //throws an IllegalStateException
        //assert(suit in 1..4) //require to compile with assertions enabled
    }

    val suitName: String
        get() = when (suit) {
            1 -> "Spades"
            2 -> "Hearts"
            3 -> "Clubs"
            4 -> "Diamonds"
            else -> throw IllegalStateException()
        }

    val valueName: String
        get() = when (value) {
            1 -> "Ace"
            in 2..10 -> value.toString()
            11 -> "Jack"
            12 -> "Queen"
            13 -> "King"
            else -> throw IllegalStateException()
        }

    val name: String get() = "$valueName of $suitName"

    val points: Int
        get() = when (value) {
            in 1..9 -> value
            in 10..13 -> 10
            else -> throw IllegalStateException()
        }
}