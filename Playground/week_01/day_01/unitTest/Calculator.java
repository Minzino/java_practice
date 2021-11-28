package week_01.day_01.unitTest;

//Production Code
public class Calculator {
	int add(int i, int j) {
		return i + j;
	}

	int subtract(int i, int j) {
		return i - j;
	}

	int multiply(int i, int j) {
		return i * j;
	}

	int divide(int i, int j) {
		return i / j;
	}
//Test Code
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println(cal.add(3, 4));
		System.out.println(cal.subtract(5, 4));
		System.out.println(cal.multiply(2, 6));
		System.out.println(cal.divide(8, 4));
	}
}
