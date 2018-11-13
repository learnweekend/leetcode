import java.util.*;

public class PrintTree {
		public static void main(String[] args){
	    TreeNode root = new TreeNode(4);
	    root.left = new TreeNode(5);
	    root.left.left = new TreeNode(7);
	    root.left.right = new TreeNode(8);
	    root.right = new TreeNode(3);
	    root.right.left = new TreeNode(2);
	    root.right.right = new TreeNode(6);

	    PrintTree.print(root);
	    System.out.println();
	  }

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.val = value;
		}
	}

	public static void print(TreeNode root) {
		int maxLevel = maxLevel(root);
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}
	private static void printNodeInternal(List<TreeNode> nodes, int level,int maxLevel) {
		if (nodes.isEmpty() || isAllElementsNull(nodes)) return;
		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
		printWhitespaces(firstSpaces);
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (TreeNode TreeNode : nodes) {
			if (TreeNode != null) {
				System.out.print(TreeNode.val);
				newNodes.add(TreeNode.left);
				newNodes.add(TreeNode.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			printWhitespaces(betweenSpaces);
		}
		System.out.println("");
		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}
				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					printWhitespaces(1);
				printWhitespaces(i + i - 1);
				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					printWhitespaces(1);
				printWhitespaces(endgeLines + endgeLines - i);
			}
			System.out.println("");
		}
		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}
	private static int maxLevel(TreeNode TreeNode) {
		if (TreeNode == null) return 0;
		return Math.max(maxLevel(TreeNode.left), maxLevel(TreeNode.right)) + 1;
	}
	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}
		return true;
	}
}