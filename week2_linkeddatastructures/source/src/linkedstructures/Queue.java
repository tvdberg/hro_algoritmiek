package linkedstructures;

import java.util.NoSuchElementException;

public class Queue<E> {

	private LinkedList<E> list;

	public Queue() {

		this.list = new LinkedList<>();
	}

	/**
	 * Zet iets in de wachtrij.
	 */
	public void enqueue(E o) {

		this.list.insertLast(o);
	}

	/**
	 * Haal iets van de wachtrij.
	 */
	public E dequeue() {

		if (list.getSize() == 0) {
			throw new NoSuchElementException("Queue is leeg!");
		}

		E first = this.list.getFirst();
		this.list.removeAt(0);
		return first;
	}

	/**
	 * Bekijk het eerste element in de wachrij, maar haal et er niet vanaf.
	 */
	public E front() {

		E first = this.list.getFirst();
		return first;
	}

	/**
	 * Het aantal elementen op de wachtrij.
	 */
	public int size() {

		return list.getSize();
	}
}