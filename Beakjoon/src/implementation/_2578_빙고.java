package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class _2578_빙고 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[5][5];
		int bingo = 0;
		// 빙고판 생성
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		// 빙고판 하나씩 지우기
		for (int i = 0; i < 25; i++) {

			int three = 0; // 세 줄 확인

			int x = sc.nextInt(); // 사회자 숫자
			// 사회자 숫자 찾아서 0으로 바꿔버리기
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (arr[r][c] == x) {
						arr[r][c] = 0;
					}

				}
			}

			// 바꿨으면 배열 0 탐색 // 열탐색
			int sum = 0;
			for (int r = 0; r < 5; r++) {
				sum = 0;
				for (int c = 0; c < 5; c++) {
					sum += arr[r][c];
				}
				if (sum == 0) {
					three++;
				}
			}
			System.out.println(x + " 열 " + sum + " 몇빙고 " + three);

			// 행 탐색

			for (int c = 0; c < 5; c++) {
				sum = 0;
				for (int r = 0; r < 5; r++) {
					sum += arr[r][c];
				}
				if (sum == 0) {
					three++;
				}
			}
			System.out.println(x + " 행 " + sum + " 몇빙고 " + three);
			// 대각선 탐색1
			sum = 0;
			for (int r = 0; r < 5; r++) {
				for (int c = r; c < r + 1; c++) {
					sum += arr[r][c];
				}

			}
			if (sum == 0) {
				three++;
			}
			System.out.println(x + " 대각탐색1 " + sum + " 몇빙고 " + three);
			// 대각선 탐색2
			sum = 0;
			for (int r = 4; r >= 0; r--) {
				for (int c = 4 - r; c <= 4 - r; c++) {
					sum += arr[r][c];
				}
			}
			if (sum == 0) {
				three++;
			}

			System.out.println(x + " 대각탐색2 " + sum + " 몇빙고 " + three);
			if (three == 3) {
				bingo = x;
			}

		}
		System.out.println(bingo);

	}

}
