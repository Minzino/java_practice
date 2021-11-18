package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int maxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}
	
	public void printSampleCalendar() {
		StringBuilder sb = new StringBuilder();
		sb.append(" 일  월  화  수  목  금  토  일\n");
		sb.append("--------------------------\n");
		sb.append(" 1   2   3   4   5   6   7\n");
		sb.append(" 8   9  10  11  12  13  14\n");
		sb.append("15  16  17  18  19  20  21\n");
		sb.append("22  23  24  25  26  27  28");
		System.out.println(sb);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "cal > ";
		
		//횟수를 잘알때는 for가 좋고 횟수를 잘 모를때는 while이 좋다.
		while(true) {
		System.out.println("달을 입력하세요.");
		System.out.print(PROMPT);
		int month = sc.nextInt(); // 출력할 달 입력
		if(month == -1) {
			break;
		}
		if(month > 12 || month < 1) {
			System.out.println("1~12사이의 달만 입력할 수 있습니다.");
			continue;
		}
		System.out.println(month+"월은 "+cal.maxDaysOfMonth(month)+"일까지 있습니다.");
		}
		
		System.out.println("Have a nice day!");
		sc.close();

	}
}
