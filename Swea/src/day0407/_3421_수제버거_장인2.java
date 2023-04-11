package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3421_수제버거_장인2 {
	static int N, M, cnt;
	static boolean[] visited; // 방문처리 배열 - 중복 제거
	static int[][] nope; // i와 j가 맞는지 안맞는지 확인하기
	static int[] map, result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		// 1 ~ T까지
		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cnt = 0; // 정답 출력
			N = Integer.parseInt(st.nextToken()); // 가지 수
			M = Integer.parseInt(st.nextToken()); // 안 맞는 재료 수
			nope = new int[N + 1][N + 1];
			visited = new boolean[N];
			map = new int[N];

			for (int i = 0; i < N; i++) {
				map[i] = i + 1;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				nope[x][y] = 1;
				nope[y][x] = 1;
			}

			// 부분집합 수 구하기
			powerSet(0);

			System.out.println("#" + tc + " " + cnt);
		}

	}

	private static void powerSet(int num) {
		// 종료 조건

		if (num == N) {
			int idx = 0;
			result = new int[N];
			boolean ok = true;

			for (int i = 0; i < N; i++) {
				if (visited[i])
					result[idx++] = map[i];
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (nope[result[i]][result[j]] == 1) {
						ok = false;
						return;
					}
				}
			}

			if (ok)
				cnt++;
			return;
		}

		// 반복 조건
		visited[num] = true;
		int check = 0;

		powerSet(num + 1);

		visited[num] = false;
		powerSet(num + 1);

	}
}