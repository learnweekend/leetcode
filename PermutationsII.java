
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	private static int count = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2 };
		List<List<Integer>> result = permuteUnique(arr);
		for (List<Integer> p : result) {
			System.out.println(p);
		}
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> permutations = new HashSet<>();
		List<List<Integer>> unique = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return unique;
		boolean[] isInBuffer = new boolean[nums.length];
		int[] buffer = new int[nums.length];
		permute(permutations, nums, buffer, 0, isInBuffer);
		unique = new ArrayList<>(permutations);
		return unique;
	}

	public static void permute(Set<List<Integer>> permutations, int[] arr, int[] buffer, int bufferIndex,
			boolean[] isInBuffer) {

		// base case
		if (bufferIndex == buffer.length) {
			List<Integer> permute = new ArrayList<Integer>();
			for (int i : buffer)
				permute.add(i);
			permutations.add(permute);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!isInBuffer[i]) {
				buffer[bufferIndex] = arr[i]; // fill the buffer
				isInBuffer[i] = true;
				permute(permutations, arr, buffer, bufferIndex + 1, isInBuffer); // recursive
				isInBuffer[i] = false;
			}
		}
	}
	
	public List<List<Integer>> permuteUniqueV2(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      if (nums==null || nums.length==0) { return ans; }
      permute(ans, nums, 0);
      return ans;
  }
  
  private void permute(List<List<Integer>> ans, int[] nums, int index) {
      if (index == nums.length) { 
          List<Integer> temp = new ArrayList<>();
          for (int num: nums) { temp.add(num); }
          ans.add(temp);
          return;
      }
      Set<Integer> appeared = new HashSet<>();
      for (int i=index; i<nums.length; ++i) {
          if (appeared.add(nums[i])) {
              swap(nums, index, i);
              permute(ans, nums, index+1);
              swap(nums, index, i);
          }
      }
  }
  
  private void swap(int[] nums, int i, int j) {
      int save = nums[i];
      nums[i] = nums[j];
      nums[j] = save;
  }
}
