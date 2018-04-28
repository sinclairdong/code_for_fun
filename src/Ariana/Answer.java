package Ariana;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Answer {
	private static ArrayList<String> findAllPermum(ArrayList<String> original) {
		if (original.size() == 1) {
			return original;
		}
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < original.size() - 2; i += 2) {
			String temp = "(" + original.get(i) + original.get(i + 1) + original.get(i + 2) + ")";
			ArrayList<String> tempList = (ArrayList<String>) original.clone();
			tempList.set(i, temp);
			tempList.remove(i + 1);
			tempList.remove(i + 1);
			String tempResult = "";
			for (int n = 0; n < tempList.size(); n++) {
				tempResult += tempList.get(n);
				// System.out.println(tempList.get(n));
			}
			result.add(tempResult);
			result.addAll(findAllPermum(tempList));
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<String> eq = new ArrayList<>();
		eq.add("1.1");
		eq.add("*");
		eq.add("100");
		eq.add("-");
		eq.add("4");
		eq.add("+");
		eq.add("42");
		eq.add("/");
		eq.add("2");
		eq.add("+");
		eq.add("12");
		eq.add("*");
		eq.add("3");
		ArrayList<String> eq1 = new ArrayList<>();
		eq1.add("121");
		eq1.add("-");
		eq1.add("4");
		eq1.add("+");
		eq1.add("42");
		eq1.add("/");
		eq1.add("2");
		eq1.add("+");
		eq1.add("12");
		eq1.add("*");
		eq1.add("3");
		ArrayList<String> result1 = findAllPermum(eq1);
		ArrayList<String> result = findAllPermum(eq);
		BigDecimal resultNum = null;
		for (int i = 0; i < result.size(); i++) {

			Expression expression = new Expression(result.get(i));
			resultNum = expression.eval();
			// System.out.println(result.get(i) + " = " + resultNum);
			if (resultNum.compareTo(new BigDecimal(100)) == 0) {
				System.out.println(result.get(i) + " = " + resultNum);
			}
		}
		for (int i = 0; i < result1.size(); i++) {

			Expression expression = new Expression(result1.get(i));
			resultNum = expression.eval();
			// System.out.println(result.get(i) + " = " + resultNum);
			if (resultNum.compareTo(new BigDecimal(100)) == 0) {
				System.out.println(result1.get(i) + " = " + resultNum);
			}
		}
	}
}
