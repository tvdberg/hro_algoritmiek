package maps;

import java.io.FileNotFoundException;
import java.util.List;

public class App {

	public App() {

		try {
			WordLibrary library = new WordLibrary("text.txt");

			// Zoek de posities van een specifiek woord op en print deze.
			String wordToFind = "NSA-onthullingen";

			List<WordPosition> positions = library.findPositions(wordToFind);
			if (positions != null) {

				System.out.println("Word found: " + wordToFind);

				for (WordPosition wordPosition : positions) {
					System.out.println("  line: " + wordPosition.getLineNumber() + ", word: " + wordPosition.getWordNumber());
				}
			}

			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("");

			// Print alle worden en bijbehorende posities.
			library.printAll();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new App();
	}
}