import java.util.Iterator;


public class TestMySortingList {

	public static void main(String[] args) throws ListIndexOutOfBoundsException {
		addAndIteratorWorkWithThreeUniqueElementsInOrder();
		addAndIteratorWorkWithThreeUniqueElementsOutOfOrder();
		addAndIteratorWorkWithSomeSimilarElementsAccordingToCompareTo();
		IteratorWorksOnEmptyList();
		addAndIteratorWorkWithOneElement();
		addAndIteratorWorkWithAllSimilarElementsAccordingToCompareTo();
		canRemoveFromOneElementList();
		canRemoveFromBeginningOfTwoElementListWithEqualElements();
		canRemoveFromBeginningOfTwoElementListWithUnequalElements();
		canRemoveFromEndOfList();
		canRemoveFromEndOfListWithTwoEqualElementsAtEnd();
		canRemoveFirstInstanceOfMultipleEqualElementsFromMiddleOfList();
		canRemoveMiddleInstanceOfMultipleEqualElementsFromMiddleOfList();
		canRemoveLastInstanceOfMultipleEqualElementsFromMiddleOfList();
		canRemoveUniqueElementFromMiddleOfList();
		removeThrowsExceptionWhenIndexIsTooLow();
		removeThrowsExceptionWhenIndexIsTooHigh();
		
	}

	private static void addAndIteratorWorkWithThreeUniqueElementsInOrder() {
		System.out.print("Both add and the iterator work with three unique elements in order: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('O', 25));
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('B', 10), new BingoPair('O', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithThreeUniqueElementsOutOfOrder() {
		System.out.print("Both add and the iterator work with three unique elements out of order: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('B', 10), new BingoPair('O', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithSomeSimilarElementsAccordingToCompareTo() {
		System.out.print("Both add and the iterator work with some similar elements (according to compareTo): ");
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

	private static void addAndIteratorWorkWithOneElement() {
		System.out.print("Both add and the iterator work with one element: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		BingoPair[] expectedContents = {new BingoPair('I', 5)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void addAndIteratorWorkWithAllSimilarElementsAccordingToCompareTo() {
		System.out.print("Both add and the iterator work with all similar elements (according to compareTo): ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('B', 7));
		myList.add(new BingoPair('I', 7));
		myList.add(new BingoPair('N', 7));
		myList.add(new BingoPair('G', 7));
		myList.add(new BingoPair('O', 7));
		BingoPair[] expectedContents = {new BingoPair('B', 7), new BingoPair('I', 7), new BingoPair('N', 7), new BingoPair('G', 7), new BingoPair('O', 7)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}
	
	private static void canRemoveFromOneElementList() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove from one element list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		myList.remove(0);
		BingoPair[] expectedContents = {};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveFromBeginningOfTwoElementListWithEqualElements() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove from beginning of two element list with equal elements: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('G', 5));
		myList.remove(0);
		BingoPair[] expectedContents = {new BingoPair('G', 5)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveFromBeginningOfTwoElementListWithUnequalElements() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove from beginning of two element list with unequal elements: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 12));
		myList.add(new BingoPair('G', 5));
		myList.remove(0);
		BingoPair[] expectedContents = {new BingoPair('I', 12)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveFromEndOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove from end of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.remove(2);
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('B', 10)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveFromEndOfListWithTwoEqualElementsAtEnd() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove from end of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('N', 25));
		myList.add(new BingoPair('I', 5));
		myList.remove(3);
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('B', 10), new BingoPair('O', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveFirstInstanceOfMultipleEqualElementsFromMiddleOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove first instance of multiple equal elements from middle of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('G', 10)); // First middle element
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10)); // Second middle element
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10)); // Third middle element
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		myList.remove(2);
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('O', 5), new BingoPair('B', 10), new BingoPair('N', 10), new BingoPair('O', 25), new BingoPair('G', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveMiddleInstanceOfMultipleEqualElementsFromMiddleOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove middle instance of multiple equal elements from middle of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('G', 10)); // First middle element
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10)); // Second middle element
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10)); // Third middle element
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		myList.remove(3);
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('O', 5), new BingoPair('G', 10), new BingoPair('N', 10), new BingoPair('O', 25), new BingoPair('G', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveLastInstanceOfMultipleEqualElementsFromMiddleOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove last instance of multiple equal elements from middle of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('G', 10)); // First middle element
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10)); // Second middle element
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10)); // Third middle element
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		myList.remove(4);
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('O', 5), new BingoPair('G', 10), new BingoPair('B', 10), new BingoPair('O', 25), new BingoPair('G', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void canRemoveUniqueElementFromMiddleOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can remove unique element from middle of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.remove(1);
		BingoPair[] expectedContents = {new BingoPair('I', 5), new BingoPair('O', 25)};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void removeThrowsExceptionWhenIndexIsTooLow() {
		System.out.print("Remove throws exception when index is too low: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		try {
			myList.remove(-1);
			System.out.println(false);
		} catch (ListIndexOutOfBoundsException e) {
			System.out.println(true);
		}
	}

	private static void removeThrowsExceptionWhenIndexIsTooHigh() {
		System.out.print("Remove throws exception when index is too high: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		try {
			myList.remove(3);
			System.out.println(false);
		} catch (ListIndexOutOfBoundsException e) {
			System.out.println(true);
		}
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
