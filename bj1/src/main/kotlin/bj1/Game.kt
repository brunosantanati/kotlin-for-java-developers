package bj1

//Blackjack Rules:
//https://bicyclecards.com/how-to-play/blackjack/
//https://www.casinocenter.com/rules-strategy-blackjack/

/*
MAIN RULES

OBJECT OF THE GAME
Each participant attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21.

BOTH BUST
If both the dealer and player bust, the player loses.

THE PLAY
The player to the left goes first and must decide whether to "stand" (not ask for another card) or "hit"
(ask for another card in an attempt to get closer to a count of 21, or even hit 21 exactly).
Thus, a player may stand on the two cards originally dealt to them, or they may ask the dealer for additional cards,
one at a time, until deciding to stand on the total (if it is 21 or under), or goes "bust" (if it is over 21). In the latter case,
the player loses and the dealer collects the bet wagered. The dealer then turns to the next player to their left and serves them in the same manner.

The combination of an ace with a card other than a ten-card is known as a "soft hand," because the player can count the ace as a 1 or 11,
and either draw cards or not. For example with a "soft 17" (an ace and a 6), the total is 7 or 17. While a count of 17 is a good hand,
the player may wish to draw for a higher total. If the draw creates a bust hand by counting the ace as an 11, the player simply counts
the ace as a 1 and continues playing by standing or "hitting" (asking the dealer for additional cards, one at a time).

THE DEALER'S PLAY
When the dealer has served every player, the dealers face-down card is turned up. If the total is 17 or more, it must stand.
If the total is 16 or under, they must take a card. The dealer must continue to take cards until the total is 17 or more,
at which point the dealer must stand. If the dealer has an ace, and counting it as 11 would bring the total to 17 or more (but not over 21),
the dealer must count the ace as 11 and stand. The dealer's decisions, then, are automatic on all plays, whereas the player always
has the option of taking one or more cards.
 */

fun main(){
    //Implementation according to what I understood about the main rules. I'm not sure whether everything is absolutely right.
    val game = Game()
    loop@ while (true){

        clearConsole()

        if(game.ph.points > 21){
            game.stay()
            break@loop
        }else {
            println()
            game.ph.renderHand()
            println()

            println("Choose a option:")
            println("Continue? s/n")
            val userInput = readLine()!!

            when (userInput) {
                "s" -> game.hit()
                "n" -> {
                    game.stay()
                    break@loop
                }
                else -> {
                    println("Invalid Option. Press any key to continue.")
                    readLine()!!
                }
            }
        }
    }

    printGameOverMessages(game)
}

fun clearConsole(){
    for (n in 1..1000) println()
}

private fun printGameOverMessages(game: Game) {
    println()
    println("########## Game finished ##########")
    game.ph.renderHand()
    println()
    game.dh.renderHand()
    println()

    checkWhoWon(game)
}

private fun checkWhoWon(game: Game) {
    if (game.ph.points > 21 && game.dh.points > 21) {
        println("Dealer Won!")
    } else if (game.ph.points > 21) {
        println("Dealer Won!")
    } else if (game.dh.points > 21) {
        println("Player Won!")
    } else if (game.ph.points == game.dh.points) {
        println("Game tied")
    } else if (game.ph.points > game.dh.points) {
        println("Player Won!")
    } else {
        println("Dealer Won!")
    }
}

class Game(shuffle: Boolean = true) {

    val deck = Deck(shuffle)
    val ph = Hand("Player")
    val dh = Hand("Dealer")

    init {
        ph.add(deck.take())
        dh.add(deck.take())
        ph.add(deck.take())
        dh.add(deck.take())
    }

    fun hit() {
        ph.add(deck.take())
    }

    fun stay() {
        while (dh.points < 17) dh.add(deck.take())
    }

}
