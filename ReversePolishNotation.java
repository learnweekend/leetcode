* https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * 
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 	 Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	 Some examples:
  	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens = { "3", "-4", "+" };
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;

		Set<String> operators = new HashSet<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");

		Stack<Integer> valStack = new Stack<Integer>();

		for (String s : tokens) {
			if (!operators.contains(s)) {
				valStack.push(Integer.valueOf(s));
			} else {
				int val1 = valStack.pop();
				int val2 = valStack.pop();
				valStack.push(applyOperation(val2, s, val1));
			}
		}
		return valStack.pop();
	}

	private static int applyOperation(int val2, String operator, int val1) {
		if (operator == "+")
			return val2 + val1;
		if (operator == "-")
			return val2 - val1;
		if (operator == "*")
			return val1 * val2;
		if (operator == "/") {
			if(val1 == 0) return 0;
			else
				return val2 / val1;
		}
		return 0;
	}
}
