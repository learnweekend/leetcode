/*
 * https://www.interviewbit.com/problems/reverse-the-string/
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * Given an input string, reverse the string word by word.

	Example:  

	Input: "the sky is blue",
	Output: "blue is sky the".

	Note:
    A word is defined as a sequence of non-space characters.
    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
    You need to reduce multiple spaces between two words to a single space in the reversed string.

	Follow up: For C programmers, try to solve it in-place in O(1) space.
 */

public class ReverseWords {

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWordsA(s.trim()));
		System.out.println(reverseWordsB(s.trim()));
	}

	/**
	 * Solution 1: This approach used java built in library to split space char (multiple spaces)
	 * Runtime : O(N) space : O(N)
	 */
	public static String reverseWordsA(String s) {
		if (s == null)
			return s;

		StringBuilder sb = new StringBuilder();
		String[] words = s.split("\\s+");

		int end = words.length;
		while (--end >= 0) {
			sb.append(words[end].trim());
			sb.append(" ");
		}
		return sb.toString().trim();
	}

	/**
	 * Solution 1: This approach uses char array. 
	 * 1. Reverse the whole string. 
	 * 2. Loop through the reversed string and reverse the each word.
	 * Runtime : O(N) 
	 * Space : O(1) ??
	 */
	public static String reverseWordsB(String s) {
		if (s == null)
			return s;

		return reverseWords(s.trim().toCharArray());
	}

	public static String reverseWords(char[] words) {
		int N = words.length;

		reverse(words, 0, N - 1); // reverse the whole string

		int start = 0;
		int i = 0;

		while (start < N && i < N) {
			if (words[i] == ' ') {
				reverse(words, start, i - 1); // reverse each word
				start = i + 1;
			}
			i++;
		}
		reverse(words, start, N - 1); // reverse the last word
		return new String(words).trim(); // trim for any white spaces
	}

	public static void reverse(char[] s, int i, int j) {
		while (i <= j)
			swap(s, i++, j--);
	}

	public static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

}
