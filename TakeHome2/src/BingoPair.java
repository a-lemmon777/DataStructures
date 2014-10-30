// Aaron Lemmon

public class BingoPair implements Comparable<BingoPair> {

	private char letter;
	private int number;

	public BingoPair(char letter, int number) {
		this.letter = letter;
		this.number = number;
	}

	/**
	 * Only compares number.
	 */
	@Override
	public int compareTo(BingoPair other) {
		return this.number - other.number;
	}

	/**
	 * Compares both number and letter.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BingoPair) {
			BingoPair other = (BingoPair)obj;
			return (this.number == other.number && this.letter == other.letter);
		} else {
			return false;
		}
	}
	
	

}
