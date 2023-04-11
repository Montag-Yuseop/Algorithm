package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_피보나치_함수 {
	
	// 재귀 함수 count 문제, 하지만 시간초과, DP를 이용해야 한다
	static int x;
	static int dp[][] = new int[41][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			
			// dp
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			
			for(int i = 2; i < 41; i++) {
				dp[i][0] = dp[i-2][0]+dp[i-1][0];
				dp[i][1] = dp[i-2][1]+dp[i-1][1];
			}
			
			
			x = Integer.parseInt(br.readLine());
			
			
			System.out.println(dp[x][0]+" "+dp[x][1]);
			
		}
		
	}

}
