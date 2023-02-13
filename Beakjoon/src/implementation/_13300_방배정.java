package implementation;

import java.util.Scanner;

public class _13300_방배정 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 배정 인원 수

		int[][] arr = new int[2][6];
		int room = 0;

		// 학년 정보 담기
		for (int i = 0; i < N; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b - 1]++;

		}

		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 6; c++) {

				if (arr[r][c] % K == 0) {
					room += arr[r][c] / K;
				} else {
					room += arr[r][c] / K + 1;
				}

			}
		}

		System.out.println(room);
		sc.close();
	}

}
