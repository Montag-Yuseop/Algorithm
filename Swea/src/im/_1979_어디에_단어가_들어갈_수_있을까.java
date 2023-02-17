package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1979_어디에_단어가_들어갈_수_있을까 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] quiz = new int[N][N];

			int cnt = 0; // 들어갈 수 있는 수

			// 퀴즈 판 생성 N*N
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					quiz[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 가로탐색
			for (int r = 0; r < N; r++) {
				int check = 0;
				for (int c = 0; c < N; c++) {
					if (quiz[r][c] == 1) {
						check++;
					} else {
						if (check == K) {
							cnt++;
							check = 0;
						} else {
							check = 0;
						}
					}
				}
				if (check == K) {
					cnt++;
				}
			}

			// 가로탐색
			for (int c = 0; c < N; c++) {
				int check = 0;
				for (int r = 0; r < N; r++) {
					if (quiz[r][c] == 1) {
						check++;
					} else {
						if (check == K) {
							cnt++;
							check = 0;
						} else {
							check = 0;
						}
					}
				}
				if (check == K) {
					cnt++;
				}
			}

			System.out.println("#" + tc + " " + cnt);

		}

	}

}
