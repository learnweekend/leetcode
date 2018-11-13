import java.util.Arrays;

class SolutionSlidingWindow {

	private static TreeNode root;
	
	public static void main(String[] args) {
		int[] arr = {7, 2, 4};
		int k = 2;
		System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
	}

	public static int[] maxSlidingWindow(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k == 1)
			return arr;
		if (arr.length == 2)
			return arr[0] > arr[1] ? new int[] { arr[0] } : new int[] { arr[1] };

		SolutionSlidingWindow obj = new SolutionSlidingWindow();
		int[] result = new int[arr.length - k + 1];
		if (k == 1)
			return arr;

		for (int i = 0; i < k; i++) {
			obj.insert(arr[i]);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = obj.max(); // add max
			// System.out.println(Arrays.toString(result));
			if (k + i < arr.length) {
				obj.insert(arr[k + i]);
				obj.delete(arr[i]);
			}
		}
		return result;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private static TreeNode insert(TreeNode node, int data) {
		if (node == null)
			return new TreeNode(data);
		if (data < node.data) {
			node.left = insert(node.left, data);
		} else if (data > node.data) {
			node.right = insert(node.right, data);
		} else {
			node.data = data;
		}
		return node;
	}

	public int min() {
		return min(root).data;
	}

	private TreeNode min(TreeNode x) {
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}

	public int max() {
		return max(root).data;
	}

	private TreeNode max(TreeNode x) {
		if (x.right == null)
			return x;
		else
			return max(x.right);
	}

	public static void deleteMin() {
		root = deleteMin(root);
	}

	public void delete(int data) {
		// System.out.println("deleted = " + data);
		root = delete(root, data);
	}

	private TreeNode delete(TreeNode node, int data) {
		if (node == null)
			return null;
		if (data < node.data) {
			node.left = delete(node.left, data);
		} else if (data > node.data) {
			node.right = delete(node.right, data);
		} else {
			if (node.right == null)
				return node.left;
			if (node.left == null)
				return node.right;

			TreeNode t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
		}
		return node;
	}

	private static TreeNode deleteMin(TreeNode node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		return node;
	}

	private static class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}
}
