package binarytree;

/**
 * In deze opdracht programmeer je een Binaire boom. Dit moet je doen door zelf de link-structuur te
 * implementeren. In de boom worden studenten opgeslagen. De knopen in de boom hebben als key het studentnummer
 * van de studenten.
 */
public class App {

	public static void main(String[] args) {

		Tree bsTree = new Tree();

		//Todo: student 0802063 t/m 0824836 in een loop inserten. Let op, niet linear doorlopen en inserten voorkom unbalanced tree.
		
		Student s = new Student(4, "");
		bsTree.insert(s);

		s = new Student(3, "");
		bsTree.insert(s);

		s = new Student(1, "naam-1");
		bsTree.insert(s);

		s = new Student(5, "gdsg");
		bsTree.insert(s);

		s = new Student(6, "");
		bsTree.insert(s);

		s = new Student(2, "");
		bsTree.insert(s);

		bsTree.printStudenten();

		System.out.println();
		System.out.println();
		System.out.println("find item 1: " + bsTree.find(1));

		bsTree.remove(4);

		System.out.println();
		System.out.println("Item removed!");

		bsTree.printStudenten();
	}
}