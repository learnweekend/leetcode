/**
 * https://www.interviewbit.com/problems/ways-to-decode/
 * 
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

	Given an encoded message containing digits, determine the total number of ways to decode it.

	Example :

	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

	The number of ways decoding "12" is 2.
 *
 */
public class WaysToDecode {

	public static void main(String[] args) {
		String encoded_msg = "121263";
		System.out.println(numDecodingsRecursive(encoded_msg));
		System.out.println(numDecodingsDP(encoded_msg));
	}
	
	/** 
	 * 
	 */
	public static int numDecodingsRecursive(String msg) {

		if (msg == null)
			return 0;

		int N = msg.length();

		if (N > 0 && msg.charAt(0) == '0')
			return 0;

		if (N == 0 || N == 1)
			return 1;

		int count = 0;

		if (msg.charAt(N - 1) > '0')
			count = numDecodingsRecursive(msg.substring(0, N - 1));

		if (msg.charAt(N - 2) == '1' || (msg.charAt(N - 2) == '2' && msg.charAt(N - 1) < '7'))
			count = count + numDecodingsRecursive(msg.substring(0, N - 2));

		return count;
	}

	public static int numDecodingsDP(String msg) {
      if(msg.charAt(0) == '0')
          return 0;
      
      int N = msg.length();
      int[] cache = new int[N + 1];

      cache[0] = 1; // empty string considered as one decoding
      cache[1] = 1; // the first non 0 string considered as one decoding

      for (int i = 2; i <= N; i++) {
          
          if (msg.charAt(i - 1) > '0')
              cache[i] = cache[i - 1];
          
          if (msg.charAt(i - 2) == '1' || (msg.charAt(i - 2) == '2' && msg.charAt(i - 1) < '7'))
              cache[i] += cache[i - 2];
      }
      return cache[N];
  }

}
