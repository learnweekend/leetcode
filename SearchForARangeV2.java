  
  
public class SearchForARangeV2 {
  
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{firstIndex(nums, target), lastIndex(nums, target)};  
    }
 
    private static int firstIndex(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] > target || (arr[mid] == target && mid > 0 && arr[mid] == arr[mid - 1]))
                end = mid - 1;
            else if(arr[mid] < target)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    
    private static int lastIndex(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] > target)
                end = mid - 1;
            else if(arr[mid] < target || (arr[mid] == target && mid < arr.length - 1 && arr[mid] == arr[mid + 1]))
                start = mid + 1;
            else 
                return mid;
        }
        return -1;
    }
  
  public static void main(String[] args) {
     int[] arr = {5, 7, 7, 8, 8, 10};
     int target = 8;
     int[] range = searchRange(arr, target);
     System.out.println(Arrays.toString(range));
   }
  }
  
  
