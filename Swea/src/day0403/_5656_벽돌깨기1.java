package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5656_벽돌깨기1 {
	
	static class Node {
		int r, c, w;

		public Node(int r, int c, int w) {
			this.r = r; // row
			this.c = c; // col
			this.w = w; // power
		}
	}
	
	static int N, W, H, ans;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // testCase
		
		// 1부터 T까지 돌기(testcase문)
		for(int tc = 1; tc < T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬의 수 입력
			W = Integer.parseInt(st.nextToken()); // 너비(c)
			H = Integer.parseInt(st.nextToken()); // 높이(r)
			ans = Integer.MAX_VALUE;
			
			// 초기 바뀌지 않을 배열을 만들자
			int[][] map = new int[H][W];
			
			// 배열을 생성
			for(int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			DFS(map, 0);
			System.out.println("#"+tc + " " +ans);
			
		}
		
	}


	private static void DFS(int[][] map, int cnt) {
		// 숫자 세기
		if(cnt == N) {			
			countBlock(map);
			return;
		}
		if(countBlock(map) == 0) {
			ans = 0;
			return;
		}
		
		for(int c = 0; c < W; c++) {
			// 배열을 복사(깊은 복사)
			int[][] newMap = new int[H][W];
			copy(map, newMap);
			// 맨 위의 블럭 찾기
			int r = 0;
			while(r < H && newMap[r][c] == 0) r++;
			if(r == H) continue;

			// 터뜨리기 - 새로 생성한 맵을 이용
			boom(newMap, r, c);
			
			// 중력작용
			down(newMap);
			
			// 재귀
			DFS(newMap, cnt+1);
				
		}
		
	}

	private static void down(int[][] newMap) {
		for(int c = 0; c < W; c++) {
			for(int r = H-1; r >= 0; r--) {
				if(newMap[r][c] == 0) {
					for(int nr = r-1; nr >= 0; nr--) {
						if(newMap[nr][c] != 0) {
							newMap[r][c] = newMap[nr][c];
							newMap[nr][c] = 0;
							break;
						}
					}
				}
			}
		}
		
	}

	private static void boom(int[][] newMap, int r, int c) {
		Queue<Node> q = new LinkedList<>();
		// 1보다 크면 큐에 넣기, 1은 그냥 혼자 터지기 때문
		if(newMap[r][c] > 1) q.offer(new Node(r, c, newMap[r][c]));
		newMap[r][c] = 0;

		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(int d = 0; d < 4; d++) {
				int power = curr.w;
				for(int i = 1; i < power; i++) {
					int nr = curr.r + dr[d]*i;
					int nc = curr.c + dc[d]*i;
					if(bc(nr, nc) && newMap[nr][nc] > 1) {
						q.offer(new Node(nr, nc, newMap[nr][nc]));
//						System.out.println("nr: " + nr +" nc: "+ nc);
					}
					if(bc(nr, nc)) {
						newMap[nr][nc] = 0;
					}

				}
			}
			
		}
	}

	private static boolean bc(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < H && nc < W;
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int r = 0; r < H; r++) {
			newMap[r] = map[r].clone();
		}
	}

	private static int countBlock(int[][] map) {
		int sum = 0;
		
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				if(map[r][c] != 0) sum++;
			}
		}
		ans = Math.min(ans, sum);
		return sum;
	}
}
