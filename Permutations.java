
import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	private static int count = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3};
		List<List<Integer>> result = permute(arr);
		for(List<Integer> p : result) {
			System.out.println(p);
		}
	}
	
	public static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> permutations = new ArrayList<>();
      if(nums == null || nums.length == 0)
         return permutations;
      boolean[] isInBuffer = new boolean[nums.length];
      int[] buffer = new int[nums.length];
      permute(permutations, nums, buffer, 0, isInBuffer);
      return permutations;
  }
  
  public static void permute(
      List<List<Integer>> permutations, 
      int[] arr, 
      int[] buffer, 
      int bufferIndex, 
      boolean[] isInBuffer) {
      
      //base case
      if(bufferIndex == buffer.length){
          List<Integer> permute = new ArrayList<Integer>();
          for (int i : buffer)
         	 	permute.add(i);
          permutations.add(permute);
          return;
      }
      // find next candidate to buffer
      for(int i = 0; i < arr.length; i++) {
      		System.out.println(count++);
          if(!isInBuffer[i]){
              buffer[bufferIndex] = arr[i];  // fill the buffer
              isInBuffer[i] = true;
              permute(permutations, arr, buffer, bufferIndex + 1, isInBuffer); // recursive
              isInBuffer[i] = false; 
          }
      }
  }

}
