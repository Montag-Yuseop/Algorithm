package day1;

import java.util.Scanner;

public class _1204_최빈수_구하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			int[] arr = new int[101];
			int testcase = sc.nextInt();
			
			
			for(int i=0; i<1000; i++) {
				arr[sc.nextInt()]++;
			}
			
			int max=0;
			int cnt=0;
			
			
			for(int i=1; i<arr.length; i++) {
				max = Math.max(max, arr[i]);
				if(max == arr[i]) {
					cnt = Math.max(cnt, i);
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
		}
		sc.close();
		
	}

}
