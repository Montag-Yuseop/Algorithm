package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로탐색_bfs {
	static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우 델타배열
	static int N;
	static int M;
	static int cnt; // 숫자 체크
	static int[][] map = new int[N][M];
	
	public static class Point {
		Point(int r, int c, int d){
			row = r;
			col = c;
			dist = d;
		}
		int row;
		int col;
		int dist;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // Row
		M = Integer.parseInt(st.nextToken()); // Column
		map = new int[N][M];
		cnt = 0;
		
		// 2차원 미로 배열 생성
		for(int r = 0; r<N; r++) {
			String s = br.readLine();
			for(int c = 0; c<M; c++) {
				map[r][c] = s.charAt(c)-'0';
			}
		}
		
		System.out.println(bfs(N-1, M-1));
		
	}

	private static int bfs(int dRow, int dCol) {
		boolean[][] visit = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		visit[0][0] = true;
		q.add(new Point(0, 0, 1));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.row == dRow && cur.col == dCol)
				return cur.dist;
			
			for(int i = 0; i<4; i++) {
				int nr = cur.row+d[i][0];
				int nc = cur.col+d[i][1];
				if(nr<0 || nr >N-1 || nc < 0 || nc>M-1) continue;
				if(visit[nr][nc] || map[nr][nc] == 0) continue;
				visit[nr][nc] = true;
				q.add(new Point(nr, nc, cur.dist+1));
				
			}
		}
		return -1;
	}
}
