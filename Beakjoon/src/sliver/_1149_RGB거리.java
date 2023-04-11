package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 집의 수
		int[][] rgb = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		// RGB 배열 생성 및 비용 입력
		for(int r = 1; r < N+1; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++) {
				rgb[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][0] = rgb[1][0];
		dp[1][1] = rgb[1][1];
		dp[1][2] = rgb[1][2];
		
		for(int i = 2; i <N+1; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + rgb[i][2];
			
		}
		
		
		
		System.out.println(Math.min(dp[N][1], Math.min(dp[N][0], dp[N][2])));
		
	}

}
