package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562_나이트의_이동_BFS {
	// 체스판의 목적지까지 이동하는 최소 횟수를 구하는 문제
	static class Node {
		int r, c, cnt;
		
		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int[][] del = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, 
			{ 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } }; // 체스말이 이동하는 경로 델타배열
	static boolean[][] visited;
	static int l, targetR, targetC, ans, startR, startC;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		for (int tc = 1; tc < T + 1; tc++) {
			l = Integer.parseInt(br.readLine());

			visited = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			targetR = Integer.parseInt(st.nextToken());
			targetC = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;

			bfs();
			
			System.out.println(ans);


		}

	}
	
	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(startR, startC, 0));
		visited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			Node x = q.poll();
//			System.out.println(x.r +" "+x.c+" "+x.cnt);
			if(x.r == targetR && x.c == targetC) {
				ans = x.cnt;
				break;
			}
			
			for(int d = 0; d<8; d++) {
				int nr = x.r+del[d][0];
				int nc = x.c+del[d][1];
				if(bc(nr, nc) && !visited[nr][nc]) {
					
					q.offer(new Node(nr, nc, x.cnt+1));
					visited[nr][nc] = true;
				}	
			}
			
		}
		
		
	}

	
	public static boolean bc(int row, int col) {
		if(row>=0 && row<l && col>=0 && col<l) return true;
		
		return false;
	}

}


