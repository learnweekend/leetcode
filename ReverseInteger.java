/*
https://leetcode.com/problems/reverse-integer/description/
Given a 32-bit signed integer, reverse digits of an integer.
*/

public class ReverseInteger {

  public static int reverse(int number){
    boolean isNegative = false;
    if(number < 0) {
      isNegative = true;
      number = -number;
    }
    long reversed = 0;

    while(number > 0) {
      int remainder = number % 10;
      number = number / 10;
      reversed = reversed * 10 + remainder;
    }
    if(isNegative){
      reversed = -reversed;
    }
    if(reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE)
       return 0;

    return (int) reversed;
  }

  public static void main(String[] args) {
    int number = 1534236891;
    System.out.println("reversed = " + reverse(number));
  }
}
