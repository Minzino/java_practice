package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {

	public static void main(String[] args) throws IOException {
		//입력: 키보드로 두 수의 입력을 받는다.
		//출력: 화면에 두 수의 합을 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("두 수를 입력하세요.");
				
		String[] number = br.readLine().split(" ");		//두 수 입력, 공백 기준으로 나눠줌
		int first = Integer.parseInt(number[0]);
		int second = Integer.parseInt(number[1]);
		System.out.println("두 수의 합은 " + (first+second) + "입니다."); //두 수의 합 출력
	}

}
