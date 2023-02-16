package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2527_직사각형 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] square = new int[4][2];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 2; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			String s = "";
			
			// 사각형 1
			int x1 = square[0][0];
			int x2 = square[1][0];
			int y1 = square[0][1];
			int y2 = square[1][1];
			
			// 사각형 2
			int x3 = square[2][0];
			int x4 = square[3][0];
			int y3 = square[2][1];
			int y4 = square[3][1];

			// 위치 비교하기
			if(x1>x4 || x3 > x2 || y1 > y4 || y2 < y3) { // 범위 밖 구하기
				s = "d";
			} else if((x1 == x4 && y4 == y1) || (x1 == x4 && y2 == y3) || (x2 == x3 && y4 == y1) || (x2 == x3 && y2 == y3)) {  
				s = "c";
			} else if((x1 == x4 && y2 != y3) || (x2 == x3 && y2 != y3) || (y2 == y3 && x2 != x3) || (y1 == y4 && x2 != x3)) {
				s =  "b";
			} else {
				s = "a";
			}
			
			System.out.println(s);
		}

	}
}
