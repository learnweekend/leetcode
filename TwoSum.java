import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] arr = new int[] {2, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(twoSumV1(arr, target)));
		System.out.println(Arrays.toString(twoSumV2(arr, target)));
	}
	
	/**
	 * brute force solution, using 2 nested for loops
	 * Runtime : O(N^2);
	 * Space   : O (1)
	 */
	public static int[] twoSumV1(int[] arr, int target) {
		int[] indices = null;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == target) {
					indices = new int[] {i, j};
					break;
				}
			}
		}
		return indices;
	}
	/**
	 * solution : using Map
	 * Runtime  : O(N)
	 * Space    : O(N)
	 */
	public static int[] twoSumV2(int[] arr, int target) {
		int[] indices = null;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(target - arr[i]) && map.get(target - arr[i]) != i) {
				indices = new int[] {map.get(target - arr[i]), i};
			} else {
				map.put(arr[i], i);
			}
		}
		return indices;
	}
}
