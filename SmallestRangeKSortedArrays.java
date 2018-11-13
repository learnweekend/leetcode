import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=zplklOy7ENo&list=PLA8lYuzFlBqAy6dkZHj5VxUAaqr4vwrka&index=3
 * 
 * https://leetcode.com/problems/smallest-range/
 * 
 * Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24]

	//TODO NOT COMPLETE
 * 
 *
 */
public class SmallestRangeKSortedArrays {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list1 =  Arrays.asList(4,10,15,24,26);
		List<Integer> list2 =  Arrays.asList(0,9,12,20);
		List<Integer> list3 =  Arrays.asList(5,18,22,30);
		
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		
		int[] range = smallestRange(lists);
		System.out.println(Arrays.toString(range));
	}
	
	public static int[] smallestRange(List<List<Integer>> sortedList) {
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int range = 0;
		
		int minRange = Integer.MAX_VALUE;
		int minRangeMin = Integer.MAX_VALUE;
		int minRangeMax = Integer.MIN_VALUE;
		
		PriorityQueue<List<Integer>> pQueue = 
				new PriorityQueue<>(new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> node1, List<Integer> node2) {
				return node1.get(0) - node2.get(0);
			}
		});
		
		int index = 0;
		for(int i = 0; i < sortedList.size(); i++) {
			List<Integer> list = sortedList.get(0);
			int val = list.get(0);
			if(val < min) {
				min = val;
				index = i;
			} 
			if(val > max) {
				max = val;
			}
		}
		range = max - min;
		
		System.out.println(min);
		System.out.println(max);
		System.out.println(range);
		
		if(range < minRange) {
			minRange = range;
			minRangeMin = min;
			minRangeMax = max;
		}
		
		for(int i = 0; i < sortedList.size(); i++) {
			List<Integer> list = sortedList.get(i);
			List<Integer> temp = new ArrayList<>();
			if(index == i) {
				temp.addAll(list);
				temp.remove(0);
				if(temp != null && temp.size() > 0) {
					pQueue.add(temp);
				}
			}
			if(list != null && list.size() > 0) {
				pQueue.add(list);
			}
		}
		
		for(List<Integer> list : sortedList) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(list);
			temp.remove(0);
			if(temp != null && temp.size() > 0) {
				pQueue.add(temp);
			}
		}
		
		while (!pQueue.isEmpty()) {
			System.out.println();
			List<Integer> node = pQueue.poll();
			min = node.get(0);
			node.remove(0);
			int temp = Integer.MIN_VALUE;
			if(node.size() > 0) {
				temp = node.get(0);
				pQueue.add(node);
				if(temp > max) {
					max = temp;
				}
				range = max - min;
				if(range < minRange) {
					minRange = range;
					minRangeMin = min;
					minRangeMax = max;
				}
			} else {
				return new int[] {minRangeMin, minRangeMax};
			}
		}
		return new int[] {minRangeMin, minRangeMax};
	}

}
