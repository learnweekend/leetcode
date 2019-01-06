package leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * Input: 1->2 Output: false
 * Example 2:
 * Input: 1->2->2->1 Output: true
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode secongHalf = getSecondHalfOfList(head);
		ListNode reverseSecongHalf = reverseList(secongHalf);
		while (head != null && reverseSecongHalf != null) {
			if (head.val != reverseSecongHalf.val)
				return false;
			head = head.next;
			reverseSecongHalf = reverseSecongHalf.next;
		}
		return true;
	}

	private static ListNode reverseList(ListNode node) {
		if (node == null)
			return node;
		ListNode curr = node;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static ListNode getSecondHalfOfList(ListNode list) {
		
		if (list == null || list.next == null)
			return null;
		
		ListNode slow = list;
		ListNode fast = list.next; // point the fast to 2nd node
		
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next; // increment slow and fast pointers
				fast = fast.next;
			}
		}
		ListNode partTwo = slow.next;
		slow.next = null;
		return partTwo;
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int value) {
			this.val = value;
		}
	}
}
