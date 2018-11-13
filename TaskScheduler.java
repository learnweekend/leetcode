import java.util.Arrays;

/**
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.
Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
*/

public class TaskScheduler {
	
	public static int leastInterval(char[] tasks, int n) {
      int[] tasksCount = new int[26];
      
      for (char c: tasks)
          tasksCount[c - 'A']++;
      
      Arrays.sort(tasksCount);
      int max_val = tasksCount[25] - 1; // -1 because for first task we don't need idle time.
      int idle_slots = max_val * n;
      
      for (int i = 24; i >= 0 && tasksCount[i] > 0; i--) {
          idle_slots -= Math.min(tasksCount[i], max_val);
      }
      return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
  }
	

	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int cooling_period = 2;
		
		System.out.println("Least Interval = " + leastInterval(tasks, cooling_period));
	}
}
