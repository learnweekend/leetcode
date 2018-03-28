import java.util.HashMap;
import java.util.Map;
/*
 * https://leetcode.com/problems/roman-to-integer/description/
 * Given a roman numeral, convert it to an integer.
  Input is guaranteed to be within the range from 1 to 3999.
 I - 1
 V - 5
 X - 10
 L - 50
 C - 100
 D - 500
 M - 1000
 */
public class RomanToInteger {

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int sum = 0;
		Map<Character, Integer> valueMap = new HashMap<>();
		valueMap.put('I', 1);
		valueMap.put('V', 5);
		valueMap.put('X', 10);
		valueMap.put('L', 50);
		valueMap.put('C', 100);
		valueMap.put('D', 500);
		valueMap.put('M', 1000);

		int prev = valueMap.get(s.charAt(0)); // this is to take care of special cases like IX = 9
		int next = 0;
		for (int i = 1; i < s.length(); i++) {
			next = valueMap.get(s.charAt(i));

			if (prev < next)
				sum = sum - prev;
			else
				sum = sum + prev;

			prev = next;
		}
		return sum + prev;
	}

	public static void main(String[] args) {
		RomanToInteger ri = new RomanToInteger();
		System.out.println("VX = " + ri.romanToInt("VX"));
		System.out.println("XVIX = " + ri.romanToInt("XVIX"));
		System.out.println("VXVIIIX = " + ri.romanToInt("VXVIIIX"));
	}
}
