package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15650_N과M3 {
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		// 종료조건
		if (idx == M) {
			for(int i = 0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}

		// 반복조건
		for(int i = 0; i < N; i++) {
//			if(visited[i]) continue;
			
			result[idx] = arr[i];
			
			perm(idx+1);
			
			
		}
		
	}

}
