package calendar;

import java.util.HashMap;
import java.util.Map;

/*
 * 년도를 입력하세요.
 * YEAR> 2017
 * 달을 입력하세요.
 * MONTH> 3
 * 첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)
 * WEEKDAY> WE
 * <<2017년  3월>>
 * SU MO TU WE TH FR SA
 * ---------------------
 *         1  2  3  4
 * 5  6  7  8  9 10 11
 * ...
 */
public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	

	// 윤년 계산 메소드
	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}

	}

	// 마지막날 get 메소드
	public int getmaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];

		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public void printCalendar(int year, int month, String weekday) {
		Map<String,Integer> day = new HashMap<String,Integer>();
		day.put("SU", 0);
		day.put("MO", 1);
		day.put("TU", 2);
		day.put("WE", 3);
		day.put("TH", 4);
		day.put("FR", 5);
		day.put("SA", 6);

		
		System.out.printf("       << %4d  %2d >>\n", year, month);
		StringBuilder sb = new StringBuilder();
		sb.append("  SU  MO  TU  WE  TH  FR  SA\n");
		sb.append("  ---------------------------");
		System.out.println(sb);

		int maxDay = getmaxDaysOfMonth(year, month);

		int count = 0;
		
		//weekday만큼 공백 생성
		for (int j = 0; j < day.get(weekday); j++) {
			System.out.print("    ");
			count++;
		}

		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			count++;
			if(count % 7 ==0) {
				System.out.println(); //카운트가 7로 나누어떨어질때마다 줄바꿈
			}
		}
	}
}