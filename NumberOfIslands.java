
/**
 	https://leetcode.com/problems/number-of-islands/description/
 	
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

 */
public class NumberOfIslands {

	public int numIslands(char[][] grid) {
      if(grid == null || grid.length == 0)
          return 0;
      
      int rows = grid.length;
      int cols = grid[0].length;
      
      int noOfIslands = 0;
      
      for(int row = 0; row < rows; row++) {
          for(int col = 0; col < cols; col++) {
              if(grid[row][col] == '1'){
                  markVisited(grid, row, col);
                  noOfIslands++;
              }
          }
      }
      return noOfIslands;
  }
  
  private static void markVisited(char[][] grid, int row, int col) {
      int rows = grid.length;
      int cols = grid[0].length;
      
      if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' )
          return;
      
      grid[row][col] = '0';  // mark visited node
      markVisited(grid, row - 1, col);  // top element
      markVisited(grid, row + 1, col);  // down element
      markVisited(grid, row, col - 1);  // right element
      markVisited(grid, row, col + 1);  // left element
  }

}
