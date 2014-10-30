// Aaron Lemmon

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
		canGetFromOneElementList();
		canGetFromBeginningOfList();
		canGetFromEndOfList();
		canGetFromEndOfListWithTwoEqualElementsAtEnd();
		canGetFromSecondToEndOfListWithTwoEqualElementsAtEnd();
		canGetMiddleInstanceOfMultipleEqualElementsFromMiddleOfList();
		canGetUniqueElementFromMiddleOfList();
		getThrowsExceptionWhenIndexIsTooLow();
		getThrowsExceptionWhenIndexIsTooHigh();
		frequencyOfAnyElementInAnEmptyListIsZero();
		frequencyOfTheElementInAListSizeOneIsOne();
		canGetTheFrequencyOfAnElementAtTheBeginningOfAList();
		canGetTheFrequencyOfAnElementInTheMiddleOfAList();
		canGetTheFrequencyOfAnElementAtTheEndOfAList();
		frequencyOfAnElementNotInTheListIsZero();
		isEmptyOnAnEmptyListIsTrue();
		isEmptyOnANonEmptyListIsFalse();
		sizeOnAnEmptyListIsZero();
		sizeOnAListWithOneElementIsOne();
		sizeOnAListWithFiveElementsIsFive();
		uniqueValueCountOnAnEmptyListIsZero();
		uniqueValueCountOnAListWithOneElementIsOne();
		uniqueValueCountOnAListWithFiveElementsButOnlyTwoUniqueElementsIsTwo();
		uniqueValueCountOnAListWithFiveUniqueElementsIsFive();
		clearingAListRemovesAllReferencesToAllElements();
		clearingResetsSizeToZero();
		clearingResetsUniqueValueCountToZero();
		clearingAListThenAddingThreeElementsShouldWork(); // This is needed to make sure the starting dummy node isn't cleared
		System.out.println("I can't wait for JUnit!!!");
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
			System.out.println(e.toString().equals("ListIndexOutOfBoundsException: In the function remove, the index -1 was too low."));
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
			System.out.println(e.toString().equals("ListIndexOutOfBoundsException: In the function remove, the index 3 was too high."));
		}
	}

	private static void canGetFromOneElementList() throws ListIndexOutOfBoundsException {
		System.out.print("Can get from one element list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair expectedResult = new BingoPair('I', 5);
		myList.add(expectedResult);
		System.out.println(expectedResult.equals(myList.get(0)));
	}

	private static void canGetFromBeginningOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can get from beginning of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair expectedResult = new BingoPair('I', 5);
		myList.add(new BingoPair('B', 9));
		myList.add(new BingoPair('G', 13));
		myList.add(expectedResult);
		System.out.println(expectedResult.equals(myList.get(0)));
	}

	private static void canGetFromEndOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can get from end of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair expectedResult = new BingoPair('G', 13);
		myList.add(new BingoPair('B', 9));
		myList.add(new BingoPair('I', 5));
		myList.add(expectedResult);
		System.out.println(expectedResult.equals(myList.get(2)));
	}

	private static void canGetFromEndOfListWithTwoEqualElementsAtEnd() throws ListIndexOutOfBoundsException {
		System.out.print("Can get from end of list with two equal elements at the end: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair expectedResult = new BingoPair('N', 25);
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.add(expectedResult);
		System.out.println(expectedResult.equals(myList.get(3)));
	}

	private static void canGetFromSecondToEndOfListWithTwoEqualElementsAtEnd() throws ListIndexOutOfBoundsException {
		System.out.print("Can get from second to end of list with two equal elements at the end: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair expectedResult = new BingoPair('N', 25);
		myList.add(expectedResult);
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		System.out.println(expectedResult.equals(myList.get(2)));
	}

	private static void canGetMiddleInstanceOfMultipleEqualElementsFromMiddleOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can get middle instance of multiple equal elements from middle of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('G', 10)); // First middle element
		myList.add(new BingoPair('O', 25));
		BingoPair expectedResult = new BingoPair('B', 10); // Second middle element
		myList.add(expectedResult);
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10)); // Third middle element
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		System.out.println(expectedResult.equals(myList.get(3)));
	}

	private static void canGetUniqueElementFromMiddleOfList() throws ListIndexOutOfBoundsException {
		System.out.print("Can get middle instance of multiple equal elements from middle of list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		BingoPair expectedResult = new BingoPair('B', 10);
		myList.add(expectedResult);
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('I', 5));
		System.out.println(expectedResult.equals(myList.get(1)));
	}

	private static void getThrowsExceptionWhenIndexIsTooLow() {
		System.out.print("Remove throws exception when index is too low: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		try {
			myList.get(-1);
			System.out.println(false);
		} catch (ListIndexOutOfBoundsException e) {
			System.out.println(e.toString().equals("ListIndexOutOfBoundsException: In the function get, the index -1 was too low."));
		}
	}

	private static void getThrowsExceptionWhenIndexIsTooHigh() {
		System.out.print("Remove throws exception when index is too high: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		try {
			myList.get(3);
			System.out.println(false);
		} catch (ListIndexOutOfBoundsException e) {
			System.out.println(e.toString().equals("ListIndexOutOfBoundsException: In the function get, the index 3 was too high."));
		}
	}

	private static void frequencyOfAnyElementInAnEmptyListIsZero() {
		System.out.print("The frequency of any element in an empty list is zero: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		System.out.println(0 == myList.frequencyOf(new BingoPair('G', 23)));
	}

	private static void frequencyOfTheElementInAListSizeOneIsOne() {
		System.out.print("The frequency of the element in a list size one is one: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('I', 5));
		System.out.println(1 == myList.frequencyOf(new BingoPair('I', 5)));
	}

	private static void canGetTheFrequencyOfAnElementAtTheBeginningOfAList() {
		System.out.print("Can get the frequency of an element at the beginning of a list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10));
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		myList.add(new BingoPair('G', 10));
		System.out.println(2 == myList.frequencyOf(new BingoPair('I', 5)));
	}

	private static void canGetTheFrequencyOfAnElementInTheMiddleOfAList() {
		System.out.print("Can get the frequency of an element in the middle of a list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10));
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		myList.add(new BingoPair('G', 10));
		System.out.println(3 == myList.frequencyOf(new BingoPair('G', 10)));
	}

	private static void canGetTheFrequencyOfAnElementAtTheEndOfAList() {
		System.out.print("Can get the frequency of an element at the end of a list: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('N', 10));
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('O', 5));
		myList.add(new BingoPair('G', 10));
		System.out.println(2 == myList.frequencyOf(new BingoPair('G', 25)));
	}

	private static void frequencyOfAnElementNotInTheListIsZero() {
		System.out.print("Frequency of an element not in the list is zero: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		System.out.println(0 == myList.frequencyOf(new BingoPair('B', 99)));
	}

	private static void isEmptyOnAnEmptyListIsTrue() {
		System.out.print("isEmpty on an empty list is true: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		System.out.println(myList.isEmpty());
	}

	private static void isEmptyOnANonEmptyListIsFalse() {
		System.out.print("isEmpty on a nonempty list is false: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		System.out.println(!myList.isEmpty());
	}

	private static void sizeOnAnEmptyListIsZero() {
		System.out.print("size on an empty list is zero: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		System.out.println(0 == myList.size());
	}

	private static void sizeOnAListWithOneElementIsOne() {
		System.out.print("size on a list with one element is one: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('B', 10));
		System.out.println(1 == myList.size());
	}

	private static void sizeOnAListWithFiveElementsIsFive() {
		System.out.print("size on a list with five elements is five: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		System.out.println(5 == myList.size());
	}

	private static void uniqueValueCountOnAnEmptyListIsZero() {
		System.out.print("uniqueValueCount on an empty list is zero: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		System.out.println(0 == myList.uniqueValueCount());
	}

	private static void uniqueValueCountOnAListWithOneElementIsOne() {
		System.out.print("uniqueValueCount on a list with one element is one: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('B', 10));
		System.out.println(1 == myList.uniqueValueCount());
	}

	private static void uniqueValueCountOnAListWithFiveElementsButOnlyTwoUniqueElementsIsTwo() {
		System.out.print("uniqueValueCount on a list with five elements but only two unique elements is two: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 25));
		myList.add(new BingoPair('I', 10));
		myList.add(new BingoPair('G', 25));
		myList.add(new BingoPair('B', 10));
		System.out.println(2 == myList.uniqueValueCount());
	}

	private static void uniqueValueCountOnAListWithFiveUniqueElementsIsFive() {
		System.out.print("uniqueValueCount on a list with five unique elements is five: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 1));
		myList.add(new BingoPair('B', 2));
		myList.add(new BingoPair('I', 3));
		myList.add(new BingoPair('O', 4));
		myList.add(new BingoPair('B', 5));
		System.out.println(5 == myList.uniqueValueCount());
	}

	private static void clearingAListRemovesAllReferencesToAllElements() {
		System.out.print("Clearing a list removes all references to all elements: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 1));
		myList.add(new BingoPair('B', 2));
		myList.add(new BingoPair('I', 3));
		myList.add(new BingoPair('O', 4));
		myList.add(new BingoPair('B', 5));
		myList.clear();
		BingoPair[] expectedContents = {};
		System.out.println(arrayAndListAreEqual(expectedContents, myList));
	}

	private static void clearingResetsSizeToZero() {
		System.out.print("Clearing resets size to zero: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.clear();
		System.out.println(0 == myList.size());
	}

	private static void clearingResetsUniqueValueCountToZero() {
		System.out.print("Clearing resets uniqueValueCount to zero: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 25));
		myList.add(new BingoPair('B', 10));
		myList.add(new BingoPair('I', 5));
		myList.clear();
		System.out.println(0 == myList.uniqueValueCount());
	}

	private static void clearingAListThenAddingThreeElementsShouldWork() {
		System.out.print("Clearing a list then adding three elements should work: ");
		SortingList<BingoPair> myList = new MySortingList<BingoPair>();
		myList.add(new BingoPair('O', 1));
		myList.add(new BingoPair('B', 2));
		myList.add(new BingoPair('I', 3));
		myList.add(new BingoPair('O', 4));
		myList.add(new BingoPair('B', 5));
		myList.clear();
		myList.add(new BingoPair('N', 30));
		myList.add(new BingoPair('G', 20));
		myList.add(new BingoPair('B', 10));
		BingoPair[] expectedContents = {new BingoPair('B', 10), new BingoPair('G', 20), new BingoPair('N', 30)};
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
