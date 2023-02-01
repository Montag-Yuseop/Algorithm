package string_algorithm;

import java.util.Scanner;

public class _2675 {

	public static void main(String[] args) {

		// 문자열 S를 입력
		// 각 문자 R번 반복해 출력
		
		Scanner sc = new Scanner(System.in);
		
		// Testcase 입력
		int T = sc.nextInt();

		for(int i=0; i<T; i++) {
			// 반복 횟수 입력
			int R = sc.nextInt();
			
			// 문자 입력
			String S = sc.next();
			
			for(int j=0; j<S.length(); j++) {
				for(int k=0; k<R; k++) {
					char a = S.charAt(j);
					System.out.print(a);
				}
				
			}
			System.out.println("");
			
		}
		

	}

}
