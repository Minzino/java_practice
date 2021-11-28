package gugudan;

import java.util.Scanner;

public class gugudan_array {

	/*
	 * 구구단 결과을 배열에 저장한 후 배열의 결과를 출력한다 
	 * 2단에서 9단까지 전체를 출력하는데 많은 중복 코드가 발생한다. 
	 * 반복문을 사용해 2단과 9단에 대한 중복을 제거한다.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] result = new int[9];
		int number = sc.nextInt();
		sc.close();
		for(int i = 0; i < result.length; i++) {
			result[i] = number*(i+1);
			System.out.println(number+"X"+(i+1)+"="+result[i]);
		}
		

	}

}
