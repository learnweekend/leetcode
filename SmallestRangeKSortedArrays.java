import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=zplklOy7ENo&list=PLA8lYuzFlBqAy6dkZHj5VxUAaqr4vwrka&index=3
 * https://leetcode.com/problems/smallest-range/
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]] Output: [20,24] Explanation: List 1: [4, 10,
 * 15, 24,26], 24 is in range [20,24]. List 2: [0, 9, 12, 20], 20 is in range [20,24]. List 3: [5,
 * 18, 22, 30], 22 is in range [20,24]
 */
public class SmallestRangeKSortedArrays {
	
	public static int[] smallestRange(List<List<Integer>> sortedLists) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int range = Integer.MAX_VALUE;
		int minRange = Integer.MAX_VALUE;
		int minRangeMin = 0;
		int minRangeMax = 0;
		
		PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
	// Insert first element from each list
		for (int i = 0; i < sortedLists.size(); i++) {
			if (sortedLists.get(i).size() > 0) {
				pq.add(new QueueNode(i, 0, sortedLists.get(i).get(0)));
				// calculate the max for first elements added to queue
				max = Math.max(max, sortedLists.get(i).get(0)); 
			}
		}
		while (!pq.isEmpty()) {
			QueueNode node = pq.poll(); // poll the minimum node from pq
			min = node.value;
			range = max - min;   // calculate the range
			if(range < minRange) {  // check if range is < minRange
				minRange = range;
				minRangeMin = min;
				minRangeMax = max;
			}
			int newIndex = node.index + 1;  // next element to add into PQ
			if (newIndex < sortedLists.get(node.list).size()) {  // check if any of the list falls out of range.
				pq.add(new QueueNode(node.list, newIndex, sortedLists.get(node.list).get(newIndex)));
				max = Math.max(max, sortedLists.get(node.list).get(newIndex));
			} else {
				return new int[] { minRangeMin, minRangeMax };
			}
		}
		return new int[] { minRangeMin, minRangeMax };
	}

	private static class QueueNode implements Comparable<QueueNode> {
		private int list;
		private int index;
		private int value;

		public QueueNode(int list, int index, int value) {
			this.list = list;
			this.index = index;
			this.value = value;
		}

		public int compareTo(QueueNode n) {
			if (value > n.value)
				return 1;
			if (value < n.value)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list1 = Arrays.asList(4, 10, 15, 24, 26);
		List<Integer> list2 = Arrays.asList(0, 9, 12, 20);
		List<Integer> list3 = Arrays.asList(5, 18, 22, 30);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		int[] range = smallestRange(lists);
		System.out.println(Arrays.toString(range));
	}
}
