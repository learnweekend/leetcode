/*
 * https://leetcode.com/problems/search-insert-position/description/
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	You may assume no duplicates in the array.
	Example 1:
	Input: [1,3,5,6], 5
	Output: 2
	
	Example 2:
	Input: [1,3,5,6], 2
	Output: 1
	
	Example 3:
	Input: [1,3,5,6], 7
	Output: 4
 */

public class SearchInsertPosition {

	public static int searchInsert(int[] arr, int target) {
      int index = binarySearch(arr, target);
		if(index == -1){
			return insertionIndex(arr, target - 0.5);
		}
		return index;
  }
	
	private static int insertionIndex(int[]arr, double target){
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end){
			int mid = start + (end - start)/2;
			if(arr[mid] < target)
				start = mid + 1;
			else 
				end = mid - 1;
		}
		return start;
	}
	
	private static int binarySearch(int[] arr, int target){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + ((high - low) >> 1);
			if(arr[mid] > target)
				high = mid - 1;
			else if(arr[mid] < target)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1,3,5,6}, 5)); //2
		System.out.println(searchInsert(new int[] {1,3,5,6}, 2)); //1
		System.out.println(searchInsert(new int[] {1,3,5,6}, 7)); //4
	}
}
