package binarytree;

public class Tree {

	private Node root;

	public Tree() {

	}

	/**
	 * Voeg een element toe aan de tree
	 */
	public void insert(Student student) {

		root = insert(root, student);
	}

	/**
	 * Insert implementatie.
	 */
	private Node insert(Node node, Student student) {

		if (node == null) {
			return new Node(student);
		}
		if (student.compareTo(node.student) == 0) {
			return node;
		}
		if (student.compareTo(node.student) < 0) {
			node.left = insert(node.left, student);
		}
		else {
			node.right = insert(node.right, student);
		}

		return node;
	}

	/**
	 * Verwijder een object uit de boom
	 */
	public void remove(int number) {

		root = remove(root, number);
	}

	/**
	 * Remove implementatie.
	 * bron: http://pages.cs.wisc.edu/~paton/readings/Binary-Search-Trees/
	 */
	private Node remove(Node node, int number) {

		if (node == null) {
			return null;
		}

		if (node.student.getNumber() == number) {

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
			node.student = smallVal.student;
			node.right = remove(node.right, smallVal.student.getNumber());
			return node;
		}
		else if (number < node.student.getNumber()) {
			node.left = remove(node.left, number);
			return node;
		}
		else {
			node.right = remove(node.right, number);
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
	public Student find(int studentNumber) {

		Node node = find(root, studentNumber);
		return node.student;
	}

	/**
	 * search implementatie.
	 */
	private Node find(Node node, int studentNumber) {

		if (node == null) {
			throw new RuntimeException("Student: " + studentNumber + " not found!");
		}
		if (studentNumber == node.student.getNumber()) {
			return node;
		}
		if (studentNumber < node.student.getNumber()) {
			return find(node.left, studentNumber);
		}
		else {
			return find(node.right, studentNumber);
		}
	}

	/**
	 * Print de tree In-Order
	 */
	public void printStudenten() {

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

		Student student;
		Node left, right;

		public Node(Student student) {

			this.student = student;
		}

		@Override
		public String toString() {

			if (student != null) {
				return student.toString();
			}
			else {
				return "empty node";
			}
		}
	}
}