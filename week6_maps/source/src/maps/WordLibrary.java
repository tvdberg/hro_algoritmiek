package maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordLibrary {

	/**
	 * Map interface met een HashMap implementatie voor maximale performance, sortering op values, een TreeMap is dus niet interesant.
	 * De map bestaat uit een String(key), dit zijn de woorden uit de tekst en uit een Integer(value), dit is het aantal keer dat het woord voorkomt.
	 */
	private Map<String, Integer> map = new HashMap<>();

	/**
	 * Constructor, lees de meegegeven file in en bouw de map op.
	 * 
	 * @param file De file die moet worden ingelezen.
	 * @throws FileNotFoundException Het bestand is niet gevonden.
	 */
	public WordLibrary(String file) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(file));

		// Loop de tekst regel voor regel door.
		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(line, ".,! ()[]");

			// Loop door de woorden heen.
			while (tokenizer.hasMoreTokens()) {

				String word = ((String) tokenizer.nextToken()).toLowerCase();

				Integer count = map.get(word);
				if (count == null) {
					map.put(word, 1);
				}
				else {
					map.put(word, count + 1);
				}
			}
		}

		scanner.close();
	}

	/**
	 * Print de woorden aflopend, van meest voorkomend naar minst voorkomend.
	 * 
	 * @param limit Het maximaal aantal te printen woorden.
	 */
	public void printSorted(int limit) {

		List<Entry<String, Integer>> sortedList = MapUtil.sortByValue(map);
		if (limit < sortedList.size()) {
			sortedList = sortedList.subList(0, limit);
		}

		for (Entry<String, Integer> entry : sortedList) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}