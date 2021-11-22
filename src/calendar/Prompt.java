package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록           ");
		System.out.println("| 2. 일정 검색           ");
		System.out.println("| 3. 달력 보기			  ");
		System.out.println("| h. 도움말 q. 종료		");
		System.out.println("+----------------------+");
	}

	/**
	 * 1. switch case - String 
	 * 2.Plan class - refactoring?
	 */

	/**
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}
//	+----------------------+
//	| 1. 일정 등록           
//	| 2. 일정 검색           
//	| 3. 달력 보기
//	| h. 도움말 q. 종료
//	+----------------------+

	public void runPrompt() throws ParseException, IOException {
		printMenu();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		boolean isLoop = true;

		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister(br, cal);
				break;
			case "2":
				cmdSearch(br, cal);
				break;
			case "3":
				cmdCal(scanner,cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		System.out.println("Hava a nice day~");
		scanner.close();

		
		
	}

	private void cmdCal(Scanner scanner, Calendar cal) {
		int month = 1;
		int year = 2017;

		System.out.println("년도를 입력하세요.(exit: -1)");
		System.out.print("YEAR> ");
		year = scanner.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = scanner.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		cal.printCalendar(year, month);
	}

	private void cmdSearch(BufferedReader br, Calendar cal) throws IOException {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = br.readLine();
		PlanItem plan = cal.searchPlan(date);
		if(plan != null) {
			System.out.println(plan.detail);
		}else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(BufferedReader br, Calendar cal) throws ParseException, IOException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = br.readLine();

		System.out.println("일정을 입력해 주세요.(입력종료는 ;)");
		String text = "";
		while (true) {
			String word = br.readLine(); // nextLine은 에러가 있는 거같아서 readLine으로 입력을 한번에 받아줬다.

			if (word.endsWith(";")) {
				break;
			}
			text += word + "\n";
		}
		cal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException, IOException {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}