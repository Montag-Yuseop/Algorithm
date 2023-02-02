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
			
			int[] arr2 = new int[9];
			
			// 행 검사
			for(int r=0; r<arr1.length; r++) {
				for(int c=0; c<arr1.length; c++) {
				}
			}
			
		}
	}
}
