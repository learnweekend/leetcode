
class Solution {
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 0;
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		if (nums.length == 1)
			if (nums[0] == target)
				return 0;

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return mid;
			} 
			
			if (nums[mid] > nums[0]) { // left is sorted
				if (target > nums[0] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target > nums[mid] && target < nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}