package leetCode;

public class ReverseInterger {
    public int reverse(int x) {
	// find how large this integer is
	long scale = 1;
	while ((x / scale >= 10 && x > 0) || (x < 0 && x / scale <= -10)) {
	    // System.out.println(scale);
	    scale *= 10;
	}
	int counter = 10;
	long result = 0;
	while (scale >= 1) {
	    System.out.println(x % counter + "          " + result + "         " + scale);
	    result += (x % counter) * scale;
	    if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE) {
		return 0;
	    }
	    x /= 10;
	    scale /= 10;
	}
	return (int) result;
    }

    public static void main(String[] args) {
	System.out.println(new ReverseInterger().reverse(-2147483647));
    }
}
