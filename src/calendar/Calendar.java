package calendar;

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
	
	
	private int getWeekDay(int year, int month, int day){
		int syear = 1970;
		final int STANDARD_WEEKDAY = 3; //1970년 1월 1일은 목요일
		
		int count = 0;
		
		for(int i = syear; i <year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		} //구하려는 연도의 전년도까지 카운트
		
		for(int i = 1; i<month; i++) {
			int delta = getmaxDaysOfMonth(year, i);
			count += delta;
		} //구하려는 달의 전달까지 카운트
		
		count += day; // 전 달의 마지막날까지 더해줬으니 해당 월의 1일을 위해 day(=1)를 더해준다.
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		return weekday;
	}

	public void printCalendar(int year, int month) {

		System.out.printf("       << %d년  %d월 >>\n", year, month);
		StringBuilder sb = new StringBuilder();
		sb.append("  SU  MO  TU  WE  TH  FR  SA\n");
		sb.append("  ---------------------------");
		System.out.println(sb);
				
		int weekday = getWeekDay(year,month,1);
		for(int i = 0; i < weekday; i++) {
			System.out.print("    ");
		}

		int maxDay = getmaxDaysOfMonth(year, month);		
		int count = weekday;
		
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			count++;
			if (count % 7 == 0) {
				System.out.println(); // 카운트가 7로 나누어떨어질때마다 줄바꿈
			}
		}
	}
}