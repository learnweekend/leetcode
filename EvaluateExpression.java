import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/evaluate-expression/
 * 
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

class EvaluateExpression {

	public static void main(String[] args) {
		String[] expression = { "2", "1", "+", "3", "*" };
		int result = eval(expression);
		System.out.println(result);
	}

	/**
	 * 1. Take Stack<Integer> for storing the integer values
	 * 2. push to stack when integer if found
	 * 3. pop() two times from stack when operator is found.
	 * 4. Apply the operator and push the result to stack.
	 * 5. continue above steps until of the expression.
	 * 6. pop the value from stack and return the result
	 * 
	 * Runtime : O(N);
	 * Space :O(N);
	 */
	
	public static int eval(String[] expr) {
		Stack<Integer> valStack = new Stack<>();
		for (String s : expr) {
			if (s.equals("-") || s.equals("+") || s.equals("*") || s.equals("/")) {
				int val1 = valStack.pop();
				int val2 = valStack.pop();
				valStack.push(findVal(val1, val2, s));
			} else {
				valStack.push(Integer.parseInt(s));
			}
		}
		return valStack.pop();
	}

	public static int findVal(int val1, int val2, String operator) {
		if (operator.equals("-"))
			return val2 - val1;
		else if (operator.equals("+"))
			return val1 + val2;
		else if (operator.equals("*"))
			return val1 * val2;
		else
			return val1 / val2;
	}

}
