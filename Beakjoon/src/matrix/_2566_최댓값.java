package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _2566_최댓값 {

	public static void main(String[] args) throws IOException {

//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());

		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[9][9];
		int max = Integer.MIN_VALUE;
		int a = 0; // r값 저장
		int b = 0; // c값 저장

		// 배열 생성
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
//				arr[r][c] = Integer.parseInt(st.nextToken());
				arr[r][c] = sc.nextInt();
				max = Math.max(max, arr[r][c]);

				if (max == arr[r][c]) {
					a = r;
					b = c;
				}

			}
		}

		System.out.println(max);
		System.out.printf("%d %d", a + 1, b + 1);

	}

}
