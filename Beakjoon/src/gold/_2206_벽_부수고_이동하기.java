package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206_벽_부수고_이동하기 {
	
	static class Node {
		int r, c, po, cnt;

		public Node(int r, int c, int po, int cnt) {
			this.r = r;
			this.c = c;
			this.po = po;
			this.cnt = cnt;
		}
	}
	
	static int[][] map;
	static boolean[][][] visited;
	static int N, M, ans;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		ans = Integer.MAX_VALUE;
		
		// 붙어있는 입력문을 쪼개서 입력
		for(int r = 0; r < N; r++) {
			String s = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = s.charAt(c)-'0';
			}
		}
		
		// 최단 경로를 찾아야 하기 때문에 bfs로 쭉쭉 넓혀가면서 찾자
		bfs();
		
		// 만일 ans값이 갱신되지 않았으면, 도착하지 못한 것이기 때문에 -1 출력
		// 아니면 갱신된 ans값으로 출력
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>(); // bfs 탐색용 q 생성
		// r = 0, c = 0, 벽 파괴 횟수 0, 이동 값 1의 node를 q에 삽입
		q.offer(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int nowR = cur.r;
			int nowC = cur.c;
			
			if(nowR == N-1 && nowC == M-1) {
				ans = cur.cnt;
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = nowR+dr[d];
				int nc = nowC+dc[d];
			
				// 벽을 부순 적이 없을 때?
				if(cur.po == 0) {
					// 벽을 부수고 갈 것인가?
					if(bc(nr,nc) && map[nr][nc] == 1 && !visited[nr][nc][cur.po+1]) {
						visited[nr][nc][cur.po+1] = true; // 벽 부순적 있으면 1번 vistied로 가자
						q.offer(new Node(nr, nc, cur.po+1, cur.cnt+1));
					}
					// 벽을 안부수고도 진행할 수 있는가?
					if(bc(nr,nc) && map[nr][nc] == 0 && !visited[nr][nc][0]) {
						// 0번 visited를 이용해서 방문처리 해보기
						visited[nr][nc][cur.po] = true;
						q.offer(new Node(nr, nc, cur.po, cur.cnt+1));
					}
				}
				
				// 벽을 한 번이라도 부순 적이 있을 때
				else if(cur.po == 1) {
					// 벽을 부쉈으니까 이제 더 이상은 못뿌순다
					// 이제 cur.po의 방문배열에서만 놀아야해
					if(bc(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][cur.po]) {
						visited[nr][nc][cur.po] = true;
						q.offer(new Node(nr, nc, cur.po, cur.cnt+1));
					}
				}
			}
		}
		
	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}
