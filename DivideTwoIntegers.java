public class DivideTwoIntegers {

	public static void main(String args[]) {
		int divident = 28;
		int divisor = 2;
		System.out.print(divide(divident, divisor));
	}

	public static int divide(int dividend, int divisor) {
		
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		
		int flag = 1;
		
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			flag = -1;
		
		if (divisor > 0)   // make the divisor (-ve) if divisor positive
			divisor = -divisor;
		
		if (dividend > 0)   // make the dividend (-ve) if dividend positive
			dividend = -dividend;
		
		int result = 0;
		
		while (dividend <= divisor) {
			int count = 1;
			int tempDivisor = divisor;
			
			while (dividend - tempDivisor <= tempDivisor) {
				count <<= 1;
				tempDivisor <<= 1;
			}
			result = result +  count;
			dividend = dividend - tempDivisor;
		}
		return flag > 0 ? result : -result;
	}

}
