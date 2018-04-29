package n_bonacci;

public class Nbonacci {
	/**
	 * N-bonacci Numbers You are given two Integers N and M, and print all the terms
	 * of the series upto M-terms of the N-bonacci Numbers. For example, when N = 2,
	 * the sequence becomes Fibonacci, when n = 3, sequence becomes Tribonacci.
	 * 
	 * In general, in N-bonacci sequence, we use sum of preceding N numbers from the
	 * next term. For example, a 3-bonacci sequence is the following: 0, 0, 1, 1, 2,
	 * 4, 7, 13, 24, 44, 81
	 * 
	 * The Fibonacci sequence is a set of numbers that starts with one or zero,
	 * followed by a one, and proceeds based on the rule that each number is equal
	 * to the sum of preceding two numbers 0, 1, 1, 2, 3, 5, 8…..
	 * 
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++) {
			System.out.println(nbonacci(i, 3));
		}

		int[] result = nbonacci_list(8, 3);
		for (Integer item : result) {
			System.out.println(item);
		}
	}

	/**
	 * this is return mth nbonacci with recursion
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	private static int nbonacci(int m, int n) {
		if (m < n) {
			return 0;
		} else if (m == n) {
			return 1;
		} else {
			int result = 0;
			for (int i = 1; i <= n; i++) {
				result += nbonacci(m - i, n);
			}
			return result;
		}
	}

	/**
	 * return a list of nbonacci number for 1 - n using loops
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	private static int[] nbonacci_list(int m, int n) {
		// Assuming m >= n.
		int a[] = new int[m];
		a[n - 1] = 1;

		// Computing every term as sum of previous
		// n terms.
		for (int i = n; i < m; i++) {
			for (int j = i - n; j < i; j++) {
				a[i] += a[j];
			}
		}
		return a;
	}

}
