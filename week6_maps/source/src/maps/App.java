package maps;

import java.io.FileNotFoundException;

public class App {

	public App() {

		try {
			long start = System.currentTimeMillis();

			WordLibrary library = new WordLibrary("text.txt");

			long end = System.currentTimeMillis();
			System.out.println("dif: " + (end - start));

			// Print de 100 meestvoorkomende woorden.
			library.printSorted(100);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new App();
	}
}