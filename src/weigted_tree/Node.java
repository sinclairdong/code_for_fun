package weigted_tree;

public class Node {
	private Node left;
	private Node right;
	private int left_weight;
	private int right_weight;

	public Node(Node left, Node right, int left_weight, int right_weight) {
		super();
		this.left = left;
		this.right = right;
		this.left_weight = left_weight;
		this.right_weight = right_weight;
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

	public int getLeft_weight() {
		return left_weight;
	}

	public void setLeft_weight(int left_weight) {
		this.left_weight = left_weight;
	}

	public int getRight_weight() {
		return right_weight;
	}

	public void setRight_weight(int right_weight) {
		this.right_weight = right_weight;
	}

}
