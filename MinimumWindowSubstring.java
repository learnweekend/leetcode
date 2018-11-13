
public class MinimumWindowSubstring {

	public static String minWindow(String S, String T) {
		int min = -1;
		int idx = -1;

		char[] text = S.toCharArray();

		char[] pattern = T.toCharArray();

		for (int i = 0; i < text.length; i++) {

			if (text[i] != pattern[0])
				continue;

			int len = check(pattern, text, i);

			if (len <= 0)
				break;

			if (min == -1 || len < min) {
				idx = i;
				min = len;
			}
		}
		if (min == -1)
			return "";

		return S.substring(idx, idx + min);
	}

	public static int check(char[] pattern, char[] text, int start) {
		int tIndex = start;
		int pIndex = 0;

		while (tIndex < text.length && pIndex < pattern.length) {
			if (text[tIndex] == pattern[pIndex])
				pIndex++;
			tIndex++;
		}
		if (pIndex == pattern.length)
			return tIndex - start;

		return -1;
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String p = "ABC";
		System.out.println(minWindow(s, p));
	}

}
