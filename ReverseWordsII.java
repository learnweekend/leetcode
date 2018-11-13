import java.util.Arrays;
/**
 * Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 

    A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces.
    The words are always separated by a single space.

Follow up: Could you do it in-place without allocating extra space?

 *
 */
public class ReverseWordsII {

	public static void main(String[] args) {
		char[] arr = "the sky is blue".toCharArray();
		System.out.println(Arrays.toString(arr));
		reverseWords(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reverseWords(char[] arr) {
		int start = 0;
		int end = arr.length - 1;
		reverse(arr, start, end);
		int curr = 0;
		
		while(start <= end && curr <= end) {
			if(arr[curr] == ' ') {
				reverse(arr, start, curr - 1);
				start = curr + 1;
			}
			curr++;
		}
		reverse(arr, start, end);
	}
	
	public static void reverse(char[] arr, int start, int end) {
		while(start <= end)
			swap(arr, start++, end--);
	}
	
	public static void swap(char[] ch, int start, int end) {
		char temp = ch[start];
		ch[start] = ch[end];
		ch[end] = temp;
	}
	
	

}
