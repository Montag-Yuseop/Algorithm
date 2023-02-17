package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1954_달팽이_숫자 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] dr = { 0, 1, 0, -1 }; // 우하좌상
		int[] dc = { 1, 0, -1, 0 }; // 우하좌상
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < T + 1; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] dal = new int[N + 2][N + 2];

			// 테두리 음수처리
			for (int i = 0; i < N + 2; i++) {
				dal[0][i] = -1;
				dal[i][0] = -1;
				dal[N + 1][i] = -1;
				dal[i][N + 1] = -1;
			}
			int cnt = 1;
			int dir = 0; // 방향
			int row = 1;
			int col = 1;

			while (true) {

				if (dal[row + dr[dir]][col + dc[dir]] != 0) {
					dir = (dir + 1) % 4;
				}

				dal[row][col] = cnt++;
				row = row + dr[dir];
				col = col + dc[dir];

				if (cnt > N * N)
					break;
			}
			
			sb.append("#"+tc+"\n");
			for (int r = 1; r < N + 1; r++) {
				for(int c = 1; c<N+1; c++) {
					sb.append(dal[r][c]+" ");
				}
				sb.append("\n");
			}
			

		}
		System.out.println(sb);
	}

}
