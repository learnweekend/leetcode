
public class ListIntersection {

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(2);
		ListNode intersection = getIntersectionNode(headA, headB);
		System.out.println(intersection.val);
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int sizeA = size(headA);
		int sizeB = size(headB);
		
		ListNode currA = headA;
		while(sizeA > sizeB) {
			currA = currA.next;
			sizeA--;
		}
		ListNode currB = headB;
		while(sizeB > sizeA) {
			currB = currB.next;
			sizeA--;
		}
		
		while(currA != null && currB != null) {
			if(currA == currB)
				return currA;
			currA = currA.next;
			currB = currB.next;
		}
		return null;
	}

	public static int size(ListNode node) {
		ListNode curr = node;
		int size = 0;
		while (curr != null) {
			size++;
			curr = curr.next;
		}
		return size;
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

}
