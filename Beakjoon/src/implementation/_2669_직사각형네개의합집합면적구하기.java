package implementation;

import java.util.Scanner;

public class _2669_직사각형네개의합집합면적구하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[100][100];

		int cnt = 0;

		for (int tc = 1; tc <= 4; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					if (arr[r][c] == 0) {
						cnt++;
					}

					arr[r][c] = 1;

				}
			}

		}

		System.out.println(cnt);
	}

}
