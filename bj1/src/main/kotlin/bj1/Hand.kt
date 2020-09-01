package bj1

class Hand(val name: String) {

    //private val _cards: MutableList<Card> = mutableListOf<Card>()
    private val _cards = mutableListOf<Card>()

    fun add(card: Card) {
        //TODO("Not yet implemented")
        _cards.add(card)
    }

    val size get() = _cards.size

    val points1: Int get(){
        var t = 0
//        for (c in _cards){
//            t += c.points
//        }
        for (c in _cards) t += c.points //for loop in only one line
        return t
    }

    val points2: Int get(){
        var t = 0
        //_cards.forEach({ t += it.points })
        _cards.forEach { t += it.points } //lambda argument out of parentheses
        return t
    }

    val points get() = _cards.sumBy { it.points }
    
}
