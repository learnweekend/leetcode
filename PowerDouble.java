/**
 * Problem : Cacluate the Power for Double :
 * https://leetcode.com/problems/powx-n/description/
 */
public class PowerDouble {
	/**
	 * Solution 1 : brute-force runtime : o(N), space : O(1)
	 */
	private static double powV1(double x, int n) {
		if (n < 0)
			return 1 / x * powV1(1 / x, -n - 1); // when n is negative

		double result = 1;
		if (x == 0)
			return 0;
		if (n == 0)
			return 1;
		if (n == 1)
			return x;

		while (n-- > 0)
			result *= x;

		return result;
	}

	/**
	 * Solution 2 : efficient runtime : o(log n), space : O(1)
	 */
	private static double powV2(double x, int n) {
		if (n < 0)
			return 1 / x * powV2(1 / x, -(n + 1)); // when n is negative

		if (x == 0)
			return 0;
		if (n == 0)
			return 1;
		if (n == 1)
			return x;

		double temp = powV2(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else
			return x * temp * temp;
	}

	public static void main(String[] args) {
		System.out.println(powV1(2.10000, 3)); // 9.26100
		System.out.println(powV1(2.10000, 3)); // 9.26100
	}
}
