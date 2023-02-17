package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1209_sum {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc < 11; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			// 배열 입력
			for(int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c<100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = Integer.MIN_VALUE;
			
			for(int r = 0; r < 100; r++) {
				int cnt = 0;
				for(int c =0; c < 100; c++) {
					cnt += map[r][c]; 
				}
				sum = Math.max(sum, cnt);
			}
			
			for(int c = 0; c < 100; c++) {
				int cnt = 0;
				for(int r =0; r < 100; r++) {
					cnt += map[r][c]; 
				}
				sum = Math.max(sum, cnt);
			}
			
			for(int r = 0; r<100; r++) {
				int cnt = 0;
				for(int c = r; c<r+1; c++) {
					cnt += map[r][c];
				}
				sum = Math.max(sum, cnt);
			}
			
			for(int r = 0; r<100; r++) {
				int cnt = 0;
				for(int c = 99-r; c<100-r; c++) {
					cnt += map[r][c];
				}
				sum = Math.max(sum, cnt);
			}
		
			System.out.println("#"+tc+" "+sum);
		}
		
	}

}
