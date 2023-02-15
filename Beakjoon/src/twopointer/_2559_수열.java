package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559_수열 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 온도 수 > 배열크기
		int K = Integer.parseInt(st.nextToken()); // 측정 일 > 윈도우 크기
		
		st = new StringTokenizer(br.readLine()); // > 배열에 입력할 수 받기
		int[] arr = new int[N]; // 온도 배열 생성
		
		// 온도 배열에 값 넣기
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE; // 가장 큰 값 집어넣기
		
		// 탐색하기, 탐색은 i+K값이 N을 초과하면 안된다
		if(N == K) {
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				cnt += arr[i];
			}
			max = cnt;
		}
		
		for(int i = 0; i+K <= N; i++) {
			int cnt = 0; // 누계, 계속 초기화 되어야 한다
			// cnt에 누적값 적용
			for(int j = i; j < i+K; j++) {
				cnt += arr[j];
			}
			max = Math.max(max, cnt); // max에 최댓값 적용
		}
		
		System.out.println(max);
	}
	
}
