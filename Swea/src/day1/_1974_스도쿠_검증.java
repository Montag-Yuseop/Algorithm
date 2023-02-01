package day1;

import java.util.Scanner;

public class _1974_스도쿠_검증 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			
			int[][] arr1 = new int[9][9]; // 스도쿠 맵 2차원 배열
			int ans = 0;
			
			for(int r=0; r<arr1.length; r++) {
				for(int c=0; c<arr1.length; c++) {
					arr1[r][c] = sc.nextInt();
				}
			}
			// 행 탐색
			for(int r=0; r<arr1.length; r++) {
				for(int c=0; c<arr1.length; c++) {
					for(int i=c+1; i<arr1.length; i++) {
						if(arr1[r][c] == arr1[r][i]) {
							ans += 1;
						} else {
							ans += 0;
						}
					}
				}
			}
			
			// 열 탐색
			for(int c=0; c<arr1.length; c++) {
				for(int r=0; r<arr1.length; r++) {
					for(int i=r+1; i<arr1.length; i++) {
						if(arr1[r][c] == arr1[i][c]) {
							ans += 1;
						} else {
							ans += 0;
						}
					}
				}
			}
			
			// 3*3탐색
			for(int i=0; i<3; i++) {
				for(int r=i*3; r<r+3; r++) {
					for(int c=r*3; c<c+3; c++) {
						
					}
				}
			}
			
			
			
			if(ans == 0) {
				ans = 1;
			} else {
				ans = 0;
			}
			System.out.println(ans);
		}
		
		
	}
}
