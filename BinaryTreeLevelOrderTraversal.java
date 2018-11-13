import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 *
 */

public class BinaryTreeLevelOrderTraversal {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>(); // result
		if (root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();  // get the size at each level
			List<Integer> list = new LinkedList<>();  // to store node in a level
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.add(node.left);  // add left child if present
				if (node.right != null)
					queue.add(node.right);  // add right child if present

				list.add(node.val);
				size--;
			}
			result.add(list);
		}
		return result;
	}

	private static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelOrder(root));
	}

}
