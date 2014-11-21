// Lemmon, Lenny, Valencia

/*
 * Binary search tree stores values indexed by keys. Keys must be Comparable and
 * are organized based on their natural ordering (i.e. the ordering given by
 * their compareTo). Values can be of any object type. This tree implementation
 * is not balanced, i.e. it may behave as a linked list in the worst case. Keys
 * may not be repeated, but values can.
 */

public class BinarySearchTree<K extends Comparable<K>, V> {
	private BSTNode root = null;

	/*
	 * true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {		
		return root == null;
	}

	/*
	 * Adds a given value indexed with a given key to the tree according to the
	 * binary search structure.  If the key is already present, this method throws
	 * a DuplicateKeyException.
	 */
	public void add(K key, V value) {
		if (isEmpty()) {
			root = new BSTNode(key, value);
		} 
		else {
			root.add(key, value);
		}
	}

	/*
	 * Returns the value associated with the given key in this binary search tree.
	 * If there is no element associated with this key, null is returned.
	 */
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		if (root == null) {
			return null;
		}
		return root.get(key);
	}

	/*
	 * Removes an element with the given key. The resulting tree is a binary
	 * search tree. If there is no such key, the tree is unchanged. Returns
	 * the value associated with this key or null if there is no such value. 
	 */
	public V remove(K key) {
		if (root == null) {
			return null;
		}
		if (key == root.key) {
			return removeAtRoot(key);
		}
		return root.remove(key);
	}
	
	private V removeAtRoot(K key) {
		V toReturn = root.value;
		root = root.removeMe();
		return toReturn;
	}

	/*
	 * Clears all elements from the tree.
	 */
	public void clear() {
		root = null;
	}

	private class BSTNode {
		public K key;
		public V value;
		public BSTNode leftChild = null;
		public BSTNode rightChild = null;

		/*
		 * null key will generate a null pointer exception when
		 * a method (such as compareTo) is called on it.
		 * This is matches the Java Collections Framework specification.
		 */

		public BSTNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public BSTNode getParentPredecessor() {
			if (rightChild.rightChild == null) {
				return this;
			}
			else {
				return rightChild.getParentPredecessor();
			}
		}

		public BSTNode getPredecessor(BSTNode ancestor) {
			if (this == ancestor) {
				return leftChild;
			}
			else {
				return rightChild;
			}
		}

		public void add(K addKey, V addValue) {
			int keyComparison = addKey.compareTo(key);
			if (keyComparison == 0) {
				throw new DuplicateKeyException(addKey);
			}
			else if (keyComparison < 0) {
				if (leftChild == null) {
					leftChild = new BSTNode(addKey, addValue);
				}
				else {
					leftChild.add(addKey, addValue);
				}
			}
			else {
				if (rightChild == null) {
					rightChild = new BSTNode(addKey, addValue);
				}
				else {
					rightChild.add(addKey, addValue);
				}
			}
		}

		public V get(K getKey) {
			int keyComparison = getKey.compareTo(key);
			if (keyComparison == 0) {
				return this.value;
			}
			else if (keyComparison < 0) {
				if (leftChild == null) {
					return null;
				}
				else {
					return leftChild.get(getKey);
				}
			}
			else {
				if (rightChild == null) {
					return null;
				}
				else {
					return rightChild.get(getKey);
				}
			}
		}

		public V remove(K removeKey) {
			int keyComparison = removeKey.compareTo(key);
			if (keyComparison < 0) {
				if (leftChild == null) {
					return null;
				}
				else if (leftChild.key == removeKey) {
					V toReturn = leftChild.value;
					leftChild = leftChild.removeMe();
					return toReturn;
				}
				else {
					return leftChild.remove(removeKey);
				}
			}
			else { // keyComparison > 0. If it's == to 0, we have duplicate keys. Oh noooesss!
				if (rightChild == null) {
					return null;
				}
				else if (rightChild.key == removeKey) {
					V toReturn = rightChild.value;
					rightChild = rightChild.removeMe();
					return toReturn;
				}
				else {
					return rightChild.remove(removeKey);
				}
			}
		}

		private BSTNode removeMe() {
			if (leftChild == null && rightChild == null) {
				return null;
			}
			else if (leftChild == null && rightChild != null) {
				return rightChild;
			}
			else if (leftChild != null && rightChild == null) {
				return leftChild;
			}
			else { // 2 kids
				BSTNode parentPredecessor;
				if (this.leftChild.rightChild == null) {
					parentPredecessor = this;
				} else {
					parentPredecessor = this.leftChild.getParentPredecessor();
				}
				BSTNode predecessor = parentPredecessor.getPredecessor(this);
				this.key = predecessor.key;
				this.value = predecessor.value;
				predecessor.removeMe();
				return this;
			}
		}
		

	}
}