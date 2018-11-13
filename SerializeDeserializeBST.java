
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * 
 *
 */

public class SerializeDeserializeBST {

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
	 * Serialize - DFS - pre-order Traversal (ROOT, Left, Right)
	 */
  private static void serialize(TreeNode node, StringBuilder sb) {
      if (node == null) {
			sb.append("null,");
			return;
		} else {
			sb.append(node.val + ",");
			serialize(node.left, sb);
			serialize(node.right, sb);
		}
  }

  public static TreeNode deserialize(String data) {
      if (data == null || data.length() == 0 )
			return null;
		List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserialize(nodes);
  }
  
  public static TreeNode deserialize(List<String> list) {
      if (list.get(0).equals("null")) {
			list.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		root.left = deserialize(list);
		root.right = deserialize(list);
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
