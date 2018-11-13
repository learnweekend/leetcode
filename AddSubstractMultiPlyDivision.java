public class AddSubstractMultiPlyDivision {

	public static void main(String[] args) {
		
		int num1 = 28;
		int num2 = 3;
		System.out.println(add(num1, num2));
		System.out.println(subtract(num1, num2));
	}

	public static int add(int num1, int num2) {
		int sum, carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (num2 != 0);
		
		return num1;
	}

	public static int subtract(int num1, int num2) {
		num2 = add(~num2, 1);
		return add(num1, num2);
	}

	public static int multiply(int num1, int num2) {
		boolean minus = false;
		if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0))
			minus = true;
		if (num1 < 0)
			num1 = add(~num1, 1);
		if (num2 < 0)
			num2 = add(~num2, 1);
		int result = 0;
		while (num1 > 0) {
			if ((num1 & 0x1) != 0) {
				result = add(result, num2);
			}
			num2 = num2 << 1;
			num1 = num1 >> 1;
		}
		if (minus)
			result = add(~result, 1);
		return result;
	}

	public static int divide(int num1, int num2) {
		
		if (num2 == 0)
			throw new ArithmeticException("num2 is zero.");
		
		boolean minus = false;
		
		if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0))
			minus = true;
		
		if (num1 < 0)
			num1 = add(~num1, 1);
		
		if (num2 < 0)
			num2 = add(~num2, 1);
		
		int result = 0;
		
		for (int i = 0; i < 32; i = add(i, 1)) {
			
			result = result << 1;
			
			if ((num1 >> (31 - i)) >= num2) {
				
				num1 = subtract(num1, num2 << (31 - i));
				
				result = add(result, 1);
			}
		}
		
		if (minus)
			result = add(~result, 1);
		
		return result;
	}

}
