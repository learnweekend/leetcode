public class WildcardMatch {

	public static void main(String[] args) {
		
	}

	/**
	 * Recursive Solution
	 * 1. Check if pattern is empty - base case
	 * 2. check if text is empty - base case
	 * 3. check if pattern has only one char that is * - true  // base case
	 * 4. Check for first character match and for wild cards(? and *)
	 * 5. 
	 */
	public static boolean isMatch(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();

		if (s.isEmpty()) { 
			for(int i = 0; i < p.length(); i++) {  
				if(p.charAt(i) != '*')
					return false;
			}
			return true;  // if all are *s
		}
		if (p.length() == 1 && p.charAt(0) == '*')
			return true;

		boolean firstMatch = !s.isEmpty() && 
				(p.charAt(0) == s.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*');

		if (p.charAt(0) == '*' && p.length() >= 2) {
			return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
		}
		else 
			return firstMatch && isMatch(s.substring(1), p.substring(1));
	}
	
	public boolean isMatchDP(String s, String p) {
		char[] text = s.toCharArray();
		char[] pattern = repalceContinousStarsWithSingleStar(p);
		return isMatchDP(text, pattern);
	}

	public static boolean isMatchDP(char[] text, char[] pattern) {
		boolean cache[][] = new boolean[text.length + 1][pattern.length + 1];
		
		cache[0][0] = true;  // empty string and empty pattern always match
		
		if (pattern.length > 0 && pattern[0] == '*') {  // if patterns starts with *
			cache[0][1] = true;
		}
		
		for (int i = 1; i < cache.length; i++) {
			for (int j = 1; j < cache[0].length; j++) {
				if (pattern[j - 1] == '?' || text[i - 1] == pattern[j - 1]) {
					cache[i][j] = cache[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					cache[i][j] = cache[i - 1][j] || cache[i][j - 1];
				}
			}
		}
		return cache[text.length][pattern.length];
	}

	public char[] repalceContinousStarsWithSingleStar(String p) {
		String result = "";
		char[] pattern = p.toCharArray();
		int index = 0;
		boolean isFirst = true;
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[index++] = pattern[i];
					result += pattern[i];
					isFirst = false;
				}
			} else {
				pattern[index++] = pattern[i];
				result += pattern[i];
				isFirst = true;
			}
		}
		return result.toCharArray();
	}
}
