
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero. Note: The solution set must
 * not contain duplicate triplets. Example: Given array nums = [-1, 0, 1, 2, -1, -4], A solution set
 * is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = threeSum(nums);
		
		for (List<Integer> pairs : result) {
			System.out.println(pairs);
		}
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length == 0)
			return result;

		if (nums.length == 3) {
			if (nums[0] + nums[1] + nums[2] == 0)
				result.add(Arrays.asList(nums[0], nums[1], nums[2]));
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {  // To handle duplicates
				int start = i + 1;
				int end = nums.length - 1;

				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];
					if (sum == 0) {
						result.add(Arrays.asList(nums[i], nums[start], nums[end]));

						int temp = start;
						while (nums[start] == nums[temp] && start < end)
							start++; // this increments start++ and handle duplicates from start

						temp = end;
						while (nums[end] == nums[temp] && start < end)
							end--; // this decrements end-- and handle duplicates from end

					} else if (sum < 0) {
						start++;
					} else {
						end--;
					}
				}
			}
		}
		return result;
	}
}
