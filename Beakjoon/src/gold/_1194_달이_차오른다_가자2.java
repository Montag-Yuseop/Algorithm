package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194_달이_차오른다_가자2 {

	static class Node {
		int r, c, cnt, keya, keyb, keyc, keyd, keye, keyf;

		public Node(int r, int c, int cnt, int keya, int keyb, int keyc, int keyd, int keye, int keyf) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.keya = keya;
			this.keyb = keyb;
			this.keyc = keyc;
			this.keyd = keyd;
			this.keye = keye;
			this.keyf = keyf;
		}

	}

	static int N, M; // 가로와 세로의 크기
	static int ans; // 정답
	static char[][] map;
	static boolean[][][][][][][][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		// 방문 배열은 열쇠를 먹을 때 마다 초기화 해 줄거야
		// 열쇠는 a ~ f까지 총 6개가 있고, 열쇠를 안먹은 세상이 있으니까 0~6까지 사용할 예정
		// 열쇠를 하나 먹을 때 마다 초기화된 배열을 사용할 예정
		visited = new boolean[N][M][2][2][2][2][2][2];

		// ans는 최댓값으로 사용할게 > 최소를 찾아야 하니까
		ans = Integer.MAX_VALUE;

		// 인벤토리를 생성해서 먹은 키를 저장할 예정입니다만
		// 0 ~ 6번 세상 중에서 열쇠를 먹었으면 해당 인덱스에 저장해주자

		// 배열을 입력
		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = s.charAt(c);
			}
		}

		// 가장 빠르게 답을 찾아야 하는 문제기 때문에 bfs가 어울려보여
		bfs();

		// 만일 찾지 못하면 -1, 찾으면 ans를 출력
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		// 시작 위치를 찾아서 노드에 추가합시다
		outer: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == '0') {
					visited[r][c][0][0][0][0][0][0] = true;
					q.offer(new Node(r, c, 1, 0, 0, 0, 0, 0, 0)); // r, c, 이동횟수, 키 보유
					break outer;
				}
			}
		}

		out: while (!q.isEmpty()) {
			// 저장된 노드를 빼오고요
			Node curr = q.poll();
			int nowR = curr.r;
			int nowC = curr.c;

			// 탈출 지점이 아니라면 4방 탐색을 진행하세요
			for (int d = 0; d < 4; d++) {
				int nr = nowR + dr[d];
				int nc = nowC + dc[d];

				// nr, nc가 맵을 넘어가지 않고, 방문한 적 없을 때
				if (bc(nr, nc)) {
					// 다음 위치가 .이나 0이면? 그냥 노드에 넣고 이동 가능
					if (map[nr][nc] == '.' || map[nr][nc] == '0') {
						if (!visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}

					}

					else if (findKey(map[nr][nc])) { // 만약 키를 찾았으면?
						// 일단 그거 현재 세계 + 1 의 인벤토리에 저장해
						// 인벤토리에 없을때만 저장해야겠어
						if (map[nr][nc] == 'a' && curr.keya == 0 && !visited[nr][nc][curr.keya
								+ 1][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya
									+ 1][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya + 1, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'b' && curr.keyb == 0 && !visited[nr][nc][curr.keya][curr.keyb
								+ 1][curr.keyc][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb
									+ 1][curr.keyc][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb + 1, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'c' && curr.keyc == 0 && !visited[nr][nc][curr.keya][curr.keyb][curr.keyc
								+ 1][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc
									+ 1][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc + 1, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'd' && curr.keyd == 0
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd
										+ 1][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd
									+ 1][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd + 1,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'e' && curr.keye == 0
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye
										+ 1][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye
									+ 1][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye + 1, curr.keyf));
						}
						if (map[nr][nc] == 'f' && curr.keyf == 0
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf
										+ 1]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf
									+ 1] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf + 1));
						}

						if (map[nr][nc] == 'a' && curr.keya == 1
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'b' && curr.keyb == 1
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'c' && curr.keyc == 1 && !visited[nr][nc][curr.keya][curr.keyb][curr.keyc
								][curr.keyd][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc
									][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'd' && curr.keyd == 1
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd
										][curr.keye][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd
									][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'e' && curr.keye == 1
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye
										][curr.keyf]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye
									][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
						if (map[nr][nc] == 'f' && curr.keyf == 1
								&& !visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf
										]) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf
									] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}
					}

					// 그리고 세계 하나씩 늘려서 큐에 집어넣어
					// 방문처리도 잊지말고
					else if (map[nr][nc] == '1') {
						// 중요한 탈출 지점 확인을 안했네요
						// 만약 다음 지점이 1이면 그냥 cnt+1해주고 나갑시다
						ans = curr.cnt;
						break out;
					} else {
						// 모든 경우 다 해줬으니까 이제 문일 때만 남았겠죠?
						// 문일 때 내 인벤토리를 뒤져서 같은 알파벳의 문이라면 이동합시다
						if (openDoor(nr, nc, curr.keya, curr.keyb, curr.keyc, curr.keyd, curr.keye, curr.keyf)) {
							visited[nr][nc][curr.keya][curr.keyb][curr.keyc][curr.keyd][curr.keye][curr.keyf] = true;
							q.offer(new Node(nr, nc, curr.cnt + 1, curr.keya, curr.keyb, curr.keyc, curr.keyd,
									curr.keye, curr.keyf));
						}

					}

				}
			}
		}

	}

	private static boolean openDoor(int nr, int nc, int a, int b, int c, int d, int e, int f) {
		// 해당위치의 대문자를 찾고
		// 인벤토리를 뒤져보고
		// 맞으면 열고 갑시다

		if (!visited[nr][nc][a][b][c][d][e][f]) {
			if (map[nr][nc] == 'A' && a == 1) {
				return true;
			} else if (map[nr][nc] == 'B' && b == 1) {
				return true;
			} else if (map[nr][nc] == 'C' && c == 1) {
				return true;
			} else if (map[nr][nc] == 'D' && d == 1) {
				return true;
			} else if (map[nr][nc] == 'E' && e == 1) {
				return true;
			} else if (map[nr][nc] == 'F' && f == 1) {
				return true;
			}
		}

		return false;
	}

	private static boolean findKey(char what) {

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (what == 'a' || what == 'b' || what == 'c' || what == 'd' || what == 'e' || what == 'f') {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
