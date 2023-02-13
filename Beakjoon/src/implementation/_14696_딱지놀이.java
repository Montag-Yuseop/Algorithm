package implementation;

import java.util.Scanner;

public class _14696_딱지놀이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int tc = 0; tc < N; tc++) {

			int[][] arr = new int[2][4]; // 딱지

			// 두 명 딱지 합 생성
			for (int i = 0; i < 2; i++) {
				int a = sc.nextInt();
				for (int j = 0; j < a; j++) {
					int b = sc.nextInt();
					arr[i][b - 1]++;
				}
			}
			int draw = 0;
			for (int i = 3; i >= 0; i--) {
				if (arr[0][i] > arr[1][i]) {
					System.out.println("A");
					break;
				} else if (arr[0][i] < arr[1][i]) {
					System.out.println("B");
					break;
				} else {
					draw++;
				}

			}
			if (draw == 4) {
				System.out.println("D");
			}

		}
	}

}
