package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_N과M1 {
	public static int N; // 1~N까지의 수
	public static int M; // 중복 없이 M개를 고른 수열
	public static boolean[] visit; // 
	public static int[] arr; // 값을 저장할 배열
	public static StringBuilder sb = new StringBuilder(); // 값 출력
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		visit = new boolean[M];
		arr = new int[M];
		
	}
}
