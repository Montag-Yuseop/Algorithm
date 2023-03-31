package day0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7733_치즈도둑 {
	// 요정은 N일까지 N번 정도의 맛있는 치즈를 먹어치운다
	// 가장 치즈 덩어리가 많을 때 고르세요~

	static int N, maxCheese;
	static int[][] cheese;
	static boolean[][] visited;
	static int temp;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // testCase
		
		for(int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			maxCheese = 1; // 덩어리를 세는 변수
			cheese = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					cheese[r][c] = Integer.parseInt(st.nextToken()); // 치즈 배열 생성
				}
			}
			
			for(int i = 1; i < 101; i++) {
				visited = new boolean[N][N];
				temp = 0;
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(!visited[r][c] && cheese[r][c] > i) { 
							visited[r][c] = true;
							dfs(r, c, i);
							temp++;
						}
					}
				}
				if(temp == 0) break;
				maxCheese = Math.max(maxCheese, temp);
				
			}
			System.out.println("#"+tc + " " + maxCheese);
		}
	}

	private static void dfs(int r, int c, int day) { // i보다 큰녀석들만 덩어리를 세 주면 될듯

		for(int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(bc(nr, nc) && !visited[nr][nc] && cheese[nr][nc] > day) { // 경계고, 방문 안했고, day보다 크면
				visited[nr][nc] = true;
				dfs(nr, nc, day);
			}
		}
	}

	private static boolean bc(int nr, int nc) {
		
		if(nr>=0 && nc >= 0 && nr <N && nc < N) return true;		

		return false;
	}
		

}
