package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT_year = "YEAR> ";
	private final static String PROMPT_month = "MONTH> ";

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int year = 0;
		int month = 0;

		while (true) {

			// 연도 입력
			System.out.println("연도를 입력하세요.(종료: -1)");
			System.out.print(PROMPT_year);
			year = sc.nextInt();
			if (year == -1) {
				break;
			}

			// 월 입력
			System.out.println("월을 입력하세요.(종료: -1)");
			System.out.print(PROMPT_month);
			month = sc.nextInt();
			
			if (month == -1) {
				break;
			}
			if (month > 12 || month < 1) {
				System.out.println("1~12사이의 달만 입력할 수 있습니다.");
				continue;
			}


			cal.printCalendar(year, month); // 달력을 출력
			System.out.println();
		}
		System.out.println("Have a nice day!");
		sc.close();

	}

}
