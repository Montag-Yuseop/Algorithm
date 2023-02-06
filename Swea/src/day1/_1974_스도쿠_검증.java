package day1;

import java.util.Arrays;
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

						else if (arr1[r][c] == arr1[r][d]) {
							ans = 0;
							break;
						}
							
					}

				}
			}

			// 열 검사
			for (int c = 0; c < arr1.length; c++) {
				for (int r = 0; r < arr1.length; r++) {
					for (int d = 0; d < arr1.length; d++) {
						if (r == d)
							continue;

						else if (arr1[r][c] == arr1[d][c]) {
							ans = 0;
							break;
						}
							
					}

				}
			}

			// 3X3 검사

//			for (int i = 0; 3 * i < 3 * (i + 1); i++) { // 012, 345, 678
//				int[] arr = new int[9];
//				if (i == 3)
//					break;
//				for (int c = 0; c < 3; c++) {
//
//					arr[arr1[i][c] - 1]++;
//
//					if (arr[arr1[i][c] - 1] > 1) {
//						ans = 0;
//
//					}
//					System.out.println(Arrays.toString(arr));
//				}
//
//				for (int c = 3; c < 6; c++) {
//					arr[arr1[i][c] - 1]++;
//					if (arr[arr1[i][c] - 1] > 1) {
//						ans = 0;
//					}
//					System.out.println(Arrays.toString(arr));
//				}
//
//				for (int c = 6; c < 9; c++) {
//					arr[arr1[i][c] - 1]++;
//					if (arr[arr1[i][c] - 1] > 1) {
//						ans = 0;
//
//					}
//					System.out.println(Arrays.toString(arr));
//				}
//
//				System.out.println(Arrays.toString(arr));
//
//			}

			int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1, 0 };
			int[] dc = { -1, 0, 1, 0, 1, 1, 0, -1, -1 };

			for (int r = 1; r < 9; r += 3) {
				for (int c = 1; c < 9; c += 3) {
					int sum = 0; 
					
					for (int d = 0; d < 9; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						sum += arr1[nr][nc];
					}
					if(sum != 45) {
						ans = 0;
					}
					
				}

				

			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
