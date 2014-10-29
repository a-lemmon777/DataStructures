import java.util.Iterator;


public class TestMySortingList {

	public static void main(String[] args) {
		addAndIteratorWorkWithThreeUniqueValuesInOrder();
		addAndIteratorWorkWithThreeUniqueValuesOutOfOrder();
		addAndIteratorWorkWithSomeSimilarValuesAccordingToCompareTo();
		IteratorWorksOnEmptyList();
		addAndIteratorWorkWithOneValue();
		addAndIteratorWorkWithAllSimilarValuesAccordingToCompareTo();
	}

	private static void addAndIteratorWorkWithThreeUniqueValuesInOrder() {
		System.out.print("Both add and the iterator work with three unique values in order: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('O', 25));
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('B', 10), new BingoPair('O', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithThreeUniqueValuesOutOfOrder() {
		System.out.print("Both add and the iterator work with three unique values out of order: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('B', 10), new BingoPair('O', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithSomeSimilarValuesAccordingToCompareTo() {
		System.out.print("Both add and the iterator work with some similar values (according to compareTo): ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10));
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('O', 5), new BingoPair('B', 10), new BingoPair('N', 10), new BingoPair('O', 25), new BingoPair('G', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void IteratorWorksOnEmptyList() {
		System.out.print("Iterator works on an empty list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair[] expectedContents = {};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithOneValue() {
		System.out.print("Both add and the iterator work with one value: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		BingoPair[] expectedContents = {new BingoPair('I', 5)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithAllSimilarValuesAccordingToCompareTo() {
		System.out.print("Both add and the iterator work with all similar values (according to compareTo): ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('B', 7));
		myList.add(new BingoPair('I', 7));
		myList.add(new BingoPair('N', 7));
		myList.add(new BingoPair('G', 7));
		myList.add(new BingoPair('O', 7));
		BingoPair[] expectedContents = {new BingoPair('B', 7), new BingoPair('I', 7), new BingoPair('N', 7), new BingoPair('G', 7), new BingoPair('O', 7)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}
	/**
	 * Used to make sure the list is constructed correctly
	 */
	private static <E> boolean arrayAndListAreEqual(E[] expectedContents, Iterable<E> myList) {
		int index = 0;
		Iterator<E> myIterator = myList.iterator();
		while (index < expectedContents.length && myIterator.hasNext()) {
			if (!expectedContents[index].equals(myIterator.next())) {
				return false;
			}
			index++;
		}
		// Now we just need to check if there are left-over elements in expectedContents or myList
		return (index == expectedContents.length && !myIterator.hasNext());
	}

}
