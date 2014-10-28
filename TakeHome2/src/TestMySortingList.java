import java.util.Iterator;


public class TestMySortingList {

	public static void main(String[] args) {
		addAndIteratorWorkWithThreeUniqueValuesInOrder();
//		addAndIteratorWorkWithThreeUniqueValuesOutOfOrder();
//		addAndIteratorWorkWithSomeSimilarValuesAccordingToComparable();
//		IteratorWorksOnEmptyList();
//		addAndIteratorWorkWithOneValue();
//		addAndIteratorWorkWithAllSimilarValuesAccordingToComparable();
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
