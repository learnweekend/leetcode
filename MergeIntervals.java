
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since intervals
 * [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered
 * overlapping.
 * 
 */

public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		
		List<Interval> result = merge(intervals);
		for(Interval interval : result) {
			System.out.println(interval.start + "," +interval.end);
		}
	}
	
	/**
	 * Solution :  Sort the Intervals based on start time.(use customer comparator)
	 *  1. Add the first interval to the result;
	 *  2. Traverse through the sorted intervals
	 *  3. Check if last.end >= curr.start, then set the last.end = Math(last.end, curr.end)
	 *  4. Else  add the interval to the result (no need to merge)
	 *  5. return the result
	 *  Runtime : O( N Log N) - to sort the intervals
	 *  Space   : O(1);
	 */
	public static List<Interval> merge(List<Interval> intervals) {
		LinkedList<Interval> result = new LinkedList<>(); // LinkedList to get the last() in O(1)

		if (intervals == null || intervals.size() == 0) // base case
			return result;

		Collections.sort(intervals, new Comparator<Interval>() { // sort based on start interval
			@Override
			public int compare(Interval a, Interval b) {
				return a.getStart() == b.getStart() ? 0 : a.getStart() > b.getStart() ? 1 : -1;
			}
		});

		for (Interval interval : intervals) {
			if (result.isEmpty()) // add the first interval
				result.add(interval);

			if (result.getLast().getEnd() >= interval.getStart()) { // check if Last.end >= curr.start
				result.getLast().setEnd(Math.max(result.getLast().getEnd(), interval.getEnd())); //
			} else {
				result.add(interval); // no need for merge
			}
		}
		return result;
	}

	private static class Interval {
		private int start;
		private int end;

		public Interval(int a, int b) {
			this.start = a;
			this.end = b;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
	}
}
