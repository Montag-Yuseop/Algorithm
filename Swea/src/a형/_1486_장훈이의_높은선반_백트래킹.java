package a형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1486_장훈이의_높은선반_백트래킹 {

	public static int N;
	public static int B;
	public static int[] arr;
	public static int sum;
	public static int ans;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 점원 수
			B = Integer.parseInt(st.nextToken()); // 선반 높이
			arr = new int[N];
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		
			powerSet(0, 0);
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void powerSet(int idx, int sum) {
		if(sum >= B) {
			ans = Math.min(ans, sum - B);
			return;
		}
		
		if(idx == N) {
			return;
		}
		
		
		visited[idx] = true;
		powerSet(idx+1, sum+arr[idx]);
		visited[idx] = false;
		powerSet(idx+1, sum);
		
		
	}
}