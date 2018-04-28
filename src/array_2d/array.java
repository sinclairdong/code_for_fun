package array_2d;

public class array {
	/**
	 * Given a matrix (or 2D array) a[][] of integers, find prefix sum matrix for
	 * it. Let prefix sum matrix be psa[][]. The value of psa[i][j] contains sum of
	 * all values which are above it or on left of it.
	 */
	private static int[][] prefix_sum(int[][] input) {
		int[][] result = new int[input.length][input[0].length];
		// populate line 0 0
		result[0][0] = input[0][0];
		// populate first line
		for (int i = 1; i < input[0].length; i++) {
			result[0][i] = input[0][i] + result[0][i - 1];
		}
		for (int i = 1; i < input.length; i++) {
			result[i][0] = input[i][0] + result[i - 1][0];
		}
		// popluate the rest
		for (int i = 1; i < input[0].length; i++) {
			for (int n = 1; n < input.length; n++) {
				result[i][n] = input[i][n] + result[i - 1][n] + result[i][n - 1] - result[i - 1][n - 1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] input = { { 10, 20, 30 }, { 5, 10, 20 }, { 2, 4, 6 } };
		int[][] result = prefix_sum(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print("[");
			for (int n = 0; n < input[0].length; n++) {
				System.out.print(result[i][n] + " , ");
			}
			System.out.println("]");
		}
	}
}
