package day2;

import java.util.Scanner;

public class _2001_파리퇴치 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] fly = new int[N][N];
			
			// 최댓값 비교
			int max = 0;
			
			// 파리 배열 생성
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					fly[r][c] = sc.nextInt();
				}
			}

			// 파리 배열 탐색
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0; // sum을 초기화
					for (int r = 0; r < M; r++) { // 파리채 크기만큼 행+
						for (int c = 0; c < M; c++) { // 파리채 크기만큼 열+
							sum += fly[i + r][j + c]; // 열 M만큼 돌고 다시 r더한만큼 또 M만큼돌고 r도 M만큼 더 커짐
						}
					}
					
					// 최댓값 초기화
					max = Math.max(max, sum);
				}

			}

			System.out.printf("#%d %d\n", tc, max);

		}

		sc.close();

	}
}
