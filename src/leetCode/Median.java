package leetCode;

public class Median {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
	int[] temp = new int[nums1.length + nums2.length];

	int counter1 = 0;
	int counter2 = 0;

	while (counter1 < nums1.length || counter2 < nums2.length) {

	    if ((counter2 == nums2.length)) {
		temp[counter1 + counter2] = nums1[counter1];
		counter1++;
	    } else if (counter1 == nums1.length || nums1[counter1] >= nums2[counter2]) {
		temp[counter1 + counter2] = nums2[counter2];
		counter2++;
	    } else if (nums1[counter1] < nums2[counter2]) {
		temp[counter1 + counter2] = nums1[counter1];
		counter1++;
	    }
	}

	return temp.length % 2 == 0 ? ((double) temp[temp.length / 2 - 1] + temp[temp.length / 2]) / 2
		: temp[temp.length / 2];

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

	int counter1 = 0;
	int counter2 = 0;
	int totalLength = nums1.length + nums2.length;
	int num1 = 0, num2 = 0;
	for (int i = 0; i <= totalLength / 2; i++) {
	    num1 = num2;

	    if ((counter2 == nums2.length)) {
		num2 = nums1[counter1];
		counter1++;
	    } else if (counter1 == nums1.length || nums1[counter1] >= nums2[counter2]) {
		num2 = nums2[counter2];
		counter2++;
	    } else if (nums1[counter1] < nums2[counter2]) {
		num2 = nums1[counter1];
		counter1++;
	    }
	}

	return totalLength % 2 == 0 ? ((double) num1 + num2) / 2 : num2;

    }

    public static void main(String[] args) {
	int[] a = { 1, 2 };
	int[] b = { 3, 4 };
	System.out.println(new Median().findMedianSortedArrays2(a, b));
    }
}
