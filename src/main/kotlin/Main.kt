fun main(args: Array<String>) {

    deckShuffler(deckBuilder()).forEach(::println)

}

enum class Suit() {
    Spade, Club, Heart, Diamond
}

enum class Rank(val value: Int) {
    Ace(1), Two(2), Three(3), Four(4), Five(5),
    Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10),
    Queen(10), King(10)
}

data class Card(val suit: Suit, val rank: Rank)

fun deckBuilder(): List<Card> {
    return List(Suit.values().size) { suit ->
        List(Rank.values().size) { rank ->
            Card(
                Suit.values()[suit],
                Rank.values()[rank]
            )
        }
    }.flatten()
}

/* deckShuffler works by accepting a deck, the deck is copied into a mutable list mutableDeck
 * the mutableDeck serves as a stack, a List is created of size mutableDeck, the elements are
 * made up of random pops of the mutableDeck, the random number is generated based on the current
 * size of the mutableDeck (flexible), this avoids redundant cycles.
 */
fun deckShuffler(deck: List<Card>): List<Card> {

    val mutableDeck = deck.toMutableList()

    return List(mutableDeck.size) { mutableDeck.removeAt(Math.random().times(mutableDeck.size).toInt()) }

}