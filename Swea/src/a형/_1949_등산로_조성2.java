package a형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1949_등산로_조성2 {

	static int N, K; // N = 사이즈 / K = 최대 공사 가능 깊이
	static int ans; // 정답 출력할 변수
	static int[][] map; // 지도 생성
	static boolean[][][] visited; // 방문배열 생성
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		// 1부터 T까지 돌기
		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 맵 크기 입력
			K = Integer.parseInt(st.nextToken()); // 공사 깊이 입력
			map = new int[N][N]; // 맵 크기 입력
			visited = new boolean[N][N][2]; // 방문배열 크기 입력
			ans = Integer.MIN_VALUE; // 정답 출력할 값을 최소값으로 초기화
			// -> 가장 긴 등산로를 출력해야하기 때문

			// 맵 생성
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs 시작, 인자값으로는 일단 거리(cnt값)만?
			// 어차피 가장 높은곳은 처음만 찾기 때문에..
			// 애초에 인자 값으로 넘겨주면 좋을 것 같다

			// 가장 높은 값을 일단 찾자
			int high = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					high = Math.max(high, map[r][c]);
				}
			}
			// 이렇게 하면 가장 높은 high 값을 가져 올 것이다
			// 그럼 이제 무엇을 할까? 맵을 탐색하면서 최고 높은 값인 경우
			// dfs로 인자 값을 넘겨주며 진행하자

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == high) {
						// 일단 방문처리 한 번 해주고
						visited[r][c][0] = true;
						dfs(r, c, 1, false);
						// 방문배열 초기화해주고
						visited[r][c][0] = false;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);

		}

	}

	private static void dfs(int r, int c, int cnt, boolean check) {
		// 종료 조건은? 어차피 충족 안하면 알아서 돌아가지 않나?
		ans = Math.max(ans, cnt);
		boolean ok = check;

		// 사방 탐색을 진행하며 다음 재귀로 이동
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 경계값 체크, 방문 안했을 때
			// 공사 진행 안한 상태. 0의 세계
			if (bc(nr, nc) && !visited[nr][nc][0] && !ok) {
				// 해당 지점을 K개의 갈래로 나눠서 다시 재귀로 진입해야한다
				// 공사를 진행했을 때, 안 했을 때 > 그럼 방문 배열도 3차원

				if (map[r][c] > map[nr][nc]) {
					visited[nr][nc][0] = true;
					dfs(nr, nc, cnt + 1, false);
					visited[nr][nc][0] = false;

				}

				// 1이라도 깎은 경우
				for (int i = 1; i < K + 1; i++) {
					// 0(공사 진행 안하고 가는 상태) ~ K(공사 진행한 높이)
					// map[nr][nc]의 높이를 계속해서 까내려가면서 진행하자
					// 진행하면 다시 맵을 원복시켜야 한다

					// 나머지는 공사 한 번이라도 한거니까 1에서 방문처리해
					// 방문처리하고
					if (!visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						// 깎고
						map[nr][nc] -= i;

						// 진입하고 진입조건을 달아줘야지
						if (map[r][c] > map[nr][nc]) {
							dfs(nr, nc, cnt + 1, true);
						}

						// 원복하고
						map[nr][nc] += i;
						visited[nr][nc][1] = false;
					}

				}

			}

			// 공사 진행 한 상태, 1의 세계도 진행
			if (bc(nr, nc) && !visited[nr][nc][1] && ok) {
				// 공사 진행한 세계니까 그냥 사방탐색 해버리면 오케이
				visited[nr][nc][1] = true;
				if (map[r][c] > map[nr][nc]) {
					dfs(nr, nc, cnt + 1, true);
				}

				visited[nr][nc][1] = false;

			}

		}

	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
