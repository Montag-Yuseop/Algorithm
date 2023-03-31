package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485_녹색옷입은애가_젤다지 {
	static class Node implements Comparable<Node>{
		int r, c, w;

		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
	
	static int N;
	static int[][] map, dist;
	static final int INF = Integer.MAX_VALUE;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			djikstra();
			System.out.println("Problem "+tc + ": " + dist[N-1][N-1]);
			tc++;
		}
		
	}

	private static void djikstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.offer(new Node(0, 0, dist[0][0]));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			for(int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(bc(nr, nc) && 
						dist[nr][nc] > dist[curr.r][curr.c] + map[nr][nc]) {
					dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
				
			}
			
		}
	}

	private static boolean bc(int nr, int nc) {
		return (nr >= 0 && nc >= 0 && nr < N && nc < N);
	}
}
