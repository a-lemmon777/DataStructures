// Aaron Lemmon

public class TestLinkedListObjectMethods {
	public static void main(String[] args) throws ListIndexOutOfBoundsException {
		toStringOnAnEmptyListShouldReturnEmptySquareBrackets();
		toStringOnANonemptyListShouldReturnTheElementsSeparatedByCommas();
		aListIsNotEqualToOtherTypes();
		listsWithDifferentLengthsAreNotEqual();
		listsWithDifferentlyTypedElementsAreNotEqual();
		listsWithTheSameLengthButDifferentElementsAreNotEqual();
		listsWithIdenticalElementsAreEqual();
		listsWithTheSameElementsButInADifferentOrderAreNotEqual();
		twoEmptyListsShouldBeEqual();
	}

	private static void toStringOnAnEmptyListShouldReturnEmptySquareBrackets() {
		System.out.println("toString on an empty list should return [] (should print true).");
		OurLinkedList<Integer> testList = new OurLinkedList<Integer>();
		System.out.println(testList.toString().equals("[]"));
	}		

	private static void toStringOnANonemptyListShouldReturnTheElementsSeparatedByCommas() throws ListIndexOutOfBoundsException {
		System.out.println("toString on a nonempty list should return [firstElement, secondElement, ..., lastElement] (should print true).");
		OurLinkedList<String> testList = new OurLinkedList<String>();
		testList.add(0, "nothing");
		testList.add(1, "something");
		testList.add(2, "somethings");
		System.out.println(testList.toString().equals("[nothing, something, somethings]"));
	}

	private static void aListIsNotEqualToOtherTypes() {
		System.out.println("A list is not equal to other types (should print true).");
		OurLinkedList<String> testList = new OurLinkedList<String>();
		System.out.println(!testList.equals("BogusString!!!"));
	}

	private static void listsWithDifferentLengthsAreNotEqual() throws ListIndexOutOfBoundsException {
		System.out.println("Lists with different lengths are not equal (should print true).");
		OurLinkedList<String> list1 = new OurLinkedList<String>();
		list1.add(0, "Hello");
		OurLinkedList<String> list2 = new OurLinkedList<String>();
		list2.add(0, "Nope.");
		list2.add(1, "Goodbye");
		System.out.println(!list1.equals(list2));
	}

	private static void listsWithDifferentlyTypedElementsAreNotEqual() throws ListIndexOutOfBoundsException {
		System.out.println("Lists with differently typed elements are not equal (should print true).");
		OurLinkedList<String> listOfStrings = new OurLinkedList<String>();
		listOfStrings.add(0, "Hello");
		OurLinkedList<Integer> listOfIntegers = new OurLinkedList<Integer>();
		listOfIntegers.add(0, 9000);
		System.out.println(!listOfStrings.equals(listOfIntegers));
	}

	private static void listsWithTheSameLengthButDifferentElementsAreNotEqual() throws ListIndexOutOfBoundsException {
		System.out.println("Lists with the same length but different elements are not equal (should print true).");
		OurLinkedList<String> list1 = new OurLinkedList<String>();
		list1.add(0, "Hello");
		OurLinkedList<String> list2 = new OurLinkedList<String>();
		list2.add(0, "Goodbye");
		System.out.println(!list1.equals(list2));
	}

	private static void listsWithIdenticalElementsAreEqual() throws ListIndexOutOfBoundsException {
		System.out.println("Lists with identical elements are equal (should print true).");
		OurLinkedList<String> list1 = new OurLinkedList<String>();
		list1.add(0, "Leonardo");
		list1.add(1, "Raphael");
		list1.add(2, "Michelangelo");
		list1.add(3, "Donatello");
		OurLinkedList<String> list2 = new OurLinkedList<String>();
		list2.add(0, "Leonardo");
		list2.add(1, "Raphael");
		list2.add(2, "Michelangelo");
		list2.add(3, "Donatello");
		System.out.println(list1.equals(list2));
	}

	private static void listsWithTheSameElementsButInADifferentOrderAreNotEqual() throws ListIndexOutOfBoundsException {
		System.out.println("Lists with the same elements but in a different order are not equal (should print true).");
		OurLinkedList<String> list1 = new OurLinkedList<String>();
		list1.add(0, "Leonardo");
		list1.add(1, "Raphael");
		list1.add(2, "Michelangelo");
		list1.add(3, "Donatello");
		OurLinkedList<String> list2 = new OurLinkedList<String>();
		list2.add(0, "Donatello");
		list2.add(1, "Michelangelo");
		list2.add(2, "Raphael");
		list2.add(3, "Leonardo");
		System.out.println(!list1.equals(list2));
	}

	private static void twoEmptyListsShouldBeEqual() {
		System.out.println("Two empty lists should be equal (should print true).");
		OurLinkedList<String> list1 = new OurLinkedList<String>();
		OurLinkedList<String> list2 = new OurLinkedList<String>();
		System.out.println(list1.equals(list2));
	}
}
