package leetCode;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	int[] temp = new int[nums1.length + nums2.length];

	int counter1 = 0;
	int counter2 = 0;

	while (counter1 < nums1.length || counter2 < nums2.length) {
	    if (nums1[counter1] < nums2[counter2]) {
		temp[counter1 + counter2] = nums1[counter1];
		counter1++;
	    } else {
		temp[counter1 + counter2] = nums2[counter2];
		counter2++;
	    }
	}

	return (temp[Math.floorDiv(temp.length, 2)] + temp[(int) Math.ceil((double) temp.length / 2)]) / 2;

    }

    public static void main(String[] args) {
	int[] a = { 1, 3 };
	int[] b = { 2 };
	System.out.println(new Median().findMedianSortedArrays(a, b));
    }
}
