package math_algorithm;

import java.util.Scanner;

public class _2839_sugardelivery {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 입력받는 설탕의 kg수	
	
		if(N == 4 || N == 7) {
			System.out.println(-1);
		} else if(N%5 == 0) {
			System.out.println(N/5);
		} else if(N%5 == 1 || N%5 == 3) {
			System.out.println(N/5+1);
		} else if(N%5 == 2 || N%5 == 4) {
			System.out.println((N/5)+2);
		}
		
		
	}
}
//실패 8, 11 ,13, 16, 19 등 을 포함 못함		
//int a = 0; // 5kg 봉지 수
//int b = 0; // 3kg 봉지 수
//int x = 0; // 나누고 남은 그람 수
//int sum = 0; // a + b
//
//
//if((N/5)%3 == 0) {
//	a = N/5;
//	x = N-5*a;
//	b = x/3;
//	
//	sum = a+b;
//	
//} else if((N/5)%3 != 0) {
//	if(N%3 == 0) {
//		b = N/3;
//		sum = b;
//	} else if() {
//		
//	}
//}
