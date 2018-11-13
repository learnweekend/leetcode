
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		print(head);
		ListNode result = reverseListRecursive(head);
		print(result);
	}

	/**
	 * Reverse Linked - Iterative
	 */
	public static ListNode reverseList(ListNode node) {
		if(node == null)
			return node;
		
		ListNode curr = node;
		ListNode prev = null;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static ListNode reverseListRecursive(ListNode node) {
		if(node == null)
			return node;
		
		return reverseList(node, null);
	}
	
	private static ListNode reverseList(ListNode node, ListNode prev) {
		if(node == null)
			return prev;
		
		ListNode head = new ListNode(node.val);
		head.next = prev;
		return reverseList(node.next, head);
	}

	/**
	 * Reverse Linked - Iterative
	 */
	
	public static void print(ListNode node) {
		ListNode result = node;
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

}
