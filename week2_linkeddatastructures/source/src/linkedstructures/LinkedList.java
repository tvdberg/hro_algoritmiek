package linkedstructures;

import java.util.NoSuchElementException;

public class LinkedList<E> {

	private Node head;
	private int size;

	/**
	 * Vraag het eerste item van deze list op.
	 */
	public E getFirst() {

		if (head != null) {
			return head.data;
		}
		else {
			return null;
		}
	}

	/**
	 * Vraag het laatste item van deze list op
	 */
	public E getLast() {

		if (head == null) {
			return null;
		}

		Node n = head;
		while (n.next != null) {
			n = n.next;
		}

		return n.data;
	}

	/**
	 * Vraag het item met de meegegeven index op.
	 * 
	 * @param index de index van het item dat moet worden opgevraagd.
	 */
	public E get(int index) {

		int currIndex = 0;

		Node n = head;
		while (n != null) {

			// Item gevonden.
			if (index == currIndex) {
				return n.data;
			}

			currIndex++;
			n = n.next;
		}

		throw new NoSuchElementException("Index niet gevonden!");
	}

	/**
	 * Voeg het meegegeven object aan het begin van de list toe.
	 * 
	 * @param o Het object dat moet worden toegevoegd.
	 */
	public void insertFirst(E o) {

		Node newNode = new Node(o);
		newNode.next = head;
		head = newNode;

		size++;
	}

	/**
	 * Voeg het meegegeven object aan het einde van de list toe.
	 * 
	 * @param o Het object dat moet worden toegevoegd.
	 */
	public void insertLast(E o) {

		// List is leeg, voeg item als eerste item toe.
		if (head == null) {
			insertFirst(o);
		}
		// List is niet leeg, voeg item als laatste item toe.
		else {

			Node n = head;
			while (n.next != null) {
				n = n.next;
			}

			Node newNode = new Node(o);
			n.next = newNode;

			size++;
		}
	}

	/**
	 * Voeg het meegegeven object voor het gespecificeerde object toe aan de list.
	 * 
	 * @param o Het object dat moet worden toegevoegd.
	 * @param before Het object in de list waar het object voor moet worden toegevoegd.
	 */
	public void insertBefore(E o, E before) {

		// Before is gelijk aan eerste item, voeg node aan begin van de list toe.
		if (head != null && head.data.equals(before)) {
			insertFirst(o);
		}
		// Zoek item voor before op en voeg de node toe.
		else {
			Node n = head;
			while (n != null) {

				if (n.next != null && n.next.data.equals(before)) {

					Node newNode = new Node(o);
					newNode.next = n.next;
					n.next = newNode;
					size++;
					return;
				}

				n = n.next;
			}

			// Element niet gevonden.
			throw new NoSuchElementException("Element: '" + before + "' niet gevonden!");
		}
	}

	/**
	 * Voeg het meegegeven object achter het gespecificeerde object toe aan de list.
	 * 
	 * @param o Het object dat moet worden toegevoegd.
	 * @param after Het object in de list waar het object achter moet worden toegevoegd.
	 */
	public void insertAfter(E o, E after) {

		Node n = head;
		while (n != null) {

			if (n.data.equals(after)) {

				Node newNode = new Node(o);
				newNode.next = n.next;
				n.next = newNode;
				size++;
				return;
			}

			n = n.next;
		}

		// Element niet gevonden.
		throw new NoSuchElementException("Element: '" + after + "' niet gevonden!");
	}

	/**
	 * Verwijder het meegegeven object uit de list.
	 * 
	 * @param o Het object dat moet worden verwijderd.
	 */
	public void remove(E o) {

		// Head is gelijk aan te verwijderen item, verwijder eerste item.
		if (head != null && head.data.equals(o)) {
			head = head.next;
			size--;
		}
		// Zoek te verwijderen item op en verwijder deze.
		else {

			Node n = head;
			while (n != null) {

				if (n.next != null && n.next.data.equals(o)) {

					n.next = n.next.next;
					size--;
					return;
				}

				n = n.next;
			}

			// Element niet gevonden.
			throw new NoSuchElementException("Element: '" + o + "' niet gevonden!");
		}
	}

	/**
	 * Verwijder het item op de meegegeven index.
	 */
	public void removeAt(int index) {

		// Index bestaat niet in list.
		if (index >= getSize()) {
			throw new IndexOutOfBoundsException();
		}
		// Head is gelijk aan te verwijderen item, verwijder eerste item.
		if (head != null && index == 0) {
			head = head.next;
			size--;
		}
		// Zoek te verwijderen item op en verwijder deze.
		else {
			int currIndex = 0;

			Node n = head;
			while (n != null) {

				// Item gevonden.
				if (index == (currIndex + 1)) {

					n.next = n.next.next;
					size--;
					return;
				}

				currIndex++;
				n = n.next;
			}

			throw new NoSuchElementException();
		}
	}

	/**
	 * Vraag de lengte van de list op.
	 * 
	 * @return De lengte van de list
	 */
	public int getSize() {

		return this.size;
	}

	/**
	 * Print de list.
	 */
	public void print() {

		Node n = head;
		while (n != null) {
			System.out.println("ListItem: " + n.data);
			n = n.next;
		}
	}

	/**
	 * LinkedList Node.
	 */
	private class Node {

		E data;
		Node next;

		public Node(E data) {

			this.data = data;
		}
	}
}