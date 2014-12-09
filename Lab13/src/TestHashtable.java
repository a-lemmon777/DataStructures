// Aaron Lemmon

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHashtable {
	OurHashtable<Integer, String> emptyTable = new HashtableSeparateChaining<Integer, String>();
	OurHashtable<Integer, String> fourElementTable = new HashtableSeparateChaining<Integer, String>();
	OurHashtable<Integer, String> repeatedKeysTable = new HashtableSeparateChaining<Integer, String>();

	@Before
	public void setUp() {
		// setting up fourElement table, no repeats
		fourElementTable.put(4, "apple");
		fourElementTable.put(6, "banana");
		fourElementTable.put(1, "strawberry");
		fourElementTable.put(3, "kiwi");

		// setting up repeatedKeysTable, assuming 20 buckets
		repeatedKeysTable.put(4, "apple");
		repeatedKeysTable.put(3, "banana");
		repeatedKeysTable.put(27, "grape");
		repeatedKeysTable.put(33, "orange");
		repeatedKeysTable.put(10, "pomegranate");
		repeatedKeysTable.put(45, "grapefruit");
		repeatedKeysTable.put(17, "clementine");
		repeatedKeysTable.put(44, "strawberry"); // these two should
		repeatedKeysTable.put(23, "kiwi");		 // cause hash collisions
	}
	
	@Test
	public void testSizeAndEmptyWithEmptyTable() {
		assertTrue(emptyTable.isEmpty());
		assertEquals(0, emptyTable.size());
	}
	
	@Test
	public void testSizeAndEmptyWithNonEmptyTable() {
		assertFalse(fourElementTable.isEmpty());
		assertFalse(repeatedKeysTable.isEmpty());
		
		assertEquals(4, fourElementTable.size());
		assertEquals(9, repeatedKeysTable.size());
	}
	
	@Test
	public void testGetWithoutCollision() {
		assertEquals("apple", fourElementTable.get(4));
		assertEquals("banana", fourElementTable.get(6));
		assertEquals("strawberry", fourElementTable.get(1));
	}

	@Test
	public void testGetWithCollision(){
		assertEquals("apple", repeatedKeysTable.get(4));
		assertEquals("banana", repeatedKeysTable.get(3));
		assertEquals("strawberry", repeatedKeysTable.get(44));
	}
	
	@Test
	public void testGetNotThere(){
		assertNull(repeatedKeysTable.get(500));
	}
	
	@Test (expected=NullPointerException.class)
	public void testGetNull() {
		repeatedKeysTable.get(null);
	}
	
	@Test
	public void testClear() {
		fourElementTable.clear();
		assertTrue(fourElementTable.size() == 0);
		assertTrue(fourElementTable.isEmpty());
		assertNull(fourElementTable.get(4));
		assertNull(fourElementTable.get(6));
		assertNull(fourElementTable.get(1));
		assertNull(fourElementTable.get(3));
	}
	
	@Test (expected=NullPointerException.class)
	public void testPutNull() {
		emptyTable.put(null, "dragon");
	}
	
	@Test 
	public void testPutNullDoesntIncrementSize() {
		try {
			emptyTable.put(null, "dragon");
		} catch (Exception e) {
		}
		assertEquals(0, emptyTable.size());
	}
}