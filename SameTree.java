/**
 * Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:
Input:     1         1
          /           \
 output : false
 */
public class SameTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(6);
		
		System.out.println(isSameTree(root, root2));
	}
	
	public static boolean isSameTree(TreeNode node1, TreeNode node2) {
		
		if(node1 == null && node2 == null)
			return true;
		
		if(node1 == null)
			return false;
		
		if(node2 == null)
			return false;
		
		if(node1.val != node2.val)
			return false;
		
		return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
	}
	
	public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
