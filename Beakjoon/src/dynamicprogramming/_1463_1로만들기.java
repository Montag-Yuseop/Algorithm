package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class _1463_1로만들기 {
	public static void main(String[] args) {
		// 정수 X에 사용할 수 있는 연산
		// 1. X가 3으로 나누어 떨어지면 3으로 나눈다
		// 2. X가 2로 나누어 떨어지면 2로 나눈다.
		// 3. 1을 뺀다.
		
		// DP(N) = MIN(DP(N/2)+DP(N/3), DP(N-1))
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 입력받는 숫자
		
		int[] arr = new int[1000001];
		
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i = 4; i<arr.length; i++) {
			int x = Integer.MAX_VALUE;
			int y = Integer.MAX_VALUE;
			
			if(i%3 == 0) {
				x = Math.min(arr[i/3] + 1, arr[i-1] + 1);
			}
			if(i%2 == 0) {
				y = Math.min(arr[i/2] + 1,arr[i-1] + 1);
			}
				
			arr[i] = Math.min(x, Math.min(y, arr[i-1]+1));
			
		}
		
		System.out.println(arr[N]);
		
	}
}
