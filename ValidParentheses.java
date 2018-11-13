import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

	Note that an empty string is also considered valid.
 *
 */
public class ValidParentheses {
	
	 public static boolean isValid(String s) {
       if(s.isEmpty())
      	 	return true;
       Map<Character, Character> map = new HashMap<>();
       	map.put('(', ')');
       	map.put('[', ']');
       	map.put('{', '}');
       
       Stack<Character> stack  = new Stack<>();
       for(int i = 0; i < s.length(); i++) {
      	 	char ch = s.charAt(i);
      	 	if(map.containsKey(ch)) {
      	 		stack.push(ch);
      	 	} else {
      	 		if(!stack.empty()) {
      	 			char c = stack.pop();
      	 			if(map.get(c) != ch)
      	 				return false;
      	 		} else {
      	 			return false;
      	 		}
      	 	}
       }
       return stack.isEmpty();
    }

	public static void main(String[] args) {
		String s = "({})[]";
		System.out.println(isValid(s));
	}
}
