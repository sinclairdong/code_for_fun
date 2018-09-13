package ixl_learning;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
	public static long countMax(List<String> upRight) {
		// Write your code here
		List<List<Integer>> row = new ArrayList<>();
		for (int i = 0; i < upRight.size(); i++) {
			int[] command = command(upRight.get(i));
			row = move(command[0], command[1], row);
		}
		return getMax(row);

	}

	public static int getMax(List<List<Integer>> board) {
		int max = board.get(0).get(0);
		int result = 0;
		for (int i = 0; i < board.size(); i++) {
			List<Integer> temp = board.get(i);
			for (int n = 0; n < temp.size(); n++) {
				if (temp.get(n) == max) {
					result++;
				}
			}
		}
		return result;
	}

	public static List<List<Integer>> move(int r, int c, List<List<Integer>> board) {
		for (int i = 0; i < r; i++) {
			List<Integer> temp;
			if (i >= board.size()) {
				temp = new ArrayList<Integer>();
				board.add(temp);
			} else {
				temp = board.get(i);
			}
			for (int n = 0; n < c; n++) {
				if (n >= temp.size()) {
					temp.add(1);
				} else {
					int new_v = temp.get(n) + 1;
					temp.set(n, new_v);
				}
			}
		}
		return board;
	}

	public static int[] command(String a) {
		String[] temp = a.split(" ");
		int[] result = { Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) };
		return result;
	}

	public static void printboard(List<List<Integer>> board) {
		for (int i = 0; i < board.size(); i++) {
			List<Integer> temp = board.get(i);
			for (int n = 0; n < temp.size(); n++) {
				System.out.print(temp.get(n));
			}
			System.out.println(";");
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> board = move(3, 7, new ArrayList<List<Integer>>());
		board = move(2, 4, board);
		System.out.println(getMax(board));
	}
}
