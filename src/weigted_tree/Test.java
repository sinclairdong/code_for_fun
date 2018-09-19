package weigted_tree;

public class Test {
	public static void main(String[] args) {
		Weight_tree wt = new Weight_tree();
		Node a = new Node(null, null, 20);
		Node b = new Node(null, null, 100);
		Node c = new Node(a, b, 10);
		Node d = new Node(null, null, 10);
		Node e = new Node(c, d, 0);
		wt.head = e;
		System.out.println(wt.find_max_weight());
	}
}
