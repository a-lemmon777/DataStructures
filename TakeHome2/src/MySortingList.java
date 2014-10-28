import java.util.Iterator;
import java.util.NoSuchElementException;


public class MySortingList<E extends Comparable<E>> implements SortingList<E> {

	private Node head = null;
	private int count = 0;
	private int uniqueValueCount = 0;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int uniqueValueCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(E item) {
		Node previous = null;
		Node current = head;
		while ((current != null) && (current.value.compareTo(item) < 0)) {
			previous = current;
			current = current.nextGreater;
		}
		if (previous == null) { // This means we insert at the beginning of the list
			head = new Node(null, null, item);
		}
		// Now current is the first node in the list with a value greater than or equal to item.
		else if (current.value.compareTo(item) == 0) {
			Node currentEqual = current;
			while (currentEqual.nextEqual != null) {
				currentEqual = currentEqual.nextEqual;
			}
			// Now currentEqual is the last node with a value "equal" to the item.
			currentEqual.nextEqual = new Node(null, null, item);
			count++;
		} else {
			Node newNode = new Node(current, null, item);
			previous.nextGreater = newNode;
			count++;
			uniqueValueCount ++;
		}
	}

	@Override
	public int frequencyOf(E item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<E> iterator() {
		return new MySortingListIterator();
	}

	private class MySortingListIterator implements Iterator<E> {
		
		Node current = head;
	
		@Override
		public boolean hasNext() {
			return (current != null);
		}
	
		@Override
		public E next() {
			if (hasNext()) {
				E toReturn = current.value;
				// Changes current to the next "equal" node if there is one, otherwise changes it to the next greater node.
				if (current.nextEqual != null) {
					current = current.nextEqual;
				} else {
					current = current.nextGreater;
				}
				return toReturn;
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
