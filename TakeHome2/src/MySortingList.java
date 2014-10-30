// Aaron Lemmon

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySortingList<E extends Comparable<E>> implements SortingList<E> {

	private Node head = new Node(null, null, null); // Dummy starting node (helps eliminate treating start of list as a special case)
	private int count = 0;
	private int uniqueValueCount = 0;

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public int uniqueValueCount() {
		return uniqueValueCount;
	}

	@Override
	public void add(E item) {
		Node before = findLastNodeBefore(item);
		if (before.value != null && before.value.compareTo(item) == 0)  {
			// Add the new node onto the offshoot branch of equal items
			before.nextEqual = new Node(null, null, item);
			count++;
		} else {
			// Insert the new node into the correct place in the main branch.
			before.nextGreater = new Node(before.nextGreater, null, item);
			count++;
			uniqueValueCount++;
		}
	}

	@Override
	public int frequencyOf(E item) {
		Node mainBranchNode = head.nextGreater; // Starts past the dummy node
		// Find the node in the main branch with a value equal to item if it exists
		while (mainBranchNode != null && mainBranchNode.value.compareTo(item) != 0) {
			mainBranchNode = mainBranchNode.nextGreater;
		}
		int count = 0;
		Node current = mainBranchNode;
		// Traverse through and count all the elements equal to item in the offshoot branch.
		while (current != null) {
			current = current.nextEqual;
			count++;
		}
		return count;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		if (index < 0) {
			throw new ListIndexOutOfBoundsException("In the function get, the index " + index + " was too low.");
		} else if (count <= index) {
			throw new ListIndexOutOfBoundsException("In the function get, the index " + index + " was too high.");
		}
		// If we get this far, we know the index is within bounds
		Iterator<E> iterator = iterator();
		// Get to the node preceding index
		for (int i = 0; i < index; i++) {
			iterator.next();
		}
		// Return the very next element
		return iterator.next();
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index < 0) {
			throw new ListIndexOutOfBoundsException("In the function remove, the index " + index + " was too low.");
		} else if (count <= index) {
			throw new ListIndexOutOfBoundsException("In the function remove, the index " + index + " was too high.");
		}
		// If we get this far, we know the index is within bounds
		MySortingListIterator iterator = new MySortingListIterator();
		// Find the previous and previousMainBranch nodes right before the node to be removed
		for (int i = 0; i < index; i++) {
			iterator.next();
		}
		Node previousMainBranch = iterator.mainBranchNode;
		Node previous = iterator.current;
		iterator.next();
		Node targetForRemoval = iterator.current;
		if (previous.value != null && previous.value.compareTo(targetForRemoval.value) == 0) {
			// Remove from an offshoot branch (but not the root of it)
			previous.nextEqual = targetForRemoval.nextEqual;
			count--;
		} else { // If we get here we know that previous.value == null(it's the dummy node) or previous doesn't "equal" target (not in the same offshoot branch)
			if (targetForRemoval.nextEqual != null) {
				// Remove from the root of the offshoot branch
				targetForRemoval.nextEqual.nextGreater = targetForRemoval.nextGreater;
				previousMainBranch.nextGreater = targetForRemoval.nextEqual;
				count--;
			} else {
				// Remove a unique element
				previous.nextGreater = targetForRemoval.nextGreater;
				count--;
				uniqueValueCount--;
			}
		}
	}

	@Override
	public void clear() {
		head = new Node(null, null, null);
		count = 0;
		uniqueValueCount = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new MySortingListIterator();
	}

	/*
	 * Gets the node before where item's node would go when inserted. If values equal to item already exist, this will return
	 * last of those values. If no values equal to item are in the list, this will return the node that should precede it in
	 * the main branch.
	 */
	private Node findLastNodeBefore(E item) {
		Node toReturn = head; // the dummy node
		// Travels along the main branch and finds the last node with a value <= item.
		while (toReturn.nextGreater != null && toReturn.nextGreater.value.compareTo(item) <= 0) {
			toReturn = toReturn.nextGreater;
		}
		if (toReturn.value != null && toReturn.value.compareTo(item) == 0) {
			while (toReturn.nextEqual != null) {
				toReturn = toReturn.nextEqual;
			}
		}
		return toReturn;
	}

	private class MySortingListIterator implements Iterator<E> {
		private Node mainBranchNode = head; // Starts at the dummy node
		private Node current = head; // Starts at the dummy node
	
		@Override
		public boolean hasNext() {
			return (current.nextEqual != null || mainBranchNode.nextGreater != null);
		}
	
		@Override
		public E next() {
			if (hasNext()) {
				// Changes current to the next "equal" node if there is one, otherwise changes it to the next greater node.
				if (current.nextEqual != null) {
					current = current.nextEqual;
				} else {
					mainBranchNode = mainBranchNode.nextGreater;
					current = mainBranchNode;
				}
				return current.value;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class Node {

		private Node nextGreater;
		private Node nextEqual;
		private E value;
		
		public Node(Node nextGreater, Node nextEqual, E value) {
			this.nextGreater = nextGreater;
			this.nextEqual = nextEqual;
			this.value = value;
		}
	
	}
}
