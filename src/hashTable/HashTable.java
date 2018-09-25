package hashTable;

public class HashTable<K, V> {
	private LinkedList<K, V>[] storage;
	private double THRESH_HOLD = 0.75;
	private int DEFAULT_CAPACITY = 16;
	private int size = 0;
	private boolean dynamic;

	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		this.storage = new LinkedList[capacity];
		for (int i = 0; i < capacity; i++) {
			storage[i] = new LinkedList<K, V>();
		}
		dynamic = false;
	}

	@SuppressWarnings("unchecked")
	public HashTable() {
		this.storage = new LinkedList[DEFAULT_CAPACITY];
		for (int i = 0; i < DEFAULT_CAPACITY; i++) {
			storage[i] = new LinkedList<K, V>();
		}
		dynamic = true;
	}

	public void insert(K key, V value) {
		storage[get_location(key)].insert(key, value);
		size++;
		if (dynamic && storage.length * THRESH_HOLD < size) {
			// dynamic change array size to do
		}
	}

	private int get_location(K key) {
		return key.hashCode() % storage.length;
	}

	public boolean delete(K key) {
		boolean result = storage[get_location(key)].delete(key);
		if (result) {
			size--;
		}
		return result;
	}

}
