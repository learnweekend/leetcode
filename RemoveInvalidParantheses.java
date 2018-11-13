
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParantheses {
	
	private int minimumRemoved = Integer.MAX_VALUE;
	private Set<String> validExpressions = new HashSet<String>();
	

	public static void main(String[] args) {
		String s = "()())()";
		RemoveInvalidParantheses obj = new RemoveInvalidParantheses();
		System.out.println(obj.removeInvalidParentheses(s));
	}

	private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removedCount) {
		if (index == s.length()) {
			if (leftCount == rightCount) {
				if (removedCount <= minimumRemoved) {
					String possibleAnswer = expression.toString();
					if (removedCount < minimumRemoved) {
						validExpressions.clear();
						minimumRemoved = removedCount;
					}
					validExpressions.add(possibleAnswer);
				}
			}
		} else {
			char currentCharacter = s.charAt(index);
			int length = expression.length();
			recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
			expression.append(currentCharacter);
			if (currentCharacter == '(') {
				recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
			} else if (rightCount < leftCount) {
				recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
			}
			expression.deleteCharAt(length);
		}
	}

	public List<String> removeInvalidParentheses(String s) {
		recurse(s, 0, 0, 0, new StringBuilder(), 0);
		return new ArrayList(validExpressions);
	}
}