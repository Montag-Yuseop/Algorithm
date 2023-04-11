package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600_말이되고픈_원숭이 {
	static class Node {
		int r, c, h, cnt;

		public Node(int r, int c, int h, int cnt) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;                             
		}
		
	}
	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visited;
	// 4방 탐색 배열
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0,};
	// 말처럼 움직이는 배열
	static int[] horseR = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] horseC = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		ans = Integer.MAX_VALUE;
		visited = new boolean[H][W][32];
		
		// 지도 배열 생성
		for(int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int cr = curr.r;
			int cc = curr.c;
			if(cr == H-1 && cc == W-1) {
				ans = Math.min(ans, curr.cnt);
				break;
			}
			
			if(curr.h < K) {
				for(int d = 0; d < 8; d++) {
					int nr = cr + horseR[d];
					int nc = cc + horseC[d];
					if(bc(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][curr.h+1]) {
						visited[nr][nc][curr.h+1] = true;
						q.offer(new Node(nr, nc, curr.h+1, curr.cnt+1));
						
					}
				}
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(bc(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][curr.h]) {
					visited[nr][nc][curr.h] = true;
					q.offer(new Node(nr, nc, curr.h, curr.cnt+1));
				}
			}
		}
	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < H && nc < W;
	}
}