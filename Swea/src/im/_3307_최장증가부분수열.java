package im;

import java.util.Scanner;

public class _3307_최장증가부분수열 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		//T는 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			
			// 수열 길이 N입력
//			int N = sc.nextInt();
//
//			// 배열 생성
//			int[] arr = new int[N];
//			int cnt = 0; // cnt는 답 출력용
//			
//			
//			// 배열에 값 입력
//			for (int i = 0; i < N; i++) {
//				arr[i] = sc.nextInt();
//			}
//						
//			for (int r = 0; r < N; r++) {
//				int temp = arr[r]; // 배열의 r번째 인덱스를 temp값에 입력, 큰 수인지 아닌지 비교용
//				int res = 0; // res는 반복문 내부에서 cnt와 비교해서 더 큰 수를 도출하려고 사용, 계속 초기화
//				for (int c = r; c < N; c++) { // arr[r]번째 인덱스를 기준으로 arr[r]보다 오른쪽에 있는 수들과 크기 비교하는 반복문
//					if (temp <= arr[c]) { // 만일 temp(초기값은 arr[r])보다 arr[c]가 크면 temp값은 arr[c]로 변경되고, res++
//						temp = arr[c];
//						res++;
//						cnt = Math.max(res, cnt); // cnt에 더 큰 값(최장길이를 입력)
//					}
//
//				}
//
//			}
			
			int cnt = 1;
			int N = sc.nextInt();
			int[] arr = new int[N];			
			int[] dp = new int[N];
			
			// 배열에 값 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
 			dp[0] = 1;
 			for(int i=0; i<N; i++) {
 				dp[i] = 1;
 				for(int j=0; j<i; j++) {
 					if(arr[j] < arr[i] && dp[j]>= dp[i]) {
 						dp[i] = dp[j]+1;
 	 				}
 				}
 				cnt = Math.max(cnt, dp[i]);
 			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();

	}
}
