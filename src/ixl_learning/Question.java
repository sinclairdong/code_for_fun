package ixl_learning;

import java.util.ArrayList;

import java.util.List;

public class Question {
	public static int countHoles(int num) {
		// Write your code here
		int new_num = num;
		int counter = 10;
		int result = 0;
		while (new_num * 100 > counter) {
			int temp = new_num % counter;
			System.out.println(temp);
			switch (temp) {
			case 1:
			case 2:
			case 3:
			case 5:
			case 7:
				result += 0;
				break;
			case 0:
			case 4:
			case 6:
			case 9:
				result += 1;
				break;
			case 8:
				result += 2;
				break;
			default:
			}
			new_num /= 10;

		}
		return result;
	}

	public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
		// Write your code here
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			result.add(helper(a.get(i), b.get(i)));
		}
		return result;
	}

	public static int helper(String a, String b) {
		if (a.length() != b.length()) {
			return -1;
		}
		StringBuilder bSB = new StringBuilder(b);
		int result = 0;
		for (int i = 0; i < a.length(); i++) {
			String temp = a.charAt(i) + "";
			if (bSB.lastIndexOf(temp) == -1) {
				result++;
			} else {
				bSB = bSB.deleteCharAt(bSB.lastIndexOf(temp));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(helper("AB", "BB"));
	}
}
