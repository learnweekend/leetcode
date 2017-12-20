
import java.util.*;

public class MoveAllZerosToEnd {

  private static void moveAllZerosToEnd(int[] arr){

    int index = 0;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] != 0)
        arr[index++] = arr[i];
    }
    while(index < arr.length)
       arr[index++] = 0;
  }

  public static void main(String[] args) {
    int[] arr = {2,3,0,3,0,1,0};
    moveAllZerosToEnd(arr);
    System.out.println(Arrays.toString(arr));
  }

}
