package im;

import java.util.Scanner;

public class _12712_파리퇴치3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt(); // 맵 크기
			int M = sc.nextInt(); // 분사력

			int[][] map = new int[N][N];
			// 파리배열 생성
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int max1 = Integer.MIN_VALUE; // 합계
			int sum = 0;
			
			// 십자 킬
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sum = 0;
					for (int i = 1; i < M; i++) {
						if (r + i < N && c + i < N && r - i >= 0 && c - i >= 0) {
							sum += map[r][c + i] + map[r][c - i] + map[r + i][c] + map[r - i][c];
						}
					}
					sum += map[r][c];
					max1 = Math.max(max1, sum);
				}
			}
			// 대각 킬
			int max2 = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sum = 0;
					for (int i = 1; i < M; i++) {
						if (r + i < N && c + i < N && r - i >= 0 && c - i >= 0) {
							sum += map[r+i][c + i] + map[r-i][c - i] + map[r + i][c-i] + map[r - i][c+i];
						}
					}
					sum += map[r][c];
					max2 = Math.max(max2, sum);
					sum = 0;
				}
			}
			System.out.printf("#%d ",tc);
			System.out.println(Math.max(max1, max2));

		}

	}

}
