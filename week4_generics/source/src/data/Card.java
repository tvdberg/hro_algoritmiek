package data;

public class Card implements Comparable<Card> {

	private CardType cardType;
	private CardValue cardValue;

	public Card(CardType cardType, CardValue cardValue) {

		this.cardType = cardType;
		this.cardValue = cardValue;
	}

	@Override
	public int compareTo(Card card) {

		if (this.cardValue.getValue() < card.cardValue.getValue()) {
			return -1;
		}
		else if (this.cardValue.getValue() > card.cardValue.getValue()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public String toString() {

		return this.cardType + " " + this.cardValue;
	}

	public enum CardType {

		Spades("Schoppen"), Hearts("Harten"), Diamonds("Ruiten"), Clubs("Klaveren");

		private String description = "";

		CardType(String description) {

			this.description = description;
		}

		@Override
		public String toString() {

			return this.description;
		}
	}

	public enum CardValue {

		nr1(1, "1"), nr2(2, "2"), nr3(3, "3"), nr4(4, "4"), nr5(5, "5"), nr6(6, "6"), nr7(7, "7"), nr8(8, "8"), nr9(9, "9"), nr10(10, "10"),
		Jack(11, "Boer"), Queen(12, "Vrouw"), King(13, "Heer"), Ace(14, "Aas");

		private int value;
		private String description;

		CardValue(int value, String description) {

			this.value = value;
			this.description = description;
		}

		public int getValue() {

			return this.value;
		}

		@Override
		public String toString() {

			return this.description;
		}
	}
}