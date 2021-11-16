package gugudan_class;

import java.util.Scanner;

public class GugudanMain {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String number[] = scanner.nextLine().split(",");
		int first = Integer.parseInt(number[0]);
		int second = Integer.parseInt(number[1]);
		int[][] result = Gugudan.calculate(first,second);
		Gugudan.print(result);

	}
}
