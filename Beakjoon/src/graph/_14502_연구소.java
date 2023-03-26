package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502_연구소 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int N, M, ans;
	static int[][] map;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 }; // 우 좌 하 상

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// dfs로 벽을 세우고, 바이러스를 bfs 탐색한다.
		// 인자로는 무엇을 넘겨야 하는가? 행, 열, 벽 cnt?

		wall(0);
		System.out.println(ans);
	}

	// 벽을 쌓는 dfs
	private static void wall(int cnt) {
		if (cnt > 3)
			return; // 벽이 3개 이상 됐으면 return

		// 벽이 3개면 바이러스 퍼뜨리기
		if (cnt == 3) {
			virus();
			return;
		}

		// 위의 조건에 걸리지 않으면 벽 쌓기 진행
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					wall(cnt+1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	// 바이러스를 퍼뜨리는 bfs, 바이러스 퍼트리고나서 0의 개수(안전지역)수를 카운트 해줘야함
	// 여기서는 복사본을 써야 함
	private static void virus() {
		Queue<Node> q = new LinkedList<>();
		int[][] copy = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(copy[r][c] == 2) {
					q.offer(new Node(r, c));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curNode.r + dr[d];
				int nc = curNode.c + dc[d];
				
				// 2로 바꾸기
				if(bc(nr, nc) && copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					q.offer(new Node(nr, nc));
				}
				
			}
			
		}
		
		countSafe(copy);
		
	}

	private static void countSafe(int[][] copy) {
		int cnt = 0;
		
		// 탐색
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(copy[r][c] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}

	private static boolean bc(int nr, int nc) {
		if(nr>=0 && nc>=0 && nr<N && nc<M) return true;
		
		return false;
	}
}
