
/** https://leetcode.com/problems/palindromic-substrings/description/
 * 
 * Given a string, your task is to count how many palindromic substrings in this string.
 * 
 * The substrings with different start indexes or end indexes are counted as different substrings
 * even they consist of same characters.
 * 
 * Example 1:
 * 
 * Input: "abc" Output: 3 Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * 
 * Input: "aaa" Output: 6 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubStrings {

	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int even = countSubstrings(s, i, i);
			int odd = countSubstrings(s, i, i + 1);
			count += (even + odd);
		}
		return count;
	}

	private static int countSubstrings(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}
}
