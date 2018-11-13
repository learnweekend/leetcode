public class IntegerToEnglishWords {

	public static void main(String[] args) {
		int number = 34366;
		System.out.println(numberToWords(number));
	}

	public static String numberToWords(int number) {
		if (number == 0)
			return "Zero";
		return numberToWords(number, 0);
	}

	private static String numberToWords(int number, int index) {
		String[] words = { "Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty",
				"Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen",
				"Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two",
				"One" };

		int[] numbers = { 1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12,
				11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		StringBuilder sb = new StringBuilder();

		for (int i = index; i < numbers.length; i++) {
			int value = number / numbers[i];
			if (value > 0) {
				System.out.println("value = " + value);
				System.out.println("number = " + number);
				if (number >= 100) {
					System.out.println("calling inner");
					sb.append(numberToWords(number / numbers[i], i + 1));
				}
				sb.append(words[i]);
				System.out.println("string =============== " + sb.toString());
				sb.append(" ");
				number = number % numbers[i];
			}
		}
		return sb.toString();
	}

}
