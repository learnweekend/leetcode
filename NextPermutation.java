
import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(Arrays.toString(nums));
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void nextPermutation(int[] nums) {
		if(nums == null || nums.length == 0)
			return;
		
		int N = nums.length;
		int end = N - 2 ; 
		
		while(end >= 0 && nums[end + 1] <= nums[end]) {
			end--;
		}
		
		if(end >= 0) {
			int j = nums.length - 1; 
			while(j >= 0 && nums[j] <= nums[end] ) {
				j--;
			}
			swap(nums, end, j);
		}
		reverse(nums, end + 1);
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void reverse(int[] arr, int start) {
		int N = arr.length - 1;
		while(start <= N) {
			swap(arr, start++, N--);
		}
	}

}
