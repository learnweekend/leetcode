
/**
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Example 1:
Input: buf = "abc", n = 4
Output: "abc"
Explanation: The actual number of characters read is 3, which is "abc".

Example 2:

Input: buf = "abcde", n = 5 
Output: "abcde"

Note:
The read function will only be called once for each test case.
 *
 */
public class ReadNCharactersGivenRead4 {

	public static int read4(char[] buf) {
		return 0;
	}

	public int read(char[] buf, int n) {
		int charsRead = 0;
		boolean isEOF = false;

		while (charsRead <= n && !isEOF) {
			char[] temp = new char[4];
			int read = read4(temp);
			if (read < 4) {
				isEOF = true;
			}
			for (int i = 0; i < read && charsRead < n; i++) {
				buf[charsRead] = temp[i];
				charsRead += 1;
			}
		}
		return charsRead;
	}

}
