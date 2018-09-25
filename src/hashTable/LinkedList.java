package hashTable;

public class LinkedList<K, V> {
	public Node<K, V> head = null;

	public void insert(K key, V value) {
		Node<K, V> newNode = new Node<>(key, value, null);
		if (this.head == null) {
			this.head = newNode;
		} else {
			Node<K, V> temp = head;
			while (temp.hasNext()) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	public V lookUp(K key) {
		Node<K, V> temp = head;
		V result = null;
		if (temp != null) {
			boolean exit = true;
			do {
				if (temp.getKey().equals(key)) {
					result = temp.getValue();
					exit = false;
				}
				temp = temp.getNext();
			} while (temp != null && exit);

		}
		return result;
	}

	public boolean delete(K key) {
		boolean result = false;
		if (head.getKey().equals(key)) {
			head = head.getNext();
			result = true;
		} else {
			Node<K, V> prev = head;
			Node<K, V> temp = head.getNext();
			boolean exit = true;
			while (exit && temp != null) {
				if (temp.getKey().equals(key)) {
					prev.setNext(temp.getNext());
					exit = false;
					result = true;
				}
				temp = temp.getNext();
				prev = prev.getNext();
			}

		}
		return result;
	}
}
