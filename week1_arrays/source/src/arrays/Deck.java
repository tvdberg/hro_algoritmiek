package arrays;

import java.util.Arrays;
import java.util.Random;

import arrays.Card.CardType;
import arrays.Card.CardValue;

public class Deck {

	private Card[] cards;

	public Deck() {

		fillDeck();
	}

	/**
	 * Vult de array met kaarten.
	 */
	private void fillDeck() {

		cards = new Card[12];

		cards[0] = new Card(CardType.Hearts, CardValue.nr8);
		cards[1] = new Card(CardType.Spades, CardValue.nr10);
		cards[2] = new Card(CardType.Hearts, CardValue.nr6);
		cards[3] = new Card(CardType.Diamonds, CardValue.Ace);
		cards[4] = new Card(CardType.Clubs, CardValue.nr2);
		cards[5] = new Card(CardType.Clubs, CardValue.King);
		cards[6] = new Card(CardType.Hearts, CardValue.nr9);
		cards[7] = new Card(CardType.Hearts, CardValue.nr2);
		cards[8] = new Card(CardType.Diamonds, CardValue.nr7);
		cards[9] = new Card(CardType.Spades, CardValue.nr4);
		cards[10] = new Card(CardType.Hearts, CardValue.Jack);
		cards[11] = new Card(CardType.Spades, CardValue.nr1);
	}

	/**
	 * Vraag de kaart op de meegegeven index op.
	 */
	public Card getCardAt(int index) {

		return cards[index];
	}

	/**
	 * Voeg de meegegeven kaart op de meegegeven index toe.
	 * 
	 * @param card De kaart die moet worden toegevoegd.
	 * @param index De index waarop de kaart moet worden toegevoegd.
	 */
	public void insertAt(Card card, int index) {

		Card[] tmp = new Card[cards.length + 1];
		tmp[index] = card;

		System.arraycopy(cards, 0, tmp, 0, index);
		System.arraycopy(cards, index, tmp, index + 1, cards.length - index);

		cards = tmp;
	}

	/**
	 * Verwijder de kaart op de meegegeven index.
	 * 
	 * @param index De index van de kaart die verijwderd moet worden.
	 */
	public void delete(int index) {

		Card[] tmp = new Card[cards.length - 1];

		System.arraycopy(cards, 0, tmp, 0, index);
		System.arraycopy(cards, index + 1, tmp, index, cards.length - index - 1);

		cards = tmp;
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is.
	 */
	public void shuffle() {

		// Fisher-Yates Shuffle implementatie.
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--) {

			int index = rnd.nextInt(i + 1);

			// Simple swap
			Card a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}
	}

	/**
	 * Sorteer de kaarten.
	 */
	public void sort() {

		Arrays.sort(cards);
	}

	/**
	 * Zoek de meegegeven kaart sequentieel op in de array.
	 * 
	 * @param card De kaart die moet worden opgezocht.
	 * @return De index van de gevonden kaart in de array, indien de kaart niet gevonden -1.
	 */
	public int sequentialSearch(Card card) {

		for (int i = 0; i < cards.length; i++) {

			if (cards[i] == card) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Zoek de meegegeven kaart met een binatry search op in de array.
	 * 
	 * @param card De kaart die moet worden opgezocht.
	 * @return De index van de gevonden kaart in de array, indien de kaart niet gevonden -1.
	 */
	public int binarySearch(Card card) {

		int low = 0;
		int high = cards.length - 1;
		int mid;

		while (low <= high) {

			mid = (low + high) / 2;

			// Middelste kaart is kleiner dan meegegeven kaart, zoek aan de rechter kant van het midden.
			if (cards[mid].compareTo(card) < 0) {
				low = mid + 1;
			}
			// Middelste kaart is groter dan meegegeven kaart, zoek aan de linker kant ban het midden.
			else if (cards[mid].compareTo(card) > 0) {
				high = mid - 1;
			}
			// Middelste kaart is gelijk aan meegegeven kaart, kaat gevonden.
			else {
				return mid;
			}
		}

		return -1;
	}

	/**
	 * Print alle kaarten in de output console.
	 */
	public void printDeck() {

		for (Card card : cards) {
			System.out.println(card);
		}
	}
}