
import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] arr2 = { -50, -50, -48, -47, -44, -44, -37, -35, -35, -32, -32, -31, -29, -29, -28, -26, -24, -23, -23, -21,
				-20, -19, -17, -15, -14, -12, -12, -11, -10, -9, -8, -5, -2, -2, 1, 1, 3, 4, 4, 7, 7, 7, 9, 10, 11, 12, 14,
				16, 17, 18, 21, 21, 24, 31, 33, 34, 35, 36, 41, 41, 46, 48, 48 };

		// int[] arr1 = {1, 2, 3, 0, 0, 0};
		// int[] arr2 = {2, 5, 6};
		
		merge(arr1, 0, arr2, arr2.length);
		
		System.out.println(Arrays.toString(arr1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		// base case when m == 0, mean all elements are zero
		if (m == 0) {
			for (int i = 0; i < nums1.length && i < nums2.length; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		int currM = m == 0 ? 0 : m - 1;   //first array index starts at 0
		int lastIndex = m + n - 1; // result array index from last
		int currN = n - 1;  // second array index from last

		while (currM >= 0 && currN >= 0) {  // start at index
			if (nums1[currM] > nums2[currN]) { 
				nums1[lastIndex--] = nums1[currM--];
			} else {
				nums1[lastIndex--] = nums2[currN--];
			}
		}
		// to process any remaining elements in the second array
		while (currN >= 0 && lastIndex >= 0) {
			nums1[lastIndex--] = nums2[currN--];
		}
	}

}
