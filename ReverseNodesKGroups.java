/*
 https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 problem : reverse linked list group of 'k' nodes
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.
 For example,
 Given this linked list: 1->2->3->4->5
 For k = 2, you should return: 2->1->4->3->5
 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesKGroups {

	private static Node reverseKGroupsV1(Node head, int k) {
		if (head == null || k == 0)
			return head;
		int size = size(head); // size
		if (k > size)
			return head;
		int lastNodes = size % k; // to cut the list at the remaining list
		Node back = head;
		Node front = head;

		for (int i = 0; i <= lastNodes; i++) { // note : move to end of group k
			front = front.next;
		}
		while (front != null) {
			front = front.next; // move forward the front pointer
			back = back.next; // move the back pointer forward
		}
		Node next = back.next;
		back.next = null;
		return reverseK(head, k, next);
	}

	private static Node reverseK(Node node, int k, Node back) {
		if (node == null)
			return null;
		Node curr = node;
		Node prev = null;
		Node next = null;
		int count = 0;

		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null) {
			node.next = reverseK(next, k, back);
		}

		if (next == null) { // last nodes
			node.next = back;
		}
		return prev;
	}

	private static int size(Node node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	private static void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static class Node {
		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		print(head);
		int k = 4;
		 Node reversed = reverseKGroupsV1(head, k);
		//Node reversed2 = reverseKGroup(head, k);
		print(reversed);
	}
}
