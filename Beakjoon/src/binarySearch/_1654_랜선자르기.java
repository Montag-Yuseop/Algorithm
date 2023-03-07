package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1654_랜선자르기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 랜선 보유
		int N = Integer.parseInt(st.nextToken()); // 만들어야 할 개수
		
		int[] arr = new int[K];
		
		int longLan = Integer.MIN_VALUE;
		int start = 1;
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			longLan = Math.max(longLan, arr[i]);
		}
		
		System.out.println(longLan);
		
	}
}
