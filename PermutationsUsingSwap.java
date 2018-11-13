
import java.util.Arrays;

public class PermutationsUsingSwap {
	
	private static int count = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		arrayPermutations(arr);
	}

	private static void arrayPermutations(int[] arr) {
		arrayPermutations(arr, arr.length - 1);
	}

	private static void arrayPermutations(int[] arr, int n) {
		if (n == 0) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i <= n; i++) {
			swap(arr, i, n - 1);
			arrayPermutations(arr, n - 1);
			swap(arr, i, n - 1);
		}
	}

	private static void swap(int[] a, int i, int j) {
		System.out.println(count++);
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
