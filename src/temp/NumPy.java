package temp;

public class NumPy {
	public static int[] fib(int n) {
		int[] result = new int[n];
		result[0] = 1;
		result[1] = 1;
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = fib(20);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
