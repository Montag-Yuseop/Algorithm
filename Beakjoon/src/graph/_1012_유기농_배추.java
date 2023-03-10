package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_유기농_배추 {

	static int N;
	static int M;
	static int[][] map; // 지도
	static boolean[][] visited; // 방문 배열
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 델타 배열 생성

	// Node라는 클래스 생성
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		// 인접해 있어야 한다
		// TestCase T
		// 가로 M, 세로 N, 배추 수 K

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			// 맵 생성
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;

			}

			int cnt = 0; // 배추애벌레 수

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {

					if (map[r][c] == 1 && !visited[r][c]) {
						cnt++;
						bfs(c, r);
					}

				}
			}
			System.out.println(cnt);
		}

	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = node.x + d[i][1];
				int ny = node.y + d[i][0];
				
				if(nx>=0 && ny>=0 && ny<N && nx<M && !visited[ny][nx] && map[ny][nx] == 1) {
					q.offer(new Node(nx, ny));
					visited[ny][nx] = true;
				}
				
			}
			
		}
		
		
	}

}
