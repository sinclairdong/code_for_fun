package hashTable;

public class LinkedList<K, V> {
	private Node<K, V> head = null;

	public void insert(Node<K, V> newNode) {
		if (head == null) {
			head = newNode;
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
		boolean exit = true;
		while (temp.hasNext() && exit) {
			if (temp.getKey().equals(key)) {
				result = temp.getValue();
				exit = false;
			}
			temp = temp.getNext();
		}
		return result;
	}
}
