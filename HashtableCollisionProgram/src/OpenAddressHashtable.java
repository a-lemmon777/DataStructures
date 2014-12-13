// Aaron Lemmon

public abstract class OpenAddressHashtable<K, V> implements OurHashtable<K,V> {
	public static final int N = 101;
	private int elementCount = 0;
	private KVPair<K,V>[] hashtable = new KVPair[N];
	private int collisionCount = 0;
	
	
	@Override
	public boolean isEmpty() {
		return this.elementCount == 0;
	}

	@Override
	public int size() {
		return this.elementCount;
	}

	@Override
	public void put(K key, V value) {
		if (key == null) throw new NullPointerException();
		
		boolean foundSpace = false;
		for (int probe = 0; !foundSpace && probe <= N; probe++) {
			if (probe > 0) {
				collisionCount ++;
			}
			int spot = getNextIndex(key, probe);
			if(hashtable[spot] == null){
				hashtable[spot] = new KVPair<K, V>(key, value);
				foundSpace = true;
				elementCount++;
			}
		}
		if (!foundSpace) { //have searched all indices without success (in linear or double hashing)
			throw new HashtableFullException(this);
		}
	}

	@Override
	public V get(K key) {
		if (key == null) throw new NullPointerException(); // otherwise will not throw exception if hashtable is empty
		
		for (int probe = 0; probe < N; probe++) {
			KVPair<K, V> element = hashtable[getNextIndex(key, probe)];
			if(element == null){
				return null;
			}
			else{
				if(element.key.equals(key)){
					return element.value;
				}
			}
		}
		// not found
		return null;
	}

	@Override
	public void clear() {
		this.hashtable = new KVPair[N];
		this.elementCount = 0;
	}
	

	public String toString() {
		String all = "";
		for (KVPair p : hashtable) {
			all += p;
		}
		return all;
	}
	
	
	/**
	 * Subclasses must implement this method, calculating the index in the manner
	 * appropriate to that subclass.
	 * @param key - the key whose next appropriate index is to be calculated
	 * @param probe - the number of previous attempts to find an index
	 * @return
	 */
	abstract protected int getNextIndex(K key, int probe);

	public int getCollisionCount() {
		return collisionCount;
	}

}