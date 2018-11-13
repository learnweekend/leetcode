/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum. For example: Given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6. For this problem, return the maximum sum.
 * 
 */
public class SubArrayWithMaxSum {

	/**
	 * QUESTIONS TO ASK
	 * 
	 * 1. What elements are stored in the array either integer or double or float 2. is the sum of all
	 * numbers within the range of integers ? or should I use long 3. what if the input array is null or
	 * empty? 4. Can we use any Java built in library methods?
	 */

	/**
	 * Solution 1 brute force solution is to take all possible sub arrays and calculate the sum for each
	 * sub array and take the sum which has maximum
	 * This is exponential runtime
	 */
	public static void subArrayMaxSumSlow(int[] nums) {

		if (nums == null || nums.length == 0)
			return;

		int maxSum = nums[0];
		int startIndex = 0;
		int endIndex = 0;

		int currSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currSum = currSum + nums[i];

			if (currSum > maxSum) {
				maxSum = currSum;
			}
			for (int j = i + 1; j < nums.length; j++) {
				currSum = currSum + nums[j];
				if (currSum > maxSum) {
					maxSum = currSum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
	}

	/*
	 * Solution 2 : Kadane's algorithm
	 */
	public static void subArrayMaxSumFast(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int maxSum = nums[0];

		int startIndex = 0;
		int endIndex = 0;

		int currSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currSum = currSum + nums[i];

			if (currSum < nums[i]) {
				currSum = nums[i];
				startIndex = i;
			}

			if (currSum > maxSum) {
				maxSum = currSum;
				endIndex = i;
			}
		}
		System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		subArrayMaxSumSlow(nums);
		subArrayMaxSumFast(nums);
	}
}
