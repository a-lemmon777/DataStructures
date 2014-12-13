// Aaron Lemmon

import java.util.Random;

public class HashtableCollisions {
	private static Random random = new Random();

	public static void main(String[] args) {
		// Should loop four times with load factors 0.25, 0.5, 0.75, 1.0
		for (double loadFactor = .25; loadFactor < 1.1; loadFactor += .25) {
			System.out.println("Load factor: " + loadFactor);
			int numberOfElementsToAdd = (int) (loadFactor * OpenAddressHashtable.N);

			// Show results for all three tables. I used to have this in a loop, but it was more messy than it was worth.
			System.out.print("Linear Probing: ");
			addElementsAndPrintResults(new LinearProbingHashtable<Integer, String>(), numberOfElementsToAdd);
			System.out.print("Quadratic Probing: ");
			addElementsAndPrintResults(new QuadraticProbingHashtable<Integer, String>(), numberOfElementsToAdd);
			System.out.print("Double Hashing: ");
			addElementsAndPrintResults(new DoubleHashingHashtable<Integer, String>(), numberOfElementsToAdd);
			System.out.println();
		}
	}

	private static void addElementsAndPrintResults(OpenAddressHashtable<Integer, String> table, int numberOfElementsToAdd) {
		try {
			for (int i = 0; i < numberOfElementsToAdd; i++) {
				table.put(random.nextInt(200), "YOLO");
			}
			System.out.println(table.getCollisionCount());
		} catch (HashtableFullException e) {
			System.out.println("Failed");
		}
	}
}
