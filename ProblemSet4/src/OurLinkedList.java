// Aaron Lemmon

import java.util.Iterator;

public class OurLinkedList<E> implements OurList<E>, Iterable<E> {
	int count = 0;
	Node head = null;
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void add(int index, E item) throws ListIndexOutOfBoundsException {
		checkIndex(index, true);
		count++;
		if (index == 0) {
			head = new Node(head, item);
			
			return;
		}

		Node current = findNode(index - 1);
		current.next = new Node(current.next, item);
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		checkIndex(index, false);
		
		Node current = findNode(index);
		
		return current.value;
	}

	private Node findNode(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	private void checkIndex(int index, boolean adding) throws ListIndexOutOfBoundsException {
		if (((index >= count && !adding) || (index > count && adding)) || index < 0) {
			throw new ListIndexOutOfBoundsException("The index " + index + " is outside the range of the list.");
		}
	}

	@Override
	public E remove(int index) throws ListIndexOutOfBoundsException {
		checkIndex(index, false);
		count--;
		if (index == 0) {
			E toReturn = head.value;
			head = head.next;
			return toReturn;
		}
		Node before = findNode(index - 1);
		E toReturn = before.next.value;
		before.next = before.next.next;
		return toReturn;
	}

	@Override
	public void clear() {
		head = null;
		count = 0;
	}

	@Override
	public String toString() {
		String result = "[";
		Iterator<E> myIterator = this.iterator();
		// This makes sure that commas are inserted only when there is more than one element.
		if (myIterator.hasNext()) {
			result += myIterator.next();
		}
		while (myIterator.hasNext()) {
			result += ", ";
			result += myIterator.next();
		}
		result += "]";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OurLinkedList)) {
			return false;
		}
		OurLinkedList<E> other = (OurLinkedList<E>)obj;
		
		if (this.size() != other.size()) {
			return false;
		}
		
		Iterator<E> thisIterator = this.iterator();
		Iterator<E> otherIterator = other.iterator();
		/* The second check is a little redundant since we know the lists are the same length by now,
		 * but it makes me feel safer. */
		while (thisIterator.hasNext() && otherIterator.hasNext()) {
			if (!thisIterator.next().equals(otherIterator.next())) {
				return false;
			}
		}
		
		// If we get this far, the lists must be equal.
		return true;
	}



	/* An internal class that we use to represent the nodes in the list */
	private class Node {
		Node next;
		E value;
		
		public Node(Node next, E value) {
			this.next = next;
			this.value = value;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	/* An internal class that lets us use a for-each loop to access all the values
	   in the linked list in an efficient manner (that is, without starting at the head
	   each time, as would be the case if we used the get method. */
	private class LinkedListIterator implements Iterator<E> {
		Node next = head;
				
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public E next() {
			E toReturn = next.value;
			next = next.next;
			
			return toReturn;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}