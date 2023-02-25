package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461_파도반수열 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<N; tc++) {
			int x = Integer.parseInt(br.readLine());
			
			sb.append(padovan(x)+"\n");
		}
		
		System.out.println(sb);
	}
	
	public static long padovan(int x) {
		long[] arr = new long[100];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		
		if(x>=3) {
			for(int i = 3; i<arr.length; i++) {
				arr[i] = arr[i-3] + arr[i-2];
			}
		} 
		return arr[x-1];
		
	}

}
