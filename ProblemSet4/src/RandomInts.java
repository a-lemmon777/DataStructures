// Aaron Lemmon

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomInts implements Iterable<Integer> {

	private int min;
	private int max;
	private int n;
	private int randomSeed;

	public RandomInts(int min, int max, int n, int randomNumberSeed) {
		this.min = min;
		this.max = max;
		this.n = n;
		this.randomSeed = randomNumberSeed;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RandomIntsIterator();
	}

	private class RandomIntsIterator implements Iterator<Integer> {

		private Random random = new Random(randomSeed);
		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < n;
		}

		@Override
		public Integer next() {
			if (hasNext()) {
				count++;
				return random.nextInt(max - min) + min;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
