package platunum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15730_수영장_사장님2 {
	// BFS로 진행할 예정
	// 필요한 변수들은 N, M, map, visited, cnt, dr, dc
	// 노드도 생성

	static class Node implements Comparable<Node>{
		int r, c, h;

		public Node(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public int compareTo(Node o) {
			return this.h - o.h;
		}
	}

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static PriorityQueue<Node> pq  = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		// 제일 낮은 것 부터 채워야 하니까 맵을 만들면서 꼭 최소값을 찾아보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 0 <= r < N
		M = Integer.parseInt(st.nextToken()); // 0 <= c < M

		// class 변수들 모두 초기화
		map = new int[N][M];
		visited = new boolean[N][M];
		ans = 0;
		
		// 맵 입력
		// 외곽부터 돌면서 가장 낮은 외곽을 찾고, 거기서부터 시작하는 것
		// 낮은 외곽부터 채울 수 있는 경우 방문처리하고 pq에 다시 넣는 형식으로 진행
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				// 외곽의 경우를 pq에 넣고 시작한다
				if(r == 0 || c == 0 || r == N-1 || c == M-1) {
					// 방문처리
					visited[r][c] = true;
					// pq에 삽입
					pq.offer(new Node(r, c, map[r][c]));
				}
			}
		}

		bfs();
		
		System.out.println(ans);
	}

	private static void bfs() {
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int nowR = cur.r;
			int nowC = cur.c;
			int nowH = cur.h;
			
			for(int d = 0; d < 4; d++) {
				int nr = nowR+dr[d];
				int nc = nowC+dc[d];
				
				if(bc(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(nowH > map[nr][nc]) ans += (nowH-map[nr][nc]);
					pq.offer(new Node(nr, nc, Math.max(nowH, map[nr][nc])));
				}
				
			}
			
		}
		
		
		
	}

	private static boolean bc(int nr, int nc) {
		return nr>=0 && nc >= 0 && nr < N && nc < M;
	}
}