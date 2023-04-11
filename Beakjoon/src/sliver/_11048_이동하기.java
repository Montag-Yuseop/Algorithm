package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11048_이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M]; // map
		int[][] dp = new int[N][M]; // dp배열
		
		// 초기 배열 생성
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 이동은 우, 하, 우하 셋 뿐이다
		// 맨 윗줄과 맨 왼쪽줄은 위에서부터 내려온 것만 더해서 간다
		
		dp[0][0] = map[0][0];
		
		// 맨 오른쪽 줄은 미리 싹 값 넣기
		for(int i = 1; i < N; i++ ) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		
		//맨 윗줄도
		for(int i = 1; i < M; i++ ) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < M; c++) {
				dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]) + map[r][c];
			}
		}
		
		System.out.println(dp[N-1][M-1]);
		
	}
}
