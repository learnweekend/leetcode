
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class PhoneKeyCombinations {
	
	private static Map<Integer, char[]> keyMap = null;

	static {
		keyMap = new HashMap<>();
		keyMap.put(2, new char[] { 'a', 'b', 'c' });
		keyMap.put(3, new char[] { 'd', 'e', 'f' });
		keyMap.put(4, new char[] { 'g', 'h', 'i' });
		keyMap.put(5, new char[] { 'j', 'k', 'l' });
		keyMap.put(6, new char[] { 'm', 'n', 'o' });
		keyMap.put(7, new char[] { 'p', 'q', 'r', 's' });
		keyMap.put(8, new char[] { 't', 'u', 'v' });
		keyMap.put(9, new char[] { 'w', 'x', 'y', 'z' });
	};
	
	/**
	 * Solution :  Use recursive approach
	 *  1. Have extra buffer equal to length of input to store the letter combinations
	 *  2. Define the base case = when the bufferIndex == buffer.length
	 *  3. place item into buffer
	 *  4. recursive for next index
	 *  Runtime : O(4 ^ N) when N = number of digits
	 *  Space   : O(N);
	 */
	public static List<String> letterCombosV1(String digits) {
		List<String> combos = new ArrayList<>();
      if(digits == null || digits.length() == 0)
          return combos;
      int[] arr = new int[digits.length()];
		for(int i = 0; i < digits.length(); i++) {
			arr[i] = Integer.valueOf(digits.charAt(i) - '0');
		}
      char[] buffer = new char[digits.length()];
      letterCombosV1(combos, arr, 0, buffer, 0);
      return combos;
	}
	
	private static void letterCombosV1(
			List<String> result,   // to store the result
			int[] digits,   // input phone number
			int startIndex,  // startIndex of phone number
			char[] buffer,   // buffer to letter of input length
			int bufferIndex) {  // buffer index
		
		if(bufferIndex == buffer.length || startIndex == digits.length) {
			result.add(new String(buffer));
			return;
		}
		char[] letters = getLetters(digits[startIndex]);
		
		for(char letter : letters) {
			buffer[bufferIndex] = letter;
			letterCombosV1(result, digits, startIndex + 1, buffer, bufferIndex + 1);
		}
	}

	/**
	 * Solution : Use recursive approach
	 *  1. Have a digit and char mappings
	 *  2. Add first digit letter mappings to initial list which will append to next digit.
	 *  3. call helper method and start at 2nd digit.
	 *  4. Take temporary buffer to store the letter combinations
	 *  
	 *  Runtime : O(4 ^ N) when N = number of digits
	 *  Space : O(N);
	 */
	public static List<String> letterCombinationsV2(String digits) {
		if(digits == null || digits.length() == 0)
	      return Collections.emptyList();
	    
	    List<String> result = new ArrayList<>();
	    for(char ch : getDigitCharMapping(digits.charAt(0)))
	      result.add(ch+"");  // add first digit mappings
	     
	    return letterCombinationsRecursive(result, digits, 1); // index starts on 2nd digit.
	}

	private static List<String> letterCombinationsRecursive(List<String> buffer, String digits, int index) {
		if (index == digits.length())  // base case when all digits are processed
			return buffer;
		
		List<String> res = new ArrayList<>(); // temporary buffer
		for (String s : buffer) {
			for (char c : getDigitCharMapping(digits.charAt(index))) {
				res.add(s + c); 
			}
		}
		return letterCombinationsRecursive(res, digits, index + 1);  // recursive call with next digit
	}
	
	public static char[] getDigitCharMapping(char ch) {
		return keyMap.get(Integer.valueOf(ch - '0'));
	}
	
	public static char[] getLetters(int number) {
		return keyMap.get(number);
	}
	
	public static void main(String[] args) {
		String digits = "2345";
		System.out.println(letterCombosV1(digits));
		System.out.println(letterCombinationsV2(digits));
	}

}
