
public class ListCycle {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
      if(head == null)
          return false;
      
      if(head.next == null)
          return false;
      
      ListNode fast = head.next;
      ListNode slow = head;
      
      if(slow == fast)
          return true;
      
      while(slow != null && fast != null && fast.next != null){
          if(slow == fast){
              return true;
          }
          slow = slow.next;
          if(fast.next != null)
              fast = fast.next.next;
          
      }
      return false;
  }
	
	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

}
