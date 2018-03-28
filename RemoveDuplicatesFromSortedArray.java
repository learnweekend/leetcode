import java.util.Arrays;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 Example:
 Given nums = [1,1,2],
 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	
	/** 
	 * Solution : start the loop with 1 and compare i and i - 1
	 *  if they are not equal, replace next index element.
	 *  Runtome : O(N), space : O(1).
	 */
	public static int removeDuplicatesV2(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		
		if (arr.length < 2)
			return arr.length;
		
		int index = 1;
		for (int i = 1; i < arr.length; i++)
			if (arr[i] != arr[i - 1])
				arr[index++] = arr[i];

		return index;
	}
	/**
	 * Solution : Traverse the array, compare i and i+1 elements
	 * if they are same, replace arr[i] = Integer.MIN_VALUE,  otherwise, move on..
	 * Move all Integer.MIN_VALUE elements to end
	 * Runtime :O(N), Space : O(1)
	 */
	public static int removeDuplicates(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;

		int index = 0;
		while (index < arr.length - 1) {
			if (arr[index] == arr[index + 1]) {
				arr[index] = Integer.MIN_VALUE;  // replace the duplicate value with MIN_VALUE
			}
			index++;
		}
		return moveInvalidElementsToEnd(arr);
	}

	private static int moveInvalidElementsToEnd(int[] arr) {
		int index = 0;
		int size = 0;  // gives the size of unique elements
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != Integer.MIN_VALUE) {
				arr[index++] = arr[i];
				size++;
			}
		while (index < arr.length)
			arr[index++] = Integer.MIN_VALUE;  // move to end

		return size;
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 1 , 1, 2, 2, 3, 3, 4};
		int[] arr2 = { 1, 2, 2, 3, 3, 4, 4, 5, 5};
		System.out.println(removeDuplicates(arr1));
		System.out.println(Arrays.toString(arr1));
		System.out.println(removeDuplicatesV2(arr2));
		System.out.println(Arrays.toString(arr2));
	}
}
