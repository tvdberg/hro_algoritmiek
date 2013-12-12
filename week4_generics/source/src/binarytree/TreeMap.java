package binarytree;

/**
 * Binary tree implementatie waar elementen op basis van key's toegevoegd, verwijderd en opgezocht kunnen worden. De natuurlijke order wordt bepaald door de key's.
 */
public class TreeMap<K extends Comparable<K>, E> {

	private Node root;

	public TreeMap() {

	}

	/**
	 * Voeg een element toe aan de tree
	 */
	public void insert(K key, E element) {

		root = insert(root, key, element);
	}

	/**
	 * Insert implementatie.
	 */
	private Node insert(Node node, K key, E element) {

		if (node == null) {
			return new Node(key, element);
		}
		if (key.compareTo(node.key) == 0) {
			return node;
		}
		if (key.compareTo(node.key) < 0) {
			node.left = insert(node.left, key, element);
		}
		else {
			node.right = insert(node.right, key, element);
		}

		return node;
	}

	/**
	 * Verwijder een object uit de boom
	 */
	public void remove(K key) {

		root = remove(root, key);
	}

	/**
	 * Remove implementatie.
	 * bron: http://pages.cs.wisc.edu/~paton/readings/Binary-Search-Trees/
	 */
	private Node remove(Node node, K key) {

		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) == 0) {

			// n is the node to be removed
			if (node.left == null && node.right == null) {
				return null;
			}
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return node.left;
			}

			Node smallVal = smallest(node.right);
			node.element = smallVal.element;
			node.right = remove(node.right, smallVal.key);
			return node;
		}
		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		}
		else {
			node.right = remove(node.right, key);
			return node;
		}
	}

	/**
	 * Vraag de meest linker node in de meegegeven node op.
	 */
	private Node smallest(Node node) {

		if (node.left == null) {
			return node;
		}
		else {
			return smallest(node.left);
		}
	}

	/**
	 * Zoek een studentnummer in de boom en return het oject
	 */
	public E find(K key) {

		Node node = find(root, key);
		return node.element;
	}

	/**
	 * Search implementatie.
	 */
	private Node find(Node node, K key) {

		if (node == null) {
			throw new RuntimeException("Key: " + key.toString() + " not found!");
		}
		if (key.compareTo(node.key) == 0) {
			return node;
		}
		if (key.compareTo(node.key) < 0) {
			return find(node.left, key);
		}
		else {
			return find(node.right, key);
		}
	}

	/**
	 * Print de tree In-Order
	 */
	public void printTree() {

		System.out.println("Level order: ");
		printLevelOrderTraversal(root);

		System.out.println("");
		System.out.println("Pre order:");
		printPreOrderTraversal(root);
	}

	/**
	 * Print de tree in level order.
	 */
	private void printLevelOrderTraversal(Node node) {

		if (node != null) {

			printLevelOrderTraversal(node.left);
			System.out.print(node + " ");
			printLevelOrderTraversal(node.right);
		}
	}

	/**
	 * Print de tree in pre order.
	 */
	private void printPreOrderTraversal(Node node) {

		if (node != null) {

			System.out.print(node + " ");
			printPreOrderTraversal(node.left);
			printPreOrderTraversal(node.right);
		}
	}

	private class Node {

		K key;
		E element;

		Node left, right;

		public Node(K key, E element) {

			this.element = element;
			this.key = key;
		}

		@Override
		public String toString() {

			if (element != null) {
				return element.toString();
			}
			else {
				return "empty node";
			}
		}
	}
}