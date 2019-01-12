package leetCode;

public class mostWater {
    public int maxArea(int[] height) {
	int pointerI = 0, pointerE = height.length - 1;
	int result = height[pointerI] < height[pointerE] ? height[pointerI] * (pointerE - pointerI)
		: height[pointerE] * (pointerE - pointerI);
	while (pointerI < pointerE) {
	    if (height[pointerI] < height[pointerE]) {
		pointerI++;
	    } else {
		pointerE--;
	    }
	    int temp = height[pointerI] < height[pointerE] ? height[pointerI] * (pointerE - pointerI)
		    : height[pointerE] * (pointerE - pointerI);
	    result = result > temp ? result : temp;
	}

	return result;
    }
}
