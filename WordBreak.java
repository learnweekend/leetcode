
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/articles/word-break/#
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		List<String> dict = new ArrayList<>();
		//dict.add("leet");
		//dict.add("code");
		//String s = "leetcode";
		
		dict.add("apple");
		dict.add("pen");
		String s = "applepenapple";
		
		System.out.println(wordBreak(s, dict));
	}

	/**
	 * brute force using recursion.
	 * runtime : o(n ^  n)
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dictionary = new HashSet<String>(wordDict);
		return wordBreak(s, dictionary, 0);
	}

	public static boolean wordBreak(String s, Set<String> dict, int start) {
		if (start == s.length())
			return true;

		for (int end = start + 1; end <= s.length(); end++) {
			if (dict.contains(s.substring(start, end)) && wordBreak(s, dict, end))
				return true;
		}
		return false;
	}
	
	/**
	 * recursion with memoization/DP
	 * runtime : o(n ^  n)
	 */

}
