
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
Input: (2 -> 4 -> 3) : 342
     + (5 -> 6 -> 4) : 465
*/
public class AddNumbers {
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);

		ListNode result = addNumbers(head, head2);

		while (result != null) {
			System.out.print(result.val + "-");
			result = result.next;
		}

	}

	public static ListNode addNumbers(ListNode head1, ListNode head2) {

		int sum = 0;
		int carry = 0;

		ListNode sumList = new ListNode(-1);
		ListNode result = sumList;

		while (head1 != null || head2 != null) {
			int value1 = head1 == null ? 0 : head1.val; // 2
			int value2 = head2 == null ? 0 : head2.val; // 5

			sum = value1 + value2 + carry; // 17

			result.next = new ListNode(sum % 10); // 7

			carry = sum / 10;

			result = result.next;

			if (head1 != null)
				head1 = head1.next;

			if (head2 != null)
				head2 = head2.next;
		}

		if (carry > 0) {
			result.next = new ListNode(carry);
		}
		return sumList.next;
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
}
