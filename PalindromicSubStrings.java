
public class PalindromicSubStrings {

	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(countSubstrings(s));
	}

	public static int countSubstrings(String S) {
		int N = S.length(), ans = 0;
		for (int center = 0; center <= 2 * N - 1; ++center) {
			int left = center / 2;
			int right = left + center % 2;
			
			while (left >= 0 && right < N ) {
				ans++;
				left--;
				right++;
			}
		}
		return ans;
	}

}
