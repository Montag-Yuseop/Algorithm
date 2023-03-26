package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_토마토 {
	static class Node {
		int r, c, h;

		public Node(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}
		
	}
	
	static int N, M, H, ans;
	static int[][][] tomato;
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 1, -1, 0, 0, 0, 0 }; // 우 좌 하 상 업 다운
	static int[] dh = { 0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M][H];
		ans = 0;
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < M; c++) {
					tomato[r][c][h] = Integer.parseInt(st.nextToken()); 
				}
			}
		}
		
		System.out.println(ripe());
	}

	private static int check() {
		
		int maxDay = Integer.MIN_VALUE;
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(tomato[r][c][h] == 0) {
						return -1;
					} else {
						maxDay = Math.max(maxDay, tomato[r][c][h]);
					}
				}
			}	
		}
		
		
		return maxDay-1;
	}

	private static int ripe() {
		Queue<Node> q = new LinkedList<>();
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(tomato[r][c][h] == 1) {
						q.offer(new Node(r, c, h));
					}
				}
			}	
		}
		
	
		// 시작부터 다 1이면 0 그대로 출력하기 위해 return
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			
				for(int d = 0; d < 6; d++) {
					int nr = curNode.r + dr[d];
					int nc = curNode.c + dc[d];
					int nh = curNode.h + dh[d];
					
					if(bc(nr, nc, nh) && tomato[nr][nc][nh] == 0) {
						tomato[nr][nc][nh] = tomato[curNode.r][curNode.c][curNode.h] + 1;
						q.offer(new Node(nr, nc, nh));
					}
				}
			
		}
		
		return check();
		
	}

	private static boolean bc(int nr, int nc, int nh) {
		if(nr>=0 && nc>=0 && nr<N && nc<M && nh>=0 && nh < H) return true;
		
		return false;
	}
}

