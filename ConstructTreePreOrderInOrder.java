
public class ConstructTreePreOrderInOrder {

   private static int rootIndex = 0;
   
   public static void main(String[] args) {
		int[] pre = {3,9,20,15,7};
		int[] in = {9,3,15,20,7};
		buildTree(pre, in);
   }
   
   public static TreeNode buildTree(int[] preorder, int[] inorder) {
      return buildTree(preorder, inorder, 0, preorder.length - 1);
  }
  
  private static TreeNode buildTree(int[] pre, int[] in, int start, int end) {
      if(start > end)
         return null;
      TreeNode root = new TreeNode(pre[rootIndex]);
      rootIndex++;
      int inIndex;
      for(inIndex = start; inIndex <= end; inIndex++)
          if(in[inIndex] == root.val)
              break;
      root.left = buildTree(pre, in, start, inIndex - 1);
      root.right = buildTree(pre, in, inIndex + 1, end);
      return root;
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
