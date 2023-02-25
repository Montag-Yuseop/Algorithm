package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[N+1][M+1];
			
			for(int i = 1; i<M+1; i++) {
				dp[1][i] = i;
			}
			
			for(int r = 2; r < N+1; r++) {
				for(int c = 2; c<M+1; c++) {
					if(r == c) {
						dp[r][c] = 1;
					} else if(r > c) {
						dp[r][c] = 0;
					} else {
						for(int i = 1; i<=c-r+1; i++) {
							dp[r][c] += dp[r-1][c-i]; 
						}
					}
				}
				
			}
			
			System.out.println(dp[N][M]);
		}
	}

}
