package bj1

class Hand(val name: String) {

    //private val _cards: MutableList<Card> = mutableListOf<Card>()
    private val _cards = mutableListOf<Card>()

    fun add(card: Card) {
        //TODO("Not yet implemented")
        _cards.add(card)
    }

    val size get() = _cards.size

    val points: Int get(){
        var t = 0
        for (c in _cards){
            t += c.points
        }
        return t
    }

}