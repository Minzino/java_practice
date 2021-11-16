package gugudan_class;

import java.util.Scanner;

public class Gugudan {
	public static int[][] calculate(int times1, int times2) {
		int[][] result = new int[times1-1][times2];
		for (int i = 0; i < (times1-1); i++) {
			for (int j = 0; j < times2; j++) {
				result[i][j] = (i + 2) * (j + 1);
			}
		}
		return result;
	}

	public static void print(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.println( (i + 2) + " X " + (j + 1) + " = " +result[i][j]);
			}
		}

	}
		
}
