package calendar;

/* 
 * 월을 입력하면 해당월의 달력을 출력한다.
 * 달력은 모양은 1단계에서 작성한 모양으로 만든다.
 * 1일은 일요일로 정해도 무방하다.
 * -1을 입력받기 전까지 반복 입력받는다.
 * 프롬프트를 출력한다.
 */
public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getmaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	} // 월말을 리턴

	public void printCalendar(int year, int month) {
		System.out.printf("       <<%4d  %3d>>\n", year, month);
		StringBuilder sb = new StringBuilder();
		sb.append(" SU  MO  TU  WE  TH  FR  SA\n");
		sb.append(" ---------------------------\n");
		System.out.print(sb);
		int maxDay = getmaxDaysOfMonth(month);
		for (int i = 1; i <= maxDay; i++) {
			if (i == maxDay || i % 7 == 0) {
				System.out.printf("%3d \n", i);
			}
			else {
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