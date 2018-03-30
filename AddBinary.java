/**
 * https://leetcode.com/problems/add-binary/description/
 * Given two binary strings, return their sum (also a binary string).
	For example,
	a = "11"
	b = "1"
	Return "100"
 */
public class AddBinary {

	public static String addBinary(String s, String t) {
		if (s.isEmpty())
			return t;
		if (t.isEmpty())
			return s;
		int carry = 0;
		int sIndex = s.length() - 1; // iterate from end
		int tIndex = t.length() - 1;
		StringBuilder sb = new StringBuilder();  // to store the result
		int sumOfBits = 0;  // to store the two bits sum.
		int sValue = 0; // get the numeric value of bit
		int tValue = 0;

		while (sIndex >= 0 || tIndex >= 0) {
			sValue = sIndex >= 0 ? Character.getNumericValue(s.charAt(sIndex--))	: 0;
			tValue = tIndex >= 0 ? Character.getNumericValue(t.charAt(tIndex--))	: 0;
			sumOfBits = sValue ^ tValue ^ carry;  //(sValue + tValue + carry) %2;
			sb.append(sumOfBits);
			carry = sValue + tValue + carry >= 2 ? 1 : 0;
		}
		if (carry == 1)   // after last bits sum..if carry is 1 then add to the result
			sb.append(carry);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}
