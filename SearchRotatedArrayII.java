
public class SearchRotatedArrayII {

	public static void main(String[] args) {
		
	}

	  public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;
        return search(nums, 0, nums.length - 1, target);
    }
    
    public boolean search(int[] nums, int start, int end, int target) {
        if(start == end) {
            return nums[start] == target;
        }
        
        // Check if the target is out of range
        if((nums[start] < nums[end]) && (target < nums[start] || target > nums[end])) {
            return false;
        } 
        
        //Recursively search first half and second half
         return search(nums, start, (start+end)/2, target) ||
            search(nums, (start+end)/2 + 1, end, target);
    }
}
