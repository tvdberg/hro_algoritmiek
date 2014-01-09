package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordLibrary {

	/**
	 * Map interface met een TreeMap implementatie zodat de woorden(index) alfabetisch gesorteerd worden.
	 * De map bestaat uit een String(key), dit zijn de woorden uit de tekst en uit een List<WordPosition>(value), dit zijn de bijbehorende posities.
	 * De List in de map is een List interface met een linkedList implementatie, zodat nieuwe posities snel kunnen worden toegevoegd en voor het opvragen is sequentieel toereikend.
	 */
	private Map<String, List<WordPosition>> map = new TreeMap<>();

	/**
	 * Constructor, lees de meegegeven file in en bouw de map op.
	 * 
	 * @param file De file die moet worden ingelezen.
	 * @throws FileNotFoundException Het bestand is niet gevonden.
	 */
	public WordLibrary(String file) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(file));
		int lineNumber = 1;

		// Loop de tekst regel voor regel door.
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			String[] words = line.split(" ");
			int wordNumber = 1;

			// Loop de regel woord voor woord door.
			for (String word : words) {

				if (!word.trim().equals("")) {

					// Verwijder eventuele leestekens aan het einde van het woord.
					if (word.charAt(word.length() - 1) == ',' || word.charAt(word.length() - 1) == '.') {
						word = word.substring(0, word.length() - 1);
					}

					List<WordPosition> posList = map.get(word);

					// Woord bestaat nog niet in map, voeg woord en bijbehorende positie toe.
					if (posList == null) {

						posList = new LinkedList<>();
						posList.add(new WordPosition(lineNumber, wordNumber));
						map.put(word, posList);
					}
					// Woord bestaat al in map, voeg positie toe aan entry in map.
					else {
						posList.add(new WordPosition(lineNumber, wordNumber));
					}

					wordNumber++;
				}
			}

			lineNumber++;
		}

		scanner.close();
	}

	/**
	 * Vraag de posities waar het meegegeven woord voorkomt op.
	 * 
	 * @param word Het woord waarvan de posities moeten worden opgevraagd.
	 * @return De lijst met de posities indien het woord in de map voorkomt, anders null.
	 */
	public List<WordPosition> findPositions(String word) {

		return map.get(word);
	}

	/**
	 * Print alle woorden en bijbehorende posities in de console.
	 */
	public void printAll() {

		Set<Entry<String, List<WordPosition>>> entrySet = map.entrySet();
		for (Entry<String, List<WordPosition>> entry : entrySet) {

			System.out.println("Word: " + entry.getKey() + ", count: " + entry.getValue().size());

			List<WordPosition> posList = entry.getValue();
			for (WordPosition wordPosition : posList) {

				System.out.println("  line: " + wordPosition.getLineNumber() + ", word: " + wordPosition.getWordNumber());
			}
		}
	}
}