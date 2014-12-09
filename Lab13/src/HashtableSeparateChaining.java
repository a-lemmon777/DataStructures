// Aaron Lemmon

import java.util.LinkedList;

public class HashtableSeparateChaining<K, V> implements OurHashtable<K, V> {
	
	private static final int defaultNumberOfBuckets = 20;
	private int numberOfBuckets;
	private int count = 0;
	
	private LinkedList<KVPair<K, V>>[] buckets;
	
	public HashtableSeparateChaining() {
		this.numberOfBuckets = defaultNumberOfBuckets;
		this.setup();
	}
	
	public HashtableSeparateChaining(int numberOfBuckets) {
		this.numberOfBuckets = numberOfBuckets;
		this.setup();
	}
	
	private void setup() {
		buckets = new LinkedList[numberOfBuckets];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<KVPair<K, V>>();
		}
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void put(K key, V value) {
		int index = getIndex(key);
		buckets[index].add(new KVPair<K, V>(key, value));
		count++;
	}

	@Override
	public V get(K key) {
		int index = getIndex(key);
		return getDesiredValue(key, buckets[index]);
	}

	private V getDesiredValue(K key, LinkedList<KVPair<K, V>> linkedList) {
		for (KVPair<K, V> pair : linkedList) {
			if (pair.key == key) {
				return pair.value;
			}
		}
		// Key not found
		return null;
	}

	private int getIndex(K key) {
		return key.hashCode() % numberOfBuckets;
	}

	@Override
	public void clear() {
		count = 0;
		// I could have just called setup() here, but I thought destroying everything and recreating it all was overkill.
		for (LinkedList<KVPair<K, V>> linkedList : buckets) {
			linkedList.clear();
		}
	}
}