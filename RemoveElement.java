/*
 * https://leetcode.com/problems/remove-element/description/
 * 
 * Given an array and a value, remove all instances of that value in-place and return the new length.
	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	Example:
	Given nums = [3,2,2,3], val = 3,
	Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {
	/**
	 * Solution : 
	 * 1. Iterate the array and check for the element to remove.
	 * 2. Have two pointers at start and end
	 * 3. Move the start pointer forward and if element found, swap with last element of the array
	 * 4. return the start - which will be the final length of the array after removal.
	 */
	public static int removeElement(int[] arr, int k) {
		int start = 0;
		if (arr == null || arr.length == 0)
			return start;

		int end = arr.length - 1;
		while (start <= end) {
			if (arr[start] == k) {
				swap(arr, start, end);
				end--;
			} else {
				start++;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 2, 3 };
		System.out.println(removeElement(arr, 3));
	}
}
