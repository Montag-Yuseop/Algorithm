package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15650_N과M2 {
	public static int N; // 1~N까지의 수
	public static int M; // 중복 없이 M개를 고른 수열
	public static int[] arr;
	public static boolean[] visit; // 방문배열
	public static int[] result; // 방문배열
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 숫자
		M = Integer.parseInt(st.nextToken()); // M개 고르기
		
		arr = new int[N];
		result = new int[M];
		visit = new boolean[N]; // 방문배열 초기화
		
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		
		perm(0);
		System.out.println(sb);
		
	}

	private static void perm(int idx) {
		if(idx == M) {
			
			boolean check = true;
			
			for(int i = 0; i < M-1; i++) {
				for(int j = i; j < M; j++) {
					if(result[i] > result[j]) {
						check = false;
						break;
					}
				}
			}
			
			if(check) {
				for(int i = 0; i<M; i++) {
					sb.append(result[i]+" ");
				}
				sb.append("\n");
				return;
			} else {
				return;
			}
			
		}
		
		for(int i = 0; i<N; i++) {
			if(visit[i]) continue;
			
			
			result[idx] = arr[i];
			visit[i] = true;
			
			perm(idx+1);
			visit[i] = false;
			
		}
		
	}
}