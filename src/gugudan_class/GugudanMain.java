package gugudan_class;

import java.util.Scanner;
/*
 * 사용자가 입력한 값에 따라 크기가 다른 구구단을 계산해 출력한다.
 * 예를 들어 사용자가 "8,7"과 같은 문자열을 입력하면 팔칠단을 구현한다. 
 * 팔칠단은 2 * 1 ... 2 * 7, 3 * 1 ... 3 * 7, ... , 8 * 1 ... 8 * 7 까지 구현하는 것을 의미한다.
*/
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
