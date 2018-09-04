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

	public static void main(String[] args) {
		System.out.println(solution("2-4A0r7-4k", 3));
		System.out.println(solution("2-4A0r7-4k", 4));
		System.out.println(solution("r", 1));
	}
}
