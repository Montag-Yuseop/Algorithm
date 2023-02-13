package implementation;

import java.util.Scanner;

public class _10163_색종이 {
	public static void main(String[] args) {

		int[][] paper = new int[1002][1002];

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i < N + 1; i++) {
			int x = sc.nextInt(); // x좌표
			int y = sc.nextInt(); // y좌표
			int a = sc.nextInt(); // x좌표 이동
			int b = sc.nextInt(); // y좌표 이동

			// 종이 숫자 덮어씌우기
			for (int r = x; r < x + a; r++) {
				for (int c = y; c < y + b; c++) {
					paper[r][c] = i;
				}
			}

		}
		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for (int r = 0; r < 1002; r++) {
				for (int c = 0; c < 1002; c++) {

					if (paper[r][c] == i) {
						cnt++;
					}

				}
			}

			System.out.println(cnt);

		}

	}

}
