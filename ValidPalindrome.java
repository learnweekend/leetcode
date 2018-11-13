public class ValidPalindrome {
	/**
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false
	 */

	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama".toLowerCase();
		String s2 = "race a car".toLowerCase();
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome(s2));
	}

	public static boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;
		s = s.toLowerCase();

		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {
			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
				continue;
			}
			if (s.charAt(start) != s.charAt(end))
				return false;

			start++;
			end--;
		}
		return true;
	}
}
