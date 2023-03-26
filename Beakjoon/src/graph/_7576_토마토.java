package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_토마토 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, M, ans;
	static int[][] tomato;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 }; // 우 좌 하 상
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N= Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		ans = 0;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				tomato[r][c] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		System.out.println(ripe());
	}

	private static int check() {
		
		int maxDay = Integer.MIN_VALUE;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(tomato[r][c] == 0) {
					return -1;
				} else {
					maxDay = Math.max(maxDay, tomato[r][c]);
				}
			}
		}
		
		return maxDay-1;
	}

	private static int ripe() {
		Queue<Node> q = new LinkedList<>();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(tomato[r][c] == 1) {
					q.offer(new Node(r, c));
				}
			}
		}
	
		// 시작부터 다 1이면 0 그대로 출력하기 위해 return
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curNode.r + dr[d];
				int nc = curNode.c + dc[d];
				
				if(bc(nr, nc) && tomato[nr][nc] == 0) {
					tomato[nr][nc] = tomato[curNode.r][curNode.c] + 1;
					q.offer(new Node(nr, nc));
				}
			}
		}
		
		return check();
		
	}

	private static boolean bc(int nr, int nc) {
		if(nr>=0 && nc>=0 && nr<N && nc<M) return true;
		
		return false;
	}
}

