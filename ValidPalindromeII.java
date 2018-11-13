/**
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {

	public static void main(String[] args) {
		String s1 = "aba";
		String s2 = "abca";
		System.out.println(validPalindrome(s1));
		System.out.println(validPalindrome(s2));
	}

	/**
	 * Suppose we want to know whether s[i], s[i+1], ..., s[j] form a palindrome. 
	 * If i >= j then we are done. If s[i] == s[j] then we may take i++; j--. 
	 * Otherwise, the palindrome  must be either s[i+1], s[i+2], ..., s[j] or 
	 * s[i], s[i+1], ..., s[j-1], and we should check both cases.
	 */
	public static boolean validPalindrome(String s) {
		if (s.isEmpty())
			return true;
		int start = 0;
		int end = s.length() - 1;
		
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return validPalindrome(s, start, end - 1) || validPalindrome(s, start + 1, end);
			}
			start++;
			end--;
		}
		return true;
	}

	private static boolean validPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
