package datastructures.hash;

public class HashTable {

	public static void main(String[] args) {
		Hash<Integer> hash = new Hash(1000);

		hash.put("A", 1);
		hash.put("B", 2);
		hash.put("C", 3);
		hash.put("D", 4);
		hash.put("E", 5);
		hash.put("E", 5);
		hash.put("E", 6);
		System.out.println("hash size : " + hash.size);
		System.out.println("hash.get(\"A\") : " + hash.get("A"));
		System.out.println("hash.get(\"E\") : " + hash.get("E"));
		hash.put("E", 7);
		System.out.println("UPDAET E 7");
		System.out.println("hash.get(\"E\") : " + hash.get("E"));
		hash.remove("E");
		System.out.println("DELETE E");
		System.out.println("hash size : " + hash.size);
		hash.remove("E");
		hash.remove("A");
		hash.remove("B");
		System.out.println("DELETE E, A, B");
		System.out.println("hash size : " + hash.size);
	}

	static class Hash<V> {
		private static final int DEFAULT_BUCKET_SIZE = 10000;

		private Entry<V>[] buckets;
		private int size;

		public Hash() {
			this(DEFAULT_BUCKET_SIZE);
		}

		public Hash(int bucketSize) {
			buckets = new Entry[bucketSize];
			this.size = 0;
		}

		public int hash(String key) {
			int hashCode = 0;
			char[] charArr = key.toCharArray();
			for (char c : charArr) {
				hashCode += c;
			}

			return hashCode % buckets.length;
		}

		public V get(String key) {
			Entry<V> entry = getNode(key);

			if (entry == null) {
				return null;
			}

			return entry.value;
		}

		public void put(String key, V value) {
			Entry<V> bucket = getNode(key);
			if (bucket != null) {
				bucket.setValue(value);
			} else {
				Entry<V> root = buckets[hash(key)];
				if (root == null) {
					buckets[hash(key)] = new Entry<V>(key, value);
				} else {
					while (root.next != null) {
						root = root.next;
					}
					root.setNext(new Entry<V>(key, value));
				}
				this.size++;
			}
		}

		public V remove(String key) {
			Entry<V> bucket = getNode(key);
			if (bucket == null) {
				return null;
			}

			int hash = hash(key);
			Entry<V> root = buckets[hash];
			for (Entry<V> prev = null; root != null; prev = root, root = root.next) {
				if (root.key.equals(key)) {
					if (prev != null) {
						prev.next = root.next;
					} else {
						buckets[hash] = root.next;
					}
					this.size--;
					V oldValue = root.value;
					root.value = null;
					return oldValue;
				}
			}
			return null;
		}

		private Entry<V> getNode(String key) {
			Entry<V> entry = buckets[hash(key)];
			if (entry == null)
				return null;

			do {
				if (entry.key.equals(key))
					break;
				entry = entry.next;
			} while (entry.next != null);

			return entry;
		}
	}

	static class Entry<V> {
		private String key;
		private V value;
		private Entry<V> next;

		public Entry(String key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		public String getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Entry<V> getNext() {
			return next;
		}

		public void setNext(Entry<V> next) {
			this.next = next;
		}
	}
}
