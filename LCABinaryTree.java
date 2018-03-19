import java.util.Stack;

/* 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LCABinaryTree {

	/**
	 * Solution : Return the pointer back to parent as the nodes found.
	 * 1. Check the root element, if it matches with any of the nodes then root is the LCA 2.
	 * Recursively move towards left and right. 3. if both left and right are present then root is the
	 * LCA 4. if left == null then return right 5. right == null then return left
	 * Runtime : O(N)
	 */
	public static TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		// 1. check if any of the nodes are equal to "root"
		if (root.equals(p) || root.equals(q)) {  // Note : use equals method. This will take care if tree has duplicate values.
			return root;
		}
		TreeNode left = lowestCommonAncestorV1(root.left, p, q); // check on left
		TreeNode right = lowestCommonAncestorV1(root.right, p, q); // check on right

		// 3. if both are present, then root is the LCA
		if (left != null && right != null)
			return root;

		if (left == null)   // if left is null then right is the LCA.
			return right;

		return left;
	}

	/**
	 *  Solution : 
	 *  1. Find the path of Node1 from root and store in stack.
	 *  2. Find the path of Node2 from root and store in the stack.
	 *  3. Compare the two paths and return the node where two paths diverge.
	 *  Runtime : O(N), Space : O(H);
	 */
	public static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
		if (p.equals(q))
			return p;
		
		Stack<TreeNode> path1 = path(root, p);
		Stack<TreeNode> path2 = path(root, q);
		
		if (path1 == null || path2 == null)
			return null;
		
		TreeNode lca = null;
		
		while (!path1.isEmpty() && !path2.isEmpty()) {
			TreeNode p1 = path1.pop();
			TreeNode p2 = path2.pop();

			if (p1.equals(p2)) 
				lca = p1;         // update the last LCA node
			else
				break;  // break when the paths diverge.
		}
		return lca;
	}

		/**
		 *  Get the path from root to a given node (stored in stack).
		 */
	public static Stack<TreeNode> path(TreeNode root, TreeNode x) {
		if (root == null)
			return null;
		
		if (root.equals(x)) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			return stack;
		}
		Stack<TreeNode> left = path(root.left, x);
		Stack<TreeNode> right = path(root.right, x);

		if (left != null) {
			left.push(root);
			return left;
		}
		if (right != null) {
			right.push(root);
			return right;
		}
		return null;
	}

	private static class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(6);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(11);
		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(5);
		root.right.right = new TreeNode(13);
		root.right.right.left = new TreeNode(7);

		System.out.println(lowestCommonAncestorV1(root, root.left.left, root.left.right.right).data);
		System.out.println(lowestCommonAncestorV2(root, root.left.left, root.left.right.right).data);
	}
}
