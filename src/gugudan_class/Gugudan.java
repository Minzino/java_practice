package gugudan_class;

public class Gugudan {
	public static int[][] calculate(int times1, int times2) {
		int[][] result = new int[times1-1][times2]; // 2단부터 출력하기때문에 times1(행)에 -1을 해주었습니다.
		for (int i = 0; i < (times1-1); i++) {
			for (int j = 0; j < times2; j++) {
				result[i][j] = (i + 2) * (j + 1);
			}
		}
		return result;
	}

	public static void print(int[][] result) {
		for (int i = 0; i < result.length; i++) { //이차원배열.length는 행의 길이를 나타냄.
			for (int j = 0; j < result[i].length; j++) { //이차원배열[i]는 i행의 열의 길이를 나타냄.
				System.out.println( (i + 2) + " X " + (j + 1) + " = " +result[i][j]);
			}
		}

	}
		
}
