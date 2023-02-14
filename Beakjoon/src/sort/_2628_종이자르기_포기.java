package sort;

import java.util.Arrays;
import java.util.Scanner;

public class _2628_종이자르기_포기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[][] arr = new int[b][a];
		
		int n = sc.nextInt();
				
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 행 자르기, ex 0 3은 3행 기준으로 자르기
			if(x == 0) {
				for(int r = y; r < b; r++) {
					for(int c = 0; c < a; c++) {
						arr[r][c] ++;
					}
				}
			} 
			// 열 짜르기. ex 1 3은 3열 기준으로 반 자르기
			else {
				for(int r = 0; r<b; r++) {
					for(int c = y; c < a; c++) {
						arr[r][c] ++;
					}
				}
				
			}
			
			
		}
		
		// 이제 범위 구하기(탐색하다가 다른 녀석 만나면 정지
		for(int i = 0; i < b; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		int max = 0;
		
		for(int r = 0; r < b; r++) {
			for(int c = 0; c < a; c ++) {
				int cnt = 1;
				for(int d = c+1; d < a; d++) {
					int ct = 1;
					if(arr[r][c] == arr[r][d]) {
						cnt++;
					} else {
						for(int q = r+1; q < b; q++) {
							if(arr[r][d] != arr[q][d]) {
								break;
							}
							ct++;
						}
					}
					max = Math.max(max, cnt*ct);
					System.out.println(cnt + " " + ct);
					
				}
				
			}
		}
		
		System.out.println(max);


		
	}
	
}
