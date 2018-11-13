/**
 * interview bit
 * https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 * 
 * Solutions :
 * 1. O(A * B), Space : O(1)  ==> Using Two nested loops
 * 2. O(A + B), Space : O(A)  ==> Using extra space or set 
 * 3. O(A log(B)), Space :O(1) ==> Using Binary search
 * 4. O(A + B ), Space O(1)  ==> Using Loop through the arrays 
 */
import java.util.ArrayList;
import java.util.List;

public class IntersectionSortedArrays {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();

		List<Integer> B = new ArrayList<>();
		B.add(10000000);

		System.out.println(intersect(A, B));
	}
	
	/** 
	 * O(A + B ), Space O(1)  ==> Using Loop through the arrays 
	 */
	public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		if (A == null || A.size() == 0 || B == null || B.size() == 0)
			return null;

		int aStart = 0;
		int bStart = 0;
		ArrayList<Integer> result = new ArrayList<>();
		
		while (aStart < A.size() && bStart < B.size()) {
			if (A.get(aStart).equals(B.get(bStart))) {   // equals - because Integer object and not primitive
				result.add(A.get(aStart));
				aStart++;
				bStart++;
			} else if (A.get(aStart) < B.get(bStart)) {
				aStart++;
			} else {
				bStart++;
			}
		}
		return result;
	}

}
