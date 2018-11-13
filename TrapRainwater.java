public class TrapRainwater {

	public static void main(String[] args) {

	}
	
	public int trap(int[] height) {
      if(height.length == 0)
          return 0;
      
      int left = 0, leftMax = 0;
      int right = height.length - 1;
      int rightMax = 0;
      
      int result = 0;
      
      while(left < right) {
          leftMax = leftMax > height[left] ? leftMax : height[left];
          rightMax = rightMax > height[right] ? rightMax : height[right];
          
          result = result + leftMax > rightMax ? leftMax - height[left++] :
                            rightMax - height[right--];
      }
      return result;        
  }

}
