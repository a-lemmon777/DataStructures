// Aaron Lemmon

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestBSTTraversals {

	private BinarySearchTree<Integer, String> emptyTree = new BinarySearchTree<Integer, String>();
	private BinarySearchTree<Integer, String> singletonTree = new BinarySearchTree<Integer, String>();
	private BinarySearchTree<Integer, String> simpleTree = new BinarySearchTree<Integer, String>();
	private BinarySearchTree<Integer, String> bigTree = new BinarySearchTree<Integer, String>();

	@Before
	public void setup() {
		singletonTree.add(10, "apple");
		
		simpleTree.add(10, "apple");
		simpleTree.add(5, "banana");
		simpleTree.add(15, "cucumber");
		
		bigTree.add(10, "apple");
		bigTree.add(5, "banana");
		bigTree.add(15, "cucumber");
		bigTree.add(6, "mango");
		bigTree.add(7, "pear");
		bigTree.add(12, "peach");
		bigTree.add(21, "kiwi");
	}
	
	@Test
	public void testInOrderOnEmptyTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		assertEquals(expected, emptyTree.inOrder());
	}

	@Test
	public void testInOrderOnSingletonTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(10, "apple"));
		assertEquals(expected, singletonTree.inOrder());
	}
	
	@Test
	public void testInOrderOnSimpleTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(5, "banana"));
		expected.add(new Pair<Integer, String>(10, "apple"));
		expected.add(new Pair<Integer, String>(15, "cucumber"));
		assertEquals(expected, simpleTree.inOrder());
	}
	
	@Test
	public void testInOrderOnBigTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(5, "banana"));
		expected.add(new Pair<Integer, String>(6, "mango"));
		expected.add(new Pair<Integer, String>(7, "pear"));
		expected.add(new Pair<Integer, String>(10, "apple"));
		expected.add(new Pair<Integer, String>(12, "peach"));
		expected.add(new Pair<Integer, String>(15, "cucumber"));
		expected.add(new Pair<Integer, String>(21, "kiwi"));
		assertEquals(expected, bigTree.inOrder());
	}
	
	@Test
	public void testPreOrderOnEmptyTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		assertEquals(expected, emptyTree.preOrder());
	}

	@Test
	public void testPreOrderOnSingletonTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(10, "apple"));
		assertEquals(expected, singletonTree.preOrder());
	}
	
	@Test
	public void testPreOrderOnSimpleTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(10, "apple"));
		expected.add(new Pair<Integer, String>(5, "banana"));
		expected.add(new Pair<Integer, String>(15, "cucumber"));
		assertEquals(expected, simpleTree.preOrder());
	}
	
	@Test
	public void testPreOrderOnBigTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(10, "apple"));
		expected.add(new Pair<Integer, String>(5, "banana"));
		expected.add(new Pair<Integer, String>(6, "mango"));
		expected.add(new Pair<Integer, String>(7, "pear"));
		expected.add(new Pair<Integer, String>(15, "cucumber"));
		expected.add(new Pair<Integer, String>(12, "peach"));
		expected.add(new Pair<Integer, String>(21, "kiwi"));
		assertEquals(expected, bigTree.preOrder());
	}
	
	@Test
	public void testPostOrderOnEmptyTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		assertEquals(expected, emptyTree.postOrder());
	}
	
	@Test
	public void testPostOrderOnSingletonTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(10, "apple"));
		assertEquals(expected, singletonTree.postOrder());
	}
	
	@Test
	public void testPostOrderOnSimpleTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(5, "banana"));
		expected.add(new Pair<Integer, String>(15, "cucumber"));
		expected.add(new Pair<Integer, String>(10, "apple"));
		assertEquals(expected, simpleTree.postOrder());
	}
	
	@Test
	public void testPostOrderOnBigTree() {
		ArrayList<Pair<Integer, String>> expected = new ArrayList<Pair<Integer, String>>();
		expected.add(new Pair<Integer, String>(7, "pear"));
		expected.add(new Pair<Integer, String>(6, "mango"));
		expected.add(new Pair<Integer, String>(5, "banana"));
		expected.add(new Pair<Integer, String>(12, "peach"));
		expected.add(new Pair<Integer, String>(21, "kiwi"));
		expected.add(new Pair<Integer, String>(15, "cucumber"));
		expected.add(new Pair<Integer, String>(10, "apple"));
		assertEquals(expected, bigTree.postOrder());
	}
}
