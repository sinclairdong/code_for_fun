package google_real;

public class Question1 {

	public static int solution1(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			int temp = find_fruit(A, i);
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	public static int find_fruit(int[] trees, int index) {
		int i = index + 1;
		int[] busket = { trees[index], -1 };
		boolean if_fits = true;
		while (if_fits && i < trees.length) {
			if (busket[1] == -1 && busket[0] != trees[i]) {
				busket[1] = trees[i];
			} else if (busket[0] != trees[i] && busket[1] != trees[i]) {
				if_fits = false;
			}
			if (if_fits) {
				i++;
			}
		}
		return i - index;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 1, 3, 4, 3, 5, 1, 2 };
		int[] b = { 1, 2, 1, 2, 1, 2, 1 };
		int[] c = { 1, 2, 1, 2, 3, 4, 3, 4, 3, 4, 5, 6 };
		int[] d = { 1, 2, 1, 1, 1, 3, 3, 3, 4, 4, 5, 6 };
		System.out.println(solution1(a));
		System.out.println(solution1(b));
		System.out.println(solution1(c));
		System.out.println(solution1(d));
	}
}
