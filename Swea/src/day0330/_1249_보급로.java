package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _1249_보급로 {
	
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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			
			// 맵 생성
			for(int r = 0; r < N; r++) {
				String s = br.readLine();
				for(int c = 0; c <N; c++) {
					map[r][c] = s.charAt(c)-'0';
				}
			}
			
			
			dijkstra();
			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}
			System.out.println("#" + tc + " " + dist[N-1][N-1]);
			

		}
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int currR = curNode.r;
			int currC = curNode.c;
			int cost = curNode.w;
			
			for(int i = 0; i < 4; i++) {
				int nextR = currR + dr[i];
				int nextC = currC + dc[i];
				
				if(bc(nextR, nextC) && 
						dist[nextR][nextC] > dist[currR][currC] + map[nextR][nextC]) {
					dist[nextR][nextC] = dist[currR][currC] + map[nextR][nextC];
					pq.offer(new Node(nextR, nextC, dist[nextR][nextC]));
				}
				
			}
			
			
		}
		
	}

	private static boolean bc(int nextR, int nextC) {
		return (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N);
	}
}
