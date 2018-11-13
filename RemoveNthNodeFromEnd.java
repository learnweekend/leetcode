/*
	Given a linked list, remove the n-th node from the end of list and return its head.
	Example:
	Given linked list: 1->2->3->4->5, and n = 2.
	After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
		Given n will always be valid.
	Follow up:
		Could you do this in one pass?
*/
public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		print(head);
		int n = 5;
		ListNode result = removeNthFromEnd(head, n);
		print(result);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;

		ListNode front = head;  // both refer at the head of the list
		ListNode back = head;

		for (int i = 0; i < n; i++) {  // move the front pointer n steps forward
			front = front.next;
		}

		if (front == null)  // This is when head is deleted
			return head.next;

		while (front.next != null) {
			front = front.next;
			back = back.next;
		}
		back.next = back.next.next;  // update the back pointer

		return head; // return new head
	}

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