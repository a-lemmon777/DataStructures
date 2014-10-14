// Valencia Ingram && Aaron Lemmon && Ben Simondet

import java.util.NoSuchElementException;

public class TestOurQueue {

	public static void main(String[] args) {
		testEnqueueAndDequeue();
		testThatDequeueThrowsAnExceptionWhenItsEmpty();
		testThatClearWillClearTheQueue();
		testSize();
		testIsEmpty();
		testHead();
		testThatHeadThrowsAnExceptionWhenItsEmpty();
	}
	
	private static void testEnqueueAndDequeue() {
		System.out.println("Testing Enqueue and Dequeue");
		OurQueue<Integer> testQueue = new OurQueueImplementation<Integer>();
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		System.out.println("[1, 2, 3]".equals(testQueue.toString()));
		testQueue.dequeue();
		testQueue.dequeue();
		System.out.println("[3]".equals(testQueue.toString()));
	}

	private static void testThatDequeueThrowsAnExceptionWhenItsEmpty() {
		System.out.println("Testing Dequeue Exception");
		OurQueue<Integer> testQueue = new OurQueueImplementation<Integer>();
		try { 
			testQueue.dequeue();
			System.out.println(false);
		} catch (NoSuchElementException e) {
			System.out.println(true);
		}
	}

	private static void testThatClearWillClearTheQueue() {
		System.out.println("Testing Clear");
		OurQueue<Integer> testQueue = new OurQueueImplementation<Integer>();
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		System.out.println("[1, 2, 3]".equals(testQueue.toString()));
		testQueue.clear();
		System.out.println("[]".equals(testQueue.toString()));
	}

	private static void testSize() {
		System.out.println("Testing Size");
		OurQueue<Integer> testQueue = new OurQueueImplementation<Integer>();
		testQueue.enqueue(1);
		testQueue.enqueue(2);
		testQueue.enqueue(3);
		testQueue.enqueue(4);
		System.out.println(4 == testQueue.size());
		testQueue.enqueue(5);
		System.out.println(5 == testQueue.size());
	}
	
	private static void testIsEmpty() {
		System.out.println("Testing isEmpty");
		OurQueue<Integer> testQueue = new OurQueueImplementation<Integer>();
		System.out.println(testQueue.isEmpty());
		testQueue.enqueue(1);
		System.out.println(!testQueue.isEmpty());
	}
	
	private static void testHead() {
		System.out.println("Testing Head");
		OurQueue<String> testQueue = new OurQueueImplementation<String>();
		testQueue.enqueue("Apple");
		testQueue.enqueue("Banana");
		testQueue.enqueue("Cherry");
		System.out.println("Apple".equals(testQueue.head()));
		// Makes sure head() does not remove the element
		System.out.println("Apple".equals(testQueue.head()));
	}
	
	private static void testThatHeadThrowsAnExceptionWhenItsEmpty() {
		System.out.println("Testing Head Exception");
		OurQueue<String> testQueue = new OurQueueImplementation<String>();
		try { 
			testQueue.head();
			System.out.println(false);
		} catch (NoSuchElementException e) {
			System.out.println(true);
		}
	}
}
