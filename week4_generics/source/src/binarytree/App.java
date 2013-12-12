package binarytree;

import java.util.Random;

import data.Card;
import data.Student;
import data.Card.CardType;
import data.Card.CardValue;

/**
 * In deze opdracht programmeer je een Binaire boom. Dit moet je doen door zelf de link-structuur te
 * implementeren. In de boom worden studenten opgeslagen. De knopen in de boom hebben als key het studentnummer
 * van de studenten.
 */
public class App {

	public static void main(String[] args) {

		/**
		 * Students, gebruik voor de students de generieke Key, Value tree met als key de studentnummers.
		 */
		System.out.println("-------------------------------------------- Students --------------------------------------------");

		TreeMap<Integer, Student> bsTree = new TreeMap<>();

		Student s = new Student(4, "");
		bsTree.insert(s.getNumber(), s);

		s = new Student(3, "");
		bsTree.insert(s.getNumber(), s);

		s = new Student(1, "naam-1");
		bsTree.insert(s.getNumber(), s);

		s = new Student(5, "gdsg");
		bsTree.insert(s.getNumber(), s);

		s = new Student(6, "");
		bsTree.insert(s.getNumber(), s);

		s = new Student(2, "");
		bsTree.insert(s.getNumber(), s);

		bsTree.printTree();

		System.out.println();
		System.out.println();
		System.out.println("find item 5: " + bsTree.find(5));

		bsTree.remove(3);

		System.out.println();
		System.out.println("Item removed!");

		bsTree.printTree();

		/**
		 * Cards, gebruik voor de cards de Value(set) tree.
		 */
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------- Cards --------------------------------------------");

		TreeSet<Card> set = new TreeSet<>();

		CardValue[] values = CardValue.values();

		// Shuffle de kaartwaardes (Fisher-Yates) zodat de tree niet maximaal ongebalanceerd is.
		Random rnd = new Random();
		for (int i = values.length - 1; i > 0; i--) {

			int index = rnd.nextInt(i + 1);

			// Simple swap
			CardValue a = values[index];
			values[index] = values[i];
			values[i] = a;
		}

		// Voeg de kaarten toe.
		for (CardValue value : values) {
			set.insert(new Card(CardType.Diamonds, value));
		}

		set.printTree();
	}
}