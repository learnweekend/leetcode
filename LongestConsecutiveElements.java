
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements
 * sequence. Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive elements sequence is
 * [1, 2, 3, 4]. Therefore its length is 4
 *
 */
public class LongestConsecutiveElements {

	public static void main(String[] args) {
		//int[] arr = { 100, 4, 200, 1, 3, 2 };
		int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
		System.out.println(longestConsecutiveV1(arr));
		System.out.println(longestConsecutiveV2(arr));
		System.out.println(longestConsecutiveSortingV2(arr));
	}
	/**
	 * Solution : 1. Sort the array
	 * 2. Loop through the array and compare next elements
	 * 3. Have a counter and get the maximum count
	 * 
	 * Runtime : O(N Log N).
	 * Space   : O(1)
	 */
	public static int longestConsecutiveSortingV2(int[] numbers) {
		if (numbers == null || numbers.length == 0)
			return 0;
		
		Arrays.sort(numbers);  // O(n log n)
		int maxSeq = 0;
		int currSeq = 1;
		
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i] != numbers[i - 1]) {  // make sure to handle the duplicate elements after sorting
				if(numbers[i] == numbers[i - 1] + 1) {
					currSeq++;  // increment the currSequence
				} else {
					maxSeq = Math.max(maxSeq, currSeq);  // get the max sequence
					currSeq = 1;  // reset currSequence
				}
			} 
		} 
		maxSeq = Math.max(maxSeq, currSeq);  // get the max sequence
		return maxSeq;
	}

	/**
	 * Solution : 
	 * 1. Insert elements into the HashSet - to avoid duplicates and faster lookup
	 * Runtime : O(N);
	 * Space   : O(N)
	 */
	public static int longestConsecutiveV1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		Set<Integer> valueSet = new HashSet<>();
		
		for (int i : nums) 
			valueSet.add(i);
		
		int max = 0;
		
		for (int value : nums) {
			int left = value - 1;
			int right = value + 1;
			
			int length = 1;
			
			while (valueSet.contains(left)) {
				length++;
				valueSet.remove(left);
				left--;
			}
			while (valueSet.contains(right)) {
				length++;
				valueSet.remove(right);
				right++;
			}
			max = Math.max(max, length);
		}
		return max;
	}

	/**
	 * Solution : 
	 * 1. Insert elements into the HashSet - to avoid duplicates and faster searching
	 * Runtime : O(N);
	 * Space   : O(N)
	 */
	public static int longestConsecutiveV2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		Set<Integer> valueSet = new HashSet<>();
		for (int i : nums) {
			valueSet.add(i);
		}
		int maxSequence = 0;

		for (int value : valueSet) {
			if (valueSet.contains(value- 1))
				continue;
			
			int currSequence = 0;
			while (valueSet.contains(value++))
				currSequence ++;

			maxSequence = Math.max(maxSequence, currSequence);
		}
		return maxSequence;
	}

}
