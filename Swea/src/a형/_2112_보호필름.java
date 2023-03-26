package a형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2112_보호필름 {
	static int D;
	static int W;
	static int K;
	static int ans;
	static int[][] map;
	static int[][] use;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // testCase

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken()); // 두께(열 길이)
			W = Integer.parseInt(st.nextToken()); // 가로 길이(행 길이)
			K = Integer.parseInt(st.nextToken()); // 합격 기준 K
			ans = Integer.MAX_VALUE;
			map = new int[D][W];
			use = new int[D][W];

			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = use[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			

			if (check()) {
				sb.append("#" + tc + " " + 0 + "\n");
			} else {
				change(0, 0);
				sb.append("#" + tc + " " + ans + "\n");
			}

		}
		System.out.println(sb);

	}

	private static boolean check() { // 해당 열의 막이 K개인지 체크하는 메서드
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			int temp = use[0][c];
			boolean flag = false;
			for (int r = 1; r < D; r++) {
				if (temp == use[r][c]) {
					cnt++;
				} else {
					temp = use[r][c];
					cnt = 1;
				}

				if (cnt == K) {
					flag = true;
					break;
				}

			}

			if (!flag) {
				return false;
			}

		}

		return true;

	}

	private static void change(int idx, int num) {
		if (num >= ans)
			return;

		if (idx == D) {
			if (check()) {
				ans = Math.min(ans, num);
			}
			return;
		}

		change(idx + 1, num); // 그대로

		for (int i = 0; i < W; i++) { // 전부 0 주입
			use[idx][i] = 0;
		}
		change(idx + 1, num + 1);

		for (int i = 0; i < W; i++) { // 전부 1 주입
			use[idx][i] = 1;
		}
		change(idx + 1, num + 1);

		for (int i = 0; i < W; i++) { // 원상복구
			use[idx][i] = map[idx][i];
		}

	}

}
