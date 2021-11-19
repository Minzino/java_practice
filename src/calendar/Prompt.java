package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT_year = "YEAR> ";
	private final static String PROMPT_month = "MONTH> ";
	private final static String PROMPT_weekday = "WEEKDAY> ";

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();

		int year = 0;
		int month = 0;

		// 횟수를 잘알때는 for가 좋고 횟수를 잘 모를때는 while이 좋다.
		while (true) {
			
			//연도 입력
			System.out.println("연도를 입력하세요.");
			System.out.print(PROMPT_year);
			year = sc.nextInt();
			if (year == -1) {
				break;
			}
			
			//월 입력
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT_month);
			month = sc.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12 || month < 1) {
				System.out.println("1~12사이의 달만 입력할 수 있습니다.");
				continue;
			}
			
			//시작 요일 입력
			System.out.println("첫번째 요일을 입력하세요.(SU, MO, WE, TH, FR, SA)");
			System.out.print(PROMPT_weekday);
			String weekday = sc.next();


			cal.printCalendar(year, month, weekday); // 달력을 출력
			System.out.println();
		}
		System.out.println("Have a nice day!"); // 프로그램 종료시 출력
		sc.close();

	}

}
