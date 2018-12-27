import java.util.Arrays;

/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
Example:
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
*/
public class SearchTwoDMatrix {
	
	//Runtime : O(N + M) | space : O(1)
	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
		int rowIndex = 0;
		int colIndex = matrix[0].length - 1;

		while (rowIndex >= 0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[0].length) {
			int value = matrix[rowIndex][colIndex];
			if (target == value) {
				return new int[] { rowIndex, colIndex };
			} else if (target < value) {
				colIndex--;
			} else {
				rowIndex++;
			}
		}
		return new int[] { -1, -1 };
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,   4,  7, 12, 15, 1000 },
				{2,   5, 19, 31, 32, 1001 },
				{3,   8, 24, 33, 35, 1002 },
				{40, 41, 42, 44, 45, 1003 },
				{99,100,103, 106,128,1004 },
		};
		System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 44)));
	}
}
