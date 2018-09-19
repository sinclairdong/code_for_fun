package weigted_tree;

public class Weight_tree {
	public Node head;

	public int find_max_weight() {
		return find_max_helper(this.head);
	}

	private int find_max_helper(Node head) {
		return head == null ? 0
				: Math.max(find_max_helper(head.getLeft()), find_max_helper(head.getRight())) + head.getWeight();
	}
}
