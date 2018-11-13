/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * 
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string. 
 */

public class ReverseWordsIII {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s.trim().toCharArray()));
	}
	
	/**
	 *  1. convert the input String to char array.
	 *  2. Loop through the array and reverse each word when encounter white space
	 *  Runtime : O(N);
	 *  Space : O(1);
	 */
	public static String reverseWords(char[] str) {
		int start = 0;
		int end = str.length - 1;
		int curr = 0;
		while(start <= end && curr <= end) {
			if(str[curr] == ' ') {
				reverse(str, start, curr - 1);
				start = curr + 1;
			}
			curr++;
		}
		reverse(str, start, end);
		return new String(str);
	}
	
	public static void reverse(char[] words, int start, int end) {
		while( start <= end) 
			swap(words, start++, end--);
	}
	
	public static void swap(char[] words, int start, int end) {
		char temp = words[start];
		words[start] = words[end];
		words[end] = temp;
	}

}
