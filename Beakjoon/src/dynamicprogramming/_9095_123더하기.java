package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_123더하기 {
	public static void main(String[] args) throws IOException {
		// 1, 2, 3의 합으로 n 나타내는 가지 수
		// 1은 1, 2는 2, 3은 3
		// 4는 1의 가지수, 2의 가지수, 3의 가지수
		// DP(N) = DP(N-3) + DP(N-2) + DP(N-1)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // tc 수
		int[] dp = new int[12]; // 0은 사용 안함, N은 1부터 11까지의 수
		
		// DP초기화
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i<12; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; 
		} 
		
		
		for(int tc = 1; tc<T+1; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(dp[N]);
			
		}
		
		
	}

}
