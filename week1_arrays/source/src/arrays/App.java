package arrays;

import arrays.Card.CardType;
import arrays.Card.CardValue;

public class App {

	public static void main(String[] args) {

		Deck deck = new Deck();

		// Weergeef het initiele deck.
		System.out.println("original deck:");
		deck.printDeck();

		// Insert twee kaarten
		deck.insertAt(new Card(CardType.Diamonds, CardValue.Jack), 3);
		deck.insertAt(new Card(CardType.Hearts, CardValue.Ace), 6);
		System.out.println();
		System.out.println("cards inserted, deck:");
		deck.printDeck();

		// Verwijder een kaart
		deck.delete(7);
		System.out.println();
		System.out.println("card deleted, deck:");
		deck.printDeck();

		// Vraag kaart met index 10 op.
		Card card = deck.getCardAt(10);
		System.out.println();
		System.out.println("card at index 10: " + card);

		// Sorteer het deck.
		deck.sort();
		System.out.println();
		System.out.println("sorted deck:");
		deck.printDeck();

		// Zoek de eerder opgevraagde kaart weer op.
		int seqIndex = deck.sequentialSearch(card);
		int binIndex = deck.binarySearch(card);
		System.out.println();
		System.out.println("card: " + card + " binary found at index: " + binIndex + ", sequential found at index: " + +seqIndex);

		// Schud de kaarten.
		deck.shuffle();
		System.out.println();
		System.out.println("shuffled deck:");
		deck.printDeck();
	}
}