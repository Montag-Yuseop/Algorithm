package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2491_수열 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int su[] = new int[N];

		
		// 배열에 수 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < su.length; i ++) {
			su[i] = Integer.parseInt(st.nextToken());
		}
		int max = 1;
		int cnt = 1;
		
		// 증가
		for(int i = 0; i < su.length-1; i++) {
			if(su[i] <= su[i+1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			
			max = Math.max(cnt, max);
		}
		
		// 감소
		int ct = 1;
		for(int i = 0; i < su.length-1; i++) {
			if(su[i] >= su[i+1]) {
				ct++;
			} else {
				ct = 1;
			}
			
			max = Math.max(max, ct);
		}
		
		System.out.println(max);
	}

}
