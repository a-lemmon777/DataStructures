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
//		Node mainBranchNode = head;
		Node previous = null;
		Node current = head;
		while ((current != null) && (current.value.compareTo(item) < 0)) {
			previous = current;
			current = current.nextGreater;
		}
		if (previous == null) { // This means we insert at the beginning of the list
			if (current == null) { // Insert into empty list
				head = new Node(null, null, item);
			} else if (current.value.compareTo(item) == 0) {
				while(current.nextEqual != null) {
					current = current.nextEqual;
				}
				current.nextEqual = new Node(null, null, item);
			} else {
				head = new Node(current, null, item);
			}
		} else if (current == null) { // Insert after end of list
			previous.nextGreater = new Node(null, null, item);
		} else { 
			if (current.value.compareTo(item) == 0) { // Add an equal element
				while(current.nextEqual != null) {
					current = current.nextEqual;
				}
				current.nextEqual = new Node(null, null, item);
			} else { // Insert node into main branch
				previous.nextGreater = new Node(current, null, item);
			}
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
		private Node mainBranchNode = head;
		private Node current = head;
	
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
					mainBranchNode = mainBranchNode.nextGreater;
					current = mainBranchNode;
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
