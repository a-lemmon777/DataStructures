// Valencia Ingram && Aaron Lemmon && Ben Simondet
import java.util.NoSuchElementException;

public class OurQueueImplementation<E> implements OurQueue<E> {
	OurLinkedList<E> linkedList = new OurLinkedList<E>();
	
	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public E head() {
		try {
			return linkedList.get(0);
		} catch (ListIndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void enqueue(E element) {
		try {
			linkedList.add(linkedList.count, element);
		} catch(Exception e) {
			// This should never happen
		}
	}

	@Override
	public E dequeue() {		
		try {
			return linkedList.remove(0);
		} catch (ListIndexOutOfBoundsException e) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void clear() {
		linkedList.clear();
	}

	@Override
	public String toString() {
		String toReturn = "[";
		for (int i = 0; i < linkedList.size(); i++) {
			try {
				toReturn += linkedList.get(i);
			} catch (ListIndexOutOfBoundsException e) {
				// This should never happen
			}
			if (i < linkedList.size() - 1) {
				toReturn += ", ";
			}
		}
		toReturn += "]";
		return toReturn;
	}
}
