package guideWire;

import java.util.Arrays;

public class Test {
  public int solution(int[] A) {
    // write your code in Java SE 8
    Arrays.sort(A);
    int start = 0;
    while (start < A.length - 1 && A[start] < 0) {
      start++;
    }

    int pointer = 1;
    for (int i = start; i < A.length; i++) {

      if (A[i] == pointer) {
        pointer++;
      } else {
        return pointer;
      }

      while (i < A.length - 1 && A[i] == A[i + 1]) {
        i++;
      }
    }
    return pointer;

  }
}
