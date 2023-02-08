package string_algorithm;

import java.util.Scanner;

public class _2999_비밀이메일 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		int N = s.length();

		int R = (int) Math.sqrt(N);

		if (N <= 3) {
			R = 1;
		}
		
		// 없어도 작동함
//		if (N % R != 0 && N > 3) {
//			R--;
//		}

		int C = N / R;
		while (R * C != N) {
			R--;
			C = N / R;
		}

		char[][] arr = new char[R][C];
		int idx = 0;

		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				arr[r][c] = s.charAt(idx++);
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(arr[r][c]);
			}
		}
		sc.close();
	}
}