public class ReadNCharactersGivenRead4II {

	//Interval buffer to store data between calls
	private char[] buf4 = new char[4];
	// Interval buffer pointer
	private int i4 = 0;
	// Interval buffer size
	private int n4 = 0;

	// Populating data to external buffer form interval buffer.
	// If interval buffer runs out of data, then populate it first.
	public int read(char[] buf, int n) {
		
		int i = 0;  // Pointer to external buffer

		while (i < n) {
			// Interval buffer runs out of data, so trigger a new read4 call
			if (i4 >= n4) {
				i4 = 0; // Reset interval buffer's pointer to the beginning
				n4 = read4(buf4);
				if (n4 == 0)
					break; // No more data, break
			}
			buf[i++] = buf4[i4++];
		}
		return i;
	}

	public static int read4(char[] buf) {
		return 0;
	}

}
