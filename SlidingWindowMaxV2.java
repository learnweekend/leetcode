
import java.util.Arrays;
import java.util.TreeMap;

public class SlidingWindowMaxV2 {

	public static void main(String[] args) {
		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 }; // 3,3,5,5,6,7
		int window = 3;
		//int[] arr = { 7, 2, 4 }; // 7, 4
		//int window = 2;
		System.out.println(Arrays.toString(slidingWindowMax(arr, window)));
	}

	public static int[] slidingWindowMax(int[] arr, int k) {

		if (arr == null || arr.length == 0 || k == 1)
			return arr;
		
		if (arr.length == 2)
			return arr[0] > arr[1] ? new int[] { arr[0] } : new int[] { arr[1] };
			
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		
		for(int i = 0; i < k; i++) {
			treeMap.put(arr[i], arr[i]);
		}

		int[] result = new int[arr.length - k + 1];

		for (int i = 0; i < result.length; i++) {
			result[i] = treeMap.lastKey(); 
			if (k + i < arr.length) {
				treeMap.put(arr[k + i], arr[k + i]);
				treeMap.remove(arr[i]);
			}
		}
		return result;
	}

}
