import java.util.HashSet;
import java.util.Set;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * description/ Given a string, find the length of the longest substring without
 * repeating characters. Examples: Given "abcabcbb", the answer is "abc", with
 * the length is 3. Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubStringWithoutRepeating {
	/**
	 * Brute force solution :  Get all the substring and check if all the substring have unique characters.
	 * Runtime : O(N ^ 3), Space : O(N)
	 */
	public static int lengthOfLongestSubstringV1(String s) {
		int N = s.length();
		int max = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j <= N; j++)
				if (isUnique(s, i, j))
					max = Math.max(max, j - i);
		return max;
	}
	
	public static boolean isUnique(String s, int start, int end) {
      Set<Character> set = new HashSet<>();
      for (int i = start; i < end; i++) {
          char ch = s.charAt(i);
          if (set.contains(ch)) 
         	 return false;
          set.add(ch);
      }
      return true;
  } 
	/** Solution : 1. have two pointers from beginning
	 * 2. move one pointer forward for each character and insert in SET
	 * 3. if the character is present then update the max and remove one character from the start
	 * 4. Repeat this process until the end of the string.
	 * Runtime : O(N), Space : O(N);
	 */
	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int curr = 0;
		int max = 0;
		int end = s.length() - 1;
		
		Set<Character> set = new HashSet<>();
		while (curr <= end) {
			if (!set.contains(s.charAt(curr))) {
				set.add(s.charAt(curr++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(start++));  // remove one element from start when duplicate found
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringV1("abcabcbb"));
		System.out.println(lengthOfLongestSubstringV1("bbbbbb"));
		System.out.println(lengthOfLongestSubstringV1("pwwwkew"));
	}
}
