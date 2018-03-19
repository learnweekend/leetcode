/**
 * https://leetcode.com/problems/valid-perfect-square/description/ Given a positive integer num,
 * write a function which returns True if num is a perfect square else False.
 */
public class PerfectSquare {
	/**
	 * 1. Use binary search and calculate the mid. 2. if mid * mid = number then return true, else false
	 * Runtime : O(log n), space : O(1)
	 */
	public static boolean isPerfectSquare(int number) {
		if (number < 0)
			return false;
		if (number == 1)
			return true;

		int low = 2;
		int end = number / 2;

		while (low <= end) {
			int mid = low + ((end - low) >>> 1); // Note mid is of type long to avoid overflow (mid * mid)
			if (number / mid == mid && number % mid == 0)
				return true;
			if (number / mid >= mid)
				low = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}
	/**
	 * Solution 2 : Recursive BinarySearch
	 * 1. Use binary search and calculate the mid. 
	 * 2. if(number / mid == mid && number % mid == 0) then return true
	 * Runtime : O(log n), space : O(log n)
	 */
	public static boolean isPerfectSquareV2(int number) {
		if (number < 0)
			return false;
		if (number == 1)
			return true;
		
		return isPerfectSquareV2(number, 2, number/2);
	}
	
	public static boolean isPerfectSquareV2(int number, int low, int end) {
		while (low <= end) {
			int mid = low + ((end - low) >>> 1); 
			if (number / mid == mid && number % mid == 0)
				return true;
			if ( number / mid >= mid)
				return isPerfectSquareV2(number, mid + 1, end);
			else
				return isPerfectSquareV2(number, low, mid - 1);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(8));
		System.out.println(isPerfectSquare(9));
		System.out.println(isPerfectSquare(16));
		System.out.println(isPerfectSquare(21));
		System.out.println("Recursive Solution");
		System.out.println(isPerfectSquareV2(8));
		System.out.println(isPerfectSquareV2(9));
		System.out.println(isPerfectSquareV2(16));
		System.out.println(isPerfectSquareV2(21));
	}
}
