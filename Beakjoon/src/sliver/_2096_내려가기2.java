package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2096_내려가기2 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] maxDp = new int[3];
		int[] minDp = new int[3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 무적권 세 개의 숫자씩 주어진다
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				maxDp[0] = num1;
				maxDp[1] = num2;
				maxDp[2] = num3;
				
				minDp[0] = num1;
				minDp[1] = num2;
				minDp[2] = num3;
			} else {
				int temp0 = maxDp[0];
				int temp2 = maxDp[2];
				
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + num1;
				maxDp[2] = Math.max(maxDp[2], maxDp[1]) + num3;
				maxDp[1] = Math.max(temp0, Math.max(maxDp[1], temp2)) + num2;
				
				temp0 = minDp[0];
				temp2 = minDp[2];
				
				minDp[0] = Math.min(minDp[0], minDp[1]) + num1;
				minDp[2] = Math.min(minDp[2], minDp[1]) + num3;
				minDp[1] = Math.min(temp0, Math.min(minDp[1], temp2)) + num2;
			}
			
		}
		
		int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
		int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));
		
		System.out.println(max +" "+min);
	}
}
