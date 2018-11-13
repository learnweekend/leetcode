
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(8);

		ListNode list2 = new ListNode(3);
		list2.next = new ListNode(5);
		list2.next.next = new ListNode(9);

		ListNode list3 = new ListNode(4);
		list3.next = new ListNode(6);
		list3.next.next = new ListNode(12);

		ListNode[] lists = { list1, list2, list3 };
		ListNode result = mergeKLists(lists);

		print(result);

		ListNode pqResult = mergeSortedListsPQ(lists);
		print(pqResult);
	}

	/**
	 * brute force - merge lists one by one 
	 * runtime : O(K * N); 
	 * space : O(1);
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		if (lists.length == 1)
			return lists[0];

		for (int i = 0; i < lists.length - 1; i++) {
			lists[i + 1] = mergeSortedLists(lists[i], lists[i + 1]);
			lists[i] = null;
		}
		return lists[lists.length - 1];
	}

	private static ListNode mergeSortedLists(ListNode first, ListNode second) {
		ListNode result = new ListNode(0);
		ListNode node = result;
		while (first != null && second != null) {
			if (first.val < second.val) {
				result.next = first;
				first = first.next;
			} else {
				result.next = second;
				second = second.next;
			}
			result = result.next;
		}
		while (first != null) {
			result.next = first;
			first = first.next;
			result = result.next;
		}
		while (second != null) {
			result.next = second;
			second = second.next;
			result = result.next;
		}
		return node.next;
	}
	/**
	 * Merge lists using priority queue 
	 * runtime : (N log k) 
	 * space : O(N)
	 */
	public static ListNode mergeSortedListsPQ(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		ListNode result = new ListNode(-1);
		ListNode temp = result;

		/* Use comparator to sort based on node value */

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode node1, ListNode node2) {
				return node1.val - node2.val;
			}
		});

		// push all sorted lists to PQ
		for (ListNode node : lists) {
			if (node != null)
				queue.offer(node);
		}

		// poll the minimum value nodes and add to result list
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			temp.next = node; //new ListNode(node.val);  // avoid creating a new node
			temp = temp.next;

			if (node.next != null) // add next node to PQ
				queue.add(node.next);
			node.next = null;  // making sure the next is null
		}
		return result.next;
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	private static void print(ListNode node) {
		ListNode temp = node;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
