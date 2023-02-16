package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2527_직사각형 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		outer: for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] square = new int[4][2];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int x1 = square[0][0];
			int x2 = square[1][0];
			int y1 = square[0][1];
			int y2 = square[1][1];

			int x3 = square[2][0];
			int x4 = square[3][0];
			int y3 = square[2][1];
			int y4 = square[3][1];

			// 점은?
			if (x1 == x4) {
				if (y2 == y3 || y4 == y1) {
					System.out.println("c");
					continue outer;
				} else if (y3 < y2 || y4 > y1) {
					System.out.println("b");
					continue outer;
				}
			} else if (x2 == x3) {
				if (y2 == y3 || y4 == y1) {
					System.out.println("c");
					continue outer;
				} else if (y3 < y2 || y4 > y1) {
					System.out.println("b");
					continue outer;
				}
				
			} else if (x4 <= x1 && x2 >= x3) {
				if (y4 >= y1 && y3 <= y2) {
					System.out.println("a");
					continue outer;
				} else if (y2 >= y3 && y1 <= y4) {
					System.out.println("a");
					continue outer;
				}

			} else if (x2 >= x3 && x1 <= x4) {
				if (y4 >= y1 && y3 <= y2) {
					System.out.println("a");
					continue outer;
				} else if (y2 >= y3 && y1 <= y4) {
					System.out.println("a");
					continue outer;
				}
			} else {
				System.out.println("d");
			}

		}

	}
}
