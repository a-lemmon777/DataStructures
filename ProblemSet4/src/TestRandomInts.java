// Aaron Lemmon

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestRandomInts {
	public static void main(String[] args) {
		
		/* Should print four 0s */
		RandomInts myInts = new RandomInts(0, 1, 4, 1234);
		System.out.println("Printing four 0s:");
		for (int i : myInts) {
			System.out.println(i);
		}
		
		/* Should print four numbers, but only 0s and 1s */
		myInts = new RandomInts(0, 2, 4, 1339);
		System.out.println("Printing four numbers, but only 0s and 1s:");
		for (int i : myInts) {
			System.out.println(i);
		}
		
		/* Should print five numbers, each between 0 and 9 inclusive */
		myInts = new RandomInts(0, 10, 5, 1113);
		System.out.println("Printing five numbers, between 0 and 9 inclusive:");
		for (int i : myInts) {
			System.out.println(i);
		}
		
		/* Should return the same numbers if iterated over again */
		myInts = new RandomInts(0, 4, 5, 1114);
		System.out.println("Printing five numbers, between 0 and 3 inclusive:");
		for (int i : myInts) {
			System.out.println(i);
		}
		System.out.println("Printing the exact same five numbers:");
		for (int i : myInts) {
			System.out.println(i);
		}
		
		/* Should throw a NoSuchElementException if next() is called too many times */
		myInts = new RandomInts(0, 10, 1, 1113);
		try {
			Iterator<Integer> myIterator = myInts.iterator();
			myIterator.next(); // returns an int
			myIterator.next(); // throws exception
			System.out.println("Oh noes!! Should have thrown an exception.");
		} catch (NoSuchElementException e) {
			System.out.println("Exception has been thrown as expected.");
		}
	}
}
