import java.util.List;

/**
 * interview bit
 * https://www.interviewbit.com/problems/rotated-array/
 * 
 * https://www.youtube.com/watch?v=4qjprDkJrjY&feature=youtu.be
 */
public class RotatedSortedArraySearch {

	public int search(final List<Integer> a, int b) {
		if (a == null || a.size() == 0)
			return -1;

		int start = 0;
		int end = a.size() - 1;

		while (start <= end) {
			int mid = start + ((end - start) >> 1);

			if (b == a.get(mid)) {
				return mid;
			}
			if (a.get(start) <= a.get(mid)) {  // check if left side is sorted
				if (b >= a.get(start) && b <= a.get(mid)) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // right side is sorted
				if (b >= a.get(mid) && b <= a.get(end)) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
