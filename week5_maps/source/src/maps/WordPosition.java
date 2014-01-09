package maps;

/**
 * WordPostion, voor het bijhouden van woord posities, bevat een regelnummer en woordnummer.
 */
public class WordPosition {

	private int lineNumber, wordNumber;

	public WordPosition(int line, int number) {

		this.lineNumber = line;
		this.wordNumber = number;
	}

	/**
	 * Vraag het regelnummer op.
	 */
	public int getLineNumber() {

		return this.lineNumber;
	}

	/**
	 * Vraag het woord nummer op.
	 */
	public int getWordNumber() {

		return this.wordNumber;
	}
}