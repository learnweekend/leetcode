import java.util.Stack;

/*
 * https://leetcode.com/problems/min-stack/description/
 * 
 * https://leetcode.com/problems/min-stack/discuss/49078/Simple-Java-solution-12-line
 */
public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty())
			minStack.push(x);

		else if (x <= minStack.peek())
			minStack.push(x);
	}

	public void pop() {
		if (stack.pop().equals(minStack.peek()))
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // --> Returns -3.
		minStack.pop();
		System.out.println(minStack.top()); // --> Returns 0.
		System.out.println(minStack.getMin()); // --> Returns -2.
	}
}
