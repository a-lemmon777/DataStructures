// Aaron Lemmon

/*
 * This is a min-priority queue, meaning that smaller numbers 
 * have higher priority. For instance, if the queue contains 
 * 2, 4, 1, then 1 is returned first, then 2, then 4. 
 * 
 * The smallest element in the queue is called the head of the queue. 
 * If the queue contains several elements with the same minimal value,
 * any one of them may play the role of the head. 
 *  
 * Elements inserted in the the queue must implement the Comparable 
 * interface. (They are ordered based on the ordering determined by their 
 * compareTo method.)
 *  
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OurPriorityQueueOnAHeap<E extends Comparable<E>> implements OurQueue<E> {

	private ArrayList<E> dataTree = new ArrayList<E>();
	
	@Override
	public int size() {
		return dataTree.size();
	}

	@Override
	public boolean isEmpty() {
		return dataTree.size() == 0;
	}

	@Override
	public E head(){
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return dataTree.get(0);		
	}

	@Override
	public void enqueue(E element) {
		dataTree.add(element);
		int newElementIndex = dataTree.size() - 1;
		while (newElementIndex > 0 && dataTree.get(newElementIndex).compareTo(dataTree.get(parentIndex(newElementIndex))) < 0) {
			swap(newElementIndex, parentIndex(newElementIndex));
			newElementIndex = parentIndex(newElementIndex);
		}
	}
	
	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (dataTree.size() == 1) {
			return dataTree.remove(0);
		}
		E toReturn = dataTree.get(0);
		// move last element to root of tree (root of tree must exist since we checked for it above)
		dataTree.set(0, dataTree.remove(dataTree.size() - 1));
		// bubble down to maintain heap property
		maintainMinHeap(0);
		return toReturn;
	}

	private void maintainMinHeap(int index) {
		int leftIndex = leftChildIndex(index);
		int rightIndex = rightChildIndex(index);
		int indexOfSmallest = index;
		if (leftIndex < dataTree.size() && dataTree.get(leftIndex).compareTo(dataTree.get(indexOfSmallest)) < 0) {
			indexOfSmallest = leftIndex;
		}
		if (rightIndex < dataTree.size() && dataTree.get(rightIndex).compareTo(dataTree.get(indexOfSmallest)) < 0) {
			indexOfSmallest = rightIndex;
		}
		if (indexOfSmallest != index) {
			swap(index, indexOfSmallest);
			maintainMinHeap(indexOfSmallest);
		}
	}

	@Override
	public void clear() {
		dataTree.clear();
	}
	
	/* Helper methods that will make the public methods MUCH easier to write 
	 * These are not required, but it is highly recommended that you figure them
	 * out and use them. */

	// swaps the values in two nodes of the heap, given their indices in the ArrayList
	private void swap(int index1, int index2) {
		E temp = dataTree.get(index1);
		dataTree.set(index1, dataTree.get(index2));
		dataTree.set(index2, temp);
	}

	// determines the index of a node's parent from the child node's index
	private int parentIndex(int childIndex) {
		return (childIndex - 1)/2;
	}

	// determines the index of a node's left child from the parent node's index
	private int leftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}

	// determines the index of a node's right child from the parent node's index
	private int rightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}
}