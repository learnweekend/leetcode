import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;
	private TreeNode root;

	public BSTIterator(TreeNode root) {
		this.root = root;
		this.stack = new Stack<>();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return root != null;
	}

	/** @return the next smallest number */
	public int next() {
		int val = 0;
		if (hasNext()) {
			if (stack.isEmpty()) {  // only push when the stack is empty
				pushNodeAndLeft(root, stack);
			}
			TreeNode node = stack.pop();
			val = node.val;
			if (node.right != null) {
				pushNodeAndLeft(node.right, stack);
			}
			if (stack.isEmpty())  // if the stack is empty, hasNext() -- > false
				root = null;   // make root null
		}
		return val;
	}

	public static void pushNodeAndLeft(TreeNode node, Stack<TreeNode> stack) {
		TreeNode curr = node;
		while (curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
	}

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
	}
}
