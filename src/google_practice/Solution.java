package google_practice;

public class Solution {
	public static String solution(String s, int K) {
		String s_without_dash = s;
		s_without_dash = s_without_dash.replace("-", "");
		String result;
		if (s_without_dash.length() - 4 < 0) {
			result = s_without_dash;
		} else {
			result = s_without_dash.substring(s_without_dash.length() - K);
			for (int i = s_without_dash.length() - K; i > 0; i -= K) {
				if (i - K <= 0) {
					result = s_without_dash.substring(0, i) + "-" + result;
				} else {
					result = s_without_dash.substring(i - K, i) + "-" + result;
				}

			}
		}
		return result.toUpperCase();
	}

	private static final String SEP = "-";

	public static String solution2(String s, int K) {
		// re move all -
		StringBuilder sBder = new StringBuilder(s);
		int location = sBder.lastIndexOf(SEP);
		while (location != -1) {
			sBder.deleteCharAt(location);
			location = sBder.lastIndexOf(SEP);
		}
		int firstDash = sBder.length() % K;
		if (sBder.length() / K != 0 && firstDash != 0) {
			sBder.insert(firstDash, SEP);
		}
		for (int i = firstDash + K + (firstDash == 0 ? 0 : 1); i < sBder.length(); i += K + 1) {
			sBder.insert(i, SEP);
		}
		return sBder.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution2("2-4A0r7-4k", 3));
		System.out.println(solution2("2-4A0r7-4k", 4));
		System.out.println(solution2("r", 4));
		System.out.println(solution2("r", 1));
	}
}
