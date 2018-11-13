
import java.util.Arrays;

public class MeetingRoomsII {

	public static void main(String[] args) {
		Interval[] intervals = new Interval[2];
		intervals[0] = new Interval(1, 13);
		intervals[1] = new Interval(13, 15);
		
		/*Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);*/
		
		System.out.println(minMeetingRooms(intervals));
	}
	
   public static int minMeetingRooms(Interval[] intervals) {
      int noOfConfRooms = 0;
      if(intervals == null || intervals.length == 0)
          return noOfConfRooms;
      
      int[] startList = new int[intervals.length];
      int[] endList = new int[intervals.length];
      
      for(int i = 0; i < intervals.length; i++) {
      		startList[i] = intervals[i].start;
      		endList[i] = intervals[i].end;
      }
      Arrays.sort(startList);
      Arrays.sort(endList);
      
      int start = 0;
      int end = 0;
      
      for(int i = 0; i < intervals.length; i++) {
      		if(startList[start] >= endList[end]) {
      			noOfConfRooms--;
      			end++;
      		} 
      		start++;
      		noOfConfRooms++;
      }
      return noOfConfRooms;
  }
  
  private static class Interval {
	  private int start;
	  private int end;
	  
	  public Interval(int start, int end) {
		  this.start = start;
		  this.end = end;
	  }
  }

}
