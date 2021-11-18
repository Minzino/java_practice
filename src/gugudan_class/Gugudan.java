package gugudan_class;

import java.util.Scanner;

public class Gugudan {
	public static int[][] calculate(int times1, int times2) {
		int[][] result = new int[times1-1][times2]; //2단부터 시작이기때문에 times1에 -1을 해줬습니다. 
		for (int i = 0; i < (times1-1); i++) {
			for (int j = 0; j < times2; j++) {
				result[i][j] = (i + 2) * (j + 1);
			}
		}
		return result;
	}

	public static void print(int[][] result) {
		for (int i = 0; i < result.length; i++) { //이차원배열에서 괄호없을때는 행의 길이를 나타냄
			for (int j = 0; j < result[i].length; j++) { //[i]가 있을때는 각 행에서 열의 길이를 나타냄
				System.out.println( (i + 2) + " X " + (j + 1) + " = " +result[i][j]);
			}
		}

	}
		
}
