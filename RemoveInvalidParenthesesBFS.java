
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
*/
public class RemoveInvalidParenthesesBFS {

	public static void main(String[] args) {
		String s = "(((((((((";
		System.out.println(removeInvalidParentheses(s));
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			result.add("");
			return result;
		}
		removeInvalidParentheses(s, result);
		return result;
	}

	public static void removeInvalidParentheses(String expression, List<String> result) {
		Set<String> visitedSet = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(expression);
		visitedSet.add(expression); // mark as visited

		boolean valid = false;
		
		while (!queue.isEmpty()) {
			String currExpr = queue.poll();
			if (isValid(currExpr)) {
				result.add(currExpr);
				valid = true;
			}
			if (valid) { //once we find a valid expr.(of certain length) this reduces further any removals
				continue;  // limit number os string to process
			}

			for (int i = 0; i < currExpr.length(); i++) {
				if (currExpr.charAt(i) != '(' && currExpr.charAt(i) != ')') {
					continue; // ignore non parentheses characters
				}
				// remove the current character and process the expression
				String nextExpr = currExpr.substring(0, i) + currExpr.substring(i + 1);
				System.out.println(nextExpr);
				if (!visitedSet.contains(nextExpr)) {
					queue.offer(nextExpr);
					visitedSet.add(nextExpr); // mark as visited
				}
			}
		}
	}

	public static boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(')
				count++;
			else if (ch == ')')
				count--;
			if (count < 0)
				return false;
		}
		return count == 0;
	}
}
