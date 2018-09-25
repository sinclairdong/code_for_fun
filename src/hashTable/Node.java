package hashTable;

public class Node<K, V> {
	private K key;
	private V value;

	private Node<K, V> next;

	public Node(K key, V value, Node<K, V> next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getNext() {
		return this.next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}

	public boolean hasNext() {
		return next != null;
	}
}
