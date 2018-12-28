package leetCode;

public class IntegerPa {
    /*
     * Determine whether an integer is a palindrome. An integer is a palindrome when
     * it reads the same backward as forward.
     * 
     * Example 1:
     * 
     * Input: 121 Output: true Example 2:
     * 
     * Input: -121 Output: false Explanation: From left to right, it reads -121.
     * From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     * 
     * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore
     * it is not a palindrome. Follow up:
     * 
     * Coud you solve it without converting the integer to a string?
     */

    public boolean isPalindrome(int x) {
	if (x < 0) {
	    return false;
	}
	// find how large this integer is
	int scale = 1;
	while (x / scale >= 10) {
	    // System.out.println(scale);
	    scale *= 10;
	}

	boolean result = true;
	while (x >= 1 && result) {
	    System.out.println(x);
	    result = x % 10 == x / scale;
	    x -= (x / scale) * scale;
	    x /= 10;
	    scale /= 100;
	}

	return result;
    }

    public static void main(String[] args) {
	System.out.println(new IntegerPa().isPalindrome(1111111));
    }
}
