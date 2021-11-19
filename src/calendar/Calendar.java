package calendar;

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

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public int getmaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];

		} else {
			return MAX_DAYS[month - 1];
		}
	} // 월말을 리턴

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("       <<%4d  %3d>>\n", year, month);
		StringBuilder sb = new StringBuilder();
		sb.append(" SU  MO  TU  WE  TH  FR  SA\n");
		sb.append(" ---------------------------");
		System.out.println(sb);

		int maxDay = getmaxDaysOfMonth(year, month);
		int maxDay2 = maxDay + weekday;
		int j = weekday;
				
		for (int i = 1; i <= maxDay; i++) {
			j++;
			if (i == maxDay2 || j % 7 == 0) {
				System.out.printf("%3d \n", i);
			}			
			else {
				while(weekday != 0) {
				System.out.print("    ");
				weekday--;
				}
				System.out.printf("%3d ", i);
			}
		}
	}
}
//		sb.append(" 1   2   3   4   5   6   7\n");
//		sb.append(" 8   9  10  11  12  13  14\n");
//		sb.append("15  16  17  18  19  20  21\n");
//		sb.append("22  23  24  25  26  27  28\n");
//		System.out.println(sb);