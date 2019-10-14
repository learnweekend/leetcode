package leetcode;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

 */
public class HouseRobberII {
	
	public static int rob(int[] amounts) {
		if (amounts == null || amounts.length == 0)
			return 0;
		
		if(amounts.length == 1)
			return amounts[0];
		
		if(amounts.length == 2) {
			return Math.max(amounts[0], amounts[1]);
		}
		//Math.max(0... N-2, //1... N-1);
		return Math.max(robUtil(Arrays.copyOfRange(amounts, 0, amounts.length - 1)), robUtil(Arrays.copyOfRange(amounts, 1, amounts.length)));
	}

	public static int robUtil(int[] amounts) {
		if (amounts == null || amounts.length == 0)
			return 0;

		if (amounts.length == 1)
			return amounts[0];

		if (amounts.length == 2)
			return Math.max(amounts[0], amounts[1]);

		int[] cache = new int[amounts.length];
		cache[0] = amounts[0];
		cache[1] = Math.max(amounts[0], amounts[1]);

		for (int i = 2; i < amounts.length; i++) {
			cache[i] = Math.max(cache[i - 2] + amounts[i], cache[i - 1]);
		}
		return cache[amounts.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 2, 3, 2 })); // 3
		System.out.println(rob(new int[] { 1,2,3,1 })); // 4
	}
}
