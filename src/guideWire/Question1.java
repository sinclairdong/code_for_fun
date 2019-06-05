package guideWire;

import java.util.PriorityQueue;

public class Question1 {
  public static void main(String[] args) {

    System.out.println(solution(213));
  }

  public static int solution(int N) {
    // write your code in Java SE 8

    PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
    int digit = 0;
    while (N > 0) {
      queue.add(N % 10);
      N /= 10;
      digit++;
    }

    int result = 0;
    if (digit >= 9) {
      return -1;
    }
    while (!queue.isEmpty()) {
      result += queue.poll() * Math.pow(10, digit - 1);
      digit--;
    }
    return result;
  }
}
