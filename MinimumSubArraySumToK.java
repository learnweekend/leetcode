
/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
public class MinimumSubArraySumToK {

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));  // Ans : 2
		System.out.println(minSubArrayLenFast(s, nums));  // Ans : 2
		
		int[] nums1 = {1,2,3,4,5};
		int s1 = 15;
		System.out.println(minSubArrayLen(s1, nums1));  // Ans : 5
		System.out.println(minSubArrayLenFast(s1, nums1));  // Ans : 5
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		int[] cumSum = new int[nums.length];  // cumulative sum array
		for(int i = 1; i < nums.length; i++) {
			cumSum[i] = cumSum[ i - 1] + nums[i];
		}
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				//get the sum of sub array from i... j elements
				int sum = cumSum[j] - cumSum[i] + nums[i];
				if (sum >= s) {
					min = Math.min(min, (j - i + 1));  // get the min
               break; // found sub array, move to next element
           }
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
   }
	
	/**
	 * Solution :  Take two pointers and maintain the sliding window.
	 * If the cumSum exceeds the target sum, then reduce the window and try to find the min sub array.
	 *  Update the cumSum when start is moved forward.
	 */
	public static int minSubArrayLenFast(int s, int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		int start = 0;   // startIndex of sliding window
		int cumSum = 0;
		
		for(int i = 0; i < nums.length; i++) {  // i -- is the end index of sliding window
			cumSum += nums[i];
			
			while(cumSum >= s) {
				min = Math.min(min,  i - start + 1);
				cumSum = cumSum - nums[start++];  // reducing the cumSum
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
   }
	

}
