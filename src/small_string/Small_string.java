package small_string;

import java.util.ArrayList;
import java.util.List;

public class Small_string {
	/**
	 * Given n strings, concatenate them in an order that produces the
	 * lexicographically smallest possible string.
	 * 
	 * Input : a[] = ["c", "cb", "cba"] Output : cbacbc
	 * 
	 * Input : a[] = ["aa", "ab", "aaa"] Output : aaaaaab
	 * 
	 * @param input
	 * @return
	 */
	private static String small_string(List<String> input) {
		String local_min = input.get(0);
		for (int i = 1; i < input.size(); i++) {
			if (local_min.compareTo(input.get(i)) > 0) {
				local_min = input.get(i);
			}
		}
		return local_min;
	}

	private static ArrayList<String> permutation(ArrayList<String> input) {
		if (input.size() == 1) {
			return input;
		} else {
			ArrayList<String> result = new ArrayList<>();
			for (String item : input) {
				ArrayList<String> new_input = ((ArrayList<String>) input.clone());
				new_input.remove(item);
				ArrayList<String> postfix = permutation(new_input);
				for (String p_item : postfix) {
					result.add(item + p_item);
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<>();
		input.add("c");
		input.add("cb");
		input.add("cba");
		System.out.println(small_string(permutation(input)));
	}
}
