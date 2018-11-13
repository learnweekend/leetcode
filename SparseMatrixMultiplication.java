import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
	
	public static void main(String[] args) {
		
	}
	
	public static int[][] multiply(int[][] A, int[][] B) {
		
		int[][] result = new int[A.length][B[0].length];
		
		List<Pair> listA = new ArrayList<>(); // to hold non-zero elements of A
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				if(A[i][j] != 0)
					listA.add(new Pair(i, j));
			}
		}
		List<Pair> listB = new ArrayList<>(); // to hold non-zero elements of B
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				if(B[i][j] != 0) {
					listB.add(new Pair(i, j));
				}
			}
		}
		
		for(Pair pairA : listA) {
			for(Pair pairB : listB) {
				if (pairA.y == pairB.x) {
					result[pairA.x][pairB.y] += A[pairA.x][pairA.y] * B[pairB.x][pairB.y];
				}
			}
		}
		return result;
   }
	
	private static class Pair {
		private int x;
		private int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
