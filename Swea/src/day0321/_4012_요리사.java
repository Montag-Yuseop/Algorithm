package day0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4012_요리사 {
	static int N, ans;
	static int[][] arr;
	static boolean[] check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			arr = new int[N][N];
			check = new boolean[N];
			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			powerset(0, 0);

			System.out.println("#"+tc+ " "+ ans);

		}

	}
	private static int mat() {
		int p1 = 0;
		int p2 = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (check[r] && check[c]) {
					p1 += arr[r][c];
				} else if (!check[r] && !check[c]) {
					p2 += arr[r][c];
				}
			}
		}

		return Math.abs(p1 - p2);
	}

	private static void powerset(int idx, int cnt) {
		if (cnt == N / 2) {
			ans = Math.min(ans, mat());
			return;
		}
		
		for(int i = idx; i < N; i++) {
			check[i] = true;
			powerset(i+1, cnt+1);
			check[i] = false;
		}

	}


}
