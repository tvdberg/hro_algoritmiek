package linkedstructures;

import java.util.EmptyStackException;

public class Stack<E> {

	private LinkedList<E> list;

	public Stack() {

		this.list = new LinkedList<>();
	}

	/**
	 * Zet een object boven op de stapel.
	 */
	public void push(E o) {

		this.list.insertLast(o);
	}

	/**
	 * Haatlt het bovenste object van de stapel
	 */
	public E pop() {

		if (list.getSize() == 0) {
			throw new EmptyStackException();
		}

		E top = this.list.getLast();
		this.list.removeAt(this.list.getSize() - 1);
		return top;
	}

	/**
	 * Geeft het bovenste object terug, maar laat het op de stapel staan.
	 */
	public E front() {

		if (list.getSize() == 0) {
			throw new EmptyStackException();
		}

		return this.list.getLast();
	}

	/**
	 * Vraag op of de stapel leeg is.
	 */
	public boolean isEmpty() {

		return list.getSize() == 0;
	}
}