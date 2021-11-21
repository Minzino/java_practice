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
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("su"))
			return 0;
		else if (week.equals("mo"))
			return 1;
		else if (week.equals("tu"))
			return 2;
		else if (week.equals("we"))
			return 3;
		else if (week.equals("th"))
			return 4;
		else if (week.equals("fr"))
			return 5;
		else if (week.equals("sa"))
			return 6;
		else
			return 0;
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

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			if (cmd.equals("1"))
				cmdRegister(br, cal);
			else if (cmd.equals("2"))
				cmdSearch(br, cal);
			else if (cmd.equals("3"))
				cmdCal(scanner, cal);
			else if (cmd.equals("h"))
				printMenu();
			else if (cmd.equals("q"))
				break;
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
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습ㄴ디ㅏ.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(BufferedReader br, Calendar cal) throws ParseException, IOException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = br.readLine();

		System.out.println("일정을 입력해 주세요.(입력종료는 ;)");
		String text = "";
		while (true) {
			String word = br.readLine(); //nextLine은 에러가 있는 거같아서 readLine으로 입력을 한번에 받아줬다.
			
			if(word.endsWith(";")) {
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