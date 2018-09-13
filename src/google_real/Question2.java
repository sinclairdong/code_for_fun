package google_real;

public class Question2 {
	public static int solution1(String[] L) {
		int result = 0;
		for (int i = 0; i < L.length; i++) {
			if (checkLength(L[i]) > 1) {
				result++;
			}
		}
		return result;
	}

	public static int checkLength(String str) {
		String result = str.substring(0, str.indexOf("@"));
		int plus_loc = str.indexOf("+");
		if (plus_loc != -1) {
			result = result.substring(0, plus_loc);
		}
		result = result.replace(".", "");
		return result.length();
	}

	public static void main(String[] args) {
		System.out.println(checkLength("a.b@example.com"));
	}
}
