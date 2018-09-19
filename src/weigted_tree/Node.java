package weigted_tree;

public class Node {
	private Node left;
	private Node right;
	private int weight;

	public Node(Node left, Node right, int weight) {
		super();
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
