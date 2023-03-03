package graph;

import java.util.Scanner;

public class _2606_바이러스 {
	static boolean[] visit;
	static int[][] computer;
	static int N, M, cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		computer = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			computer[r][c] = 1;
			computer[c][r] = 1;
		}
		cnt = 0;

		for (int i = 1; i < N + 1; i++) {
			if (computer[1][i] == 1) {
				dfs(i);
			}
		}

		System.out.println(cnt);
		sc.close();

	}

	private static void dfs(int num) {
		visit[num] = true;

		for (int i = 1; i < N + 1; i++) {
			if (!visit[i] && computer[num][i] == 1) {
				dfs(i);
				cnt++;
			}
		}

	}

}
