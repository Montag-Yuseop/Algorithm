package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_가장긴_증가하는수열 {
	// 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램
	public static void main(String[] args) throws IOException{
		// A의 크기 N
		// 수열 A
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N
		int[] A = new int[N]; // A 배열
		int[] dp = new int[N]; // 증가 수열 생성
		int cnt = Integer.MIN_VALUE; // 정답 출력
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// A 배열 생성
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) { // A의 N-1번 인덱스까지 순회하면서 dp생성
			dp[i] = 1; // 기본으로 1 부여
			for(int j = 0; j < i; j++) { // j는 처음부터 i까지 순회
				if(A[i] > A[j] && dp[i]<=dp[j]) { // A의 i인덱스가 j보다 크고, j의 길이가 i보다 크면, j+1(순회하면서 제일 긴 부분 +1)
					dp[i] = dp[j] + 1;
				}
			}
			cnt = Math.max(cnt, dp[i]);
			
		}
		System.out.println(cnt);
	}
	
}
