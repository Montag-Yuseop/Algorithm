package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1940_주몽 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int max = N-1;
		int min = 0;
		
		// 배열에 입력
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		int cnt = 0;
		// 투포인터 생성
		while(min < max) {
			if(arr[min] + arr[max] > M) {
				max--;
				
			} else if(arr[min] + arr[max] < M) {
				min++;
				
			} else {
				cnt++;
				max--;
				min++;
			}
		}
		
		System.out.println(cnt);
	}
}
