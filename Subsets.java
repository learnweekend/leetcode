import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		List<List<Integer>> output = subsets(arr);
		for(List<Integer> subset : output) {
			System.out.println(subset);
		}
	}
	
   public static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> subsets = new ArrayList<>();
      if(nums == null || nums.length == 0)
          return subsets;
      int[] buffer = new int[nums.length];
      subsets(subsets, nums, 0, buffer, 0);
      return subsets;
  }
  
  public static void subsets(
      List<List<Integer>> subsets,
      int[] arr,
      int startIndex,
      int[] buffer,
      int bufferIndex ) {
      
      //base case
      List<Integer> subset = new ArrayList<>();
      for(int i = 0; i < bufferIndex; i++) {
          subset.add(buffer[i]);
      }
      subsets.add(subset);
      
      if(bufferIndex == buffer.length || startIndex == arr.length)
      		return;
      
      for(int i = startIndex; i < arr.length; i++) {
          buffer[bufferIndex] = arr[i];
          subsets(subsets, arr, i+1, buffer, bufferIndex + 1);
      }
  }

}
