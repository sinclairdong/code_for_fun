package find_the_Closest_Palindrome;

public class Palindrom {
	public static int findJob(int[][] schedule) {

		return 0;
	}

	private static boolean conflict(int[] a, int[] b) {
		boolean result = a[1] != a[0];
		for (int i = a[0]; i != a[1]; i = (i + 1) % 24) {
			if (b[0] == i || b[1] == i) {
				result = false;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 4, 16 };
		int[] b = { 11, 5 };
		System.out.println("start");
		System.out.println(conflict(a, b));
	}
}
