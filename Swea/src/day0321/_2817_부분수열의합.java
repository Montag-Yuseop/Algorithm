package day0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2817_부분수열의합 {
	static int N, K, cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			powerset(0, 0);
			
			System.out.println("#"+tc + " "+cnt);
			
		}

	}

	private static void powerset(int i, int sum) {
		if(i == N) {
			if(sum == K) cnt++;
			return;
		} else {
			powerset(i+1, sum);
			
			sum += arr[i];
			powerset(i+1, sum);
			
		}
		
		
		
		
		
	}

}
