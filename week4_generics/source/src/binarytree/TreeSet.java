package binarytree;

/**
 * Binary tree implementatie waar elementen in kunnen worden toegevoegd, verwijderd en opgezocht. De natuurlijke order wordt bepaald door de elementen.
 */
public class TreeSet<E extends Comparable<E>> {

	private Node root;

	public TreeSet() {

	}

	/**
	 * Voeg een element toe aan de tree
	 */
	public void insert(E element) {

		root = insert(root, element);
	}

	/**
	 * Insert implementatie.
	 */
	private Node insert(Node node, E element) {

		if (node == null) {
			return new Node(element);
		}
		if (element.compareTo(node.element) == 0) {
			return node;
		}
		if (element.compareTo(node.element) < 0) {
			node.left = insert(node.left, element);
		}
		else {
			node.right = insert(node.right, element);
		}

		return node;
	}

	/**
	 * Verwijder een object uit de boom
	 */
	public void remove(E element) {

		root = remove(root, element);
	}

	/**
	 * Remove implementatie.
	 * bron: http://pages.cs.wisc.edu/~paton/readings/Binary-Search-Trees/
	 */
	private Node remove(Node node, E element) {

		if (node == null) {
			return null;
		}

		if (element.compareTo(node.element) == 0) {

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
			node.right = remove(node.right, smallVal.element);
			return node;
		}
		if (element.compareTo(node.element) < 0) {
			node.left = remove(node.left, element);
			return node;
		}
		else {
			node.right = remove(node.right, element);
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

		E element;

		Node left, right;

		public Node(E element) {

			this.element = element;
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