package day1;

import java.util.Scanner;

public class _1284_수도요금경쟁 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();// Test Case
		
		for(int tc=1; tc<T+1; tc++) {
			int P = sc.nextInt(); // A사 1L당 요금
			int Q = sc.nextInt(); // B사 기본 요금
			int R = sc.nextInt(); // B사의 요금 기준
			int S = sc.nextInt(); // B사 추가 1L당 요금
			int W = sc.nextInt(); // 사용량
			
			int a_price = P * W;
			
			int b_price = 0;
			
			if(W <= R) {
				b_price = Q;
			} else {
				b_price = Q + ((W-R)*S);
			}
			
			int price = Math.min(a_price, b_price);
						
			System.out.printf("#%d %d", tc, price);
			System.out.println();
		}
		
		sc.close();
		

	}

}
