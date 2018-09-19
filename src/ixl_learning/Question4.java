package ixl_learning;

import java.util.ArrayList;
import java.util.List;

public class Question4 {
	public static List<String> reducedFractionSums(List<String> expressions) {
		// Write your code here
		List<String> result = new ArrayList<>();
		for (int i = 0; i < expressions.size(); i++) {
			result.add(helper(expressions.get(i)));
		}
		return result;

	}

	public static String helper(String exps) {
		String[] num = exps.split("\\+");
		String[] num_a = num[0].split("/");
		String[] num_b = num[1].split("/");

		int a_up = Integer.parseInt(num_a[0]);
		int a_dw = Integer.parseInt(num_a[1]);
		int b_up = Integer.parseInt(num_b[0]);
		int b_dw = Integer.parseInt(num_b[1]);

		int new_divider = a_dw * b_dw;
		int new_up = a_up * b_dw + b_up * a_dw;

		return reduce(new_up, new_divider);
	}

	public static long gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	public static String reduce(int a, int b) {
		long gcm = gcm(a, b);
		return (a / gcm) + "/" + (b / gcm);
	}

	public static void main(String[] args) {
		System.out.println(helper("722/148+360/176"));
	}
}
