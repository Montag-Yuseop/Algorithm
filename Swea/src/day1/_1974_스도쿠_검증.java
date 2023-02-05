package day1;

import java.util.Scanner;

public class _1974_스도쿠_검증 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		

		for (int tc = 1; tc < T + 1; tc++) {
			int ans = 1;
			int[][] arr1 = new int[9][9]; // 스도쿠 맵 2차원 배열

			for (int r = 0; r < arr1.length; r++) {
				for (int c = 0; c < arr1.length; c++) {
					arr1[r][c] = sc.nextInt();
				}
			}

			// 행 검사
			for (int r = 0; r < arr1.length; r++) {
				for (int c = 0; c < arr1.length; c++) {
					for (int d = 0; d < arr1.length; d++) {
						if (c == d)
							continue;

						else if (arr1[r][c] == arr1[r][d])
							ans = 0;
							break;
					}

				}
			}

			// 열검사
			for (int c = 0; c < arr1.length; c++) {
				for (int r = 0; r < arr1.length; r++) {
					for (int d = 0; d < arr1.length; d++) {
						if (r == d)
							continue;

						else if (arr1[r][c] == arr1[d][c])
							ans = 0;
							break;
					}

				}
			}
			
			// 3X3 검사
			for(int i=1; i<4; i++) {
				for(int r=0; r < r+3; r=2*i+1) {
					for(int c=0; c < c+3; c=2*i+1) {
						
					}
				}
			}
			
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
