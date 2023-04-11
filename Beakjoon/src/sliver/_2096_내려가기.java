package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2096_내려가기 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];
		
		// 맵 생성
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 상단은 어차피 고정
		for(int i = 0; i < N; i++) {
			dp[0][i] = map[0][i];
		}
		
		// 이전 값을 활용해서 최대 최소 뽑아오기 
		for(int r = 1; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 맨 왼쪽, 맨 오른쪽, 중간에 껴있을 떄로 나눠서 계산
				if(c == 0) {
					dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c+1]) + map[r][c];
				} else if(c == N-1) {
					dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c-1]) + map[r][c];
				} else {
					dp[r][c] = Math.max(dp[r-1][c], Math.max(dp[r-1][c-1], dp[r-1][c+1]) ) + map[r][c];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			max = Math.max(dp[N-1][i], max);
		}
		
		// 상단은 어차피 고정
				for(int i = 0; i < N; i++) {
					dp[0][i] = map[0][i];
				}
				
				// 이전 값을 활용해서 최대 최소 뽑아오기 
				for(int r = 1; r < N; r++) {
					for(int c = 0; c < N; c++) {
						// 맨 왼쪽, 맨 오른쪽, 중간에 껴있을 떄로 나눠서 계산
						if(c == 0) {
							dp[r][c] = Math.min(dp[r-1][c], dp[r-1][c+1]) + map[r][c];
						} else if(c == N-1) {
							dp[r][c] = Math.min(dp[r-1][c], dp[r-1][c-1]) + map[r][c];
						} else {
							dp[r][c] = Math.min(dp[r-1][c], Math.min(dp[r-1][c-1], dp[r-1][c+1]) ) + map[r][c];
						}
					}
				}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			min = Math.min(dp[N-1][i], min);
		}
		
		System.out.println(max+" "+min);
	}
}
