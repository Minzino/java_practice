package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		// 횟수를 잘알때는 for가 좋고 횟수를 잘 모를때는 while이 좋다.
		while (true) {
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			int month = sc.nextInt(); // 출력할 달 입력
			if (month == -1) {
				break;
			}
			if (month > 12 || month < 1) {
				System.out.println("1~12사이의 달만 입력할 수 있습니다.");
				continue;
			}
			cal.printCalendar(2021, month); // 달력을 출력
			System.out.println();
		}
		System.out.println("Have a nice day!"); // 프로그램 종료시 출력
		sc.close();

	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
