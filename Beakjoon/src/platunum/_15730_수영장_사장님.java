package platunum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15730_수영장_사장님 {
	// BFS, 너비 우선 탐색으로 진행할 예정
	// 필요한 변수들은 N, M, map, visited, cnt, dr, dc
	// 노드도 생성

	static class Node {
		int r, c, h;

		public Node(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	static int N, M, ans, max, small;
	static int[][] map;
	static boolean[][] visited, water;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// 제일 낮은 것 부터 채워야 하니까 맵을 만들면서 꼭 최소값을 찾아보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // r입니다
		M = Integer.parseInt(st.nextToken()); // c입니다

		// class 변수들 모두 초기화
		map = new int[N][M];
		visited = new boolean[N][M];
		ans = 0;
		small = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		water = new boolean[N][M];

		// 맵 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				small = Math.min(small, map[r][c]);
				max = Math.max(small, map[r][c]);
			}
		}

		bfs();

		System.out.println(ans);

	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		// 그냥 돌리면 안되고, 최대 높이만큼 반복해 줄 필요가 있을 듯
		
		// 이건 처음 시작값을 넣을 것
		while (true) {
			// 제일 작은 높이를 입력해야 하는데, 만약 제일 작은 높이가 모서리라면 사용하지 못한다
			boolean check = false; // 모서리라 못넣는 경우를 점검해줘야함

			// 일단 처음 넣어 줄 것
			while (!check) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (map[r][c] == small) { // 가장 최소값일 때
							if (r == N - 1 || c == M - 1 || r == 0 || c == 0)
								continue;
							visited[r][c] = true;
							q.offer(new Node(r, c, 0));
						}
					}
				}
				// 만약 큐에 아무것도 안들어가면
				// 다음 작은 값을 찾아야 함
				if (q.size() == 0) {
					check = false;
					findSmall();
				} else { // 뭐라도 들어갔으면 q뽑기 진행
					check = true;
				}
			}
			
			boolean isOk = true;
			while (!q.isEmpty()) {
				Node cur = q.poll(); // q에서 하나 뺴온다
				int nowR = cur.r; // 현재 노드의 r값
				int nowC = cur.c; // 현재 노드의 c값
				System.out.println(nowR + " " + nowC);

				// 4방 탐색 시작
				// 4방 탐색을 하면서 주변이 나보다 다 초과되는 경우에는 그냥 바꿔주면 돼, 단 모서리가 아닌 경우
				// 문제는 이어서 가는 경우야
				// 이어서 가는 경우 하나라도 모서리나 낮은 곳을 만나면 notOK처리 해버리고 바꿔주지 마
				// 아.. fucking 배열 하나 더 만들어, 가능 여부 체크... 가생이거나, 주변에 나보다 작은애가 있으면 false로 바꿔
				// 그래서 그 배열로 비교해
				
				for(int d = 0; d < 4; d++) {
					int nr = nowR + dr[d];
					int nc = nowC + dc[d];
					
					if(bc(nr, nc)) {
						if(!visited[nr][nc] && map[nr][nc] < map[nowR][nowC]) {
							isOk = false;
							break;
						} else if(map[nr][nc] == map[nowR][nowC]) {
							if(nr == 0 || nr == N-1 || nc == 0 || nc == M-1) {
								isOk = false;
							}
						}
					}
					
				}
				
				
				
			}

			// 반복 종료 조건
			int t = small;
			findSmall();
			if (t == small)
				break; // 더 이상 small 값이 갱신되지 않으면 종료
		}

	}

	// 다음 작은 값을 찾기
	private static void findSmall() {
		int temp = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > small) {
					temp = Math.min(temp, map[r][c]);
				}
			}
		}
		// temp값이 변경됐을 때만 small값을 temp값으로
		if (temp != Integer.MAX_VALUE)
			small = temp;
		// 아니면 그냥 변경하지 않고 넘기기
		else
			return;
	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}
}
