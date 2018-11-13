
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeTreeBFS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(serialize(root));
		System.out.println(deserialize(serialize(root)).left.val);
	}

	public static String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
  }
	/**
	 * Serialize - BFS - Level order Traversal
	 */
	private static void serialize(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root); 
		sb.append(Integer.valueOf(root.val) + ",");   // serialize root node first
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left == null) {
				sb.append("null,");
			} else {
				queue.offer(node.left);
				sb.append(Integer.valueOf(node.left.val) + ",");
			}
			if (node.right == null) {
				sb.append("null,");
			} else {
				queue.offer(node.right);
				sb.append(Integer.valueOf(node.right.val) + ",");
			}
		}
	}

  public static TreeNode deserialize(String data) {
      if (data == null || data.length() == 0 )
			return null;
		List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserialize(nodes);
  }
  
  public static TreeNode deserialize(List<String> list) {
      if (list.get(0).equals("null")) {  // if root is null
			list.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty() && list.size() > 0) {
			TreeNode node = queue.poll();
			if(list.get(0).equals("null")) {
				node.left = null;
				list.remove(0);
			} else {
				node.left = new TreeNode(Integer.valueOf(list.get(0)));
				list.remove(0);
				queue.offer(node.left);
			}
			if(list.get(0).equals("null")) {
				node.right = null;
				list.remove(0);
			} else {
				node.right = new TreeNode(Integer.valueOf(list.get(0)));
				list.remove(0);
				queue.offer(node.right);
			}
		}
		return root;
  }

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

}
