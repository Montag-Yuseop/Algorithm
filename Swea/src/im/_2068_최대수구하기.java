package im;

import java.util.Scanner;

public class _2068_최대수구하기 {
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			int max = Integer.MIN_VALUE;
			for(int i=0; i<10; i++) {
				int a = sc.nextInt();
				max = Math.max(max, a);
			}
			
			System.out.printf("#%d %d\n",tc, max);
		}
		
	}
}
