package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _2775 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=0; tc<T; tc++) {
		
			int k = Integer.parseInt(bf.readLine());
			int n = Integer.parseInt(bf.readLine());
			
			int[][] S = new int[15][15];
			
			for(int i=1; i<15; i++) {
				S[i][1] = 1;
				S[0][i] = i;
			}
			
			for(int r=1; r<15; r++) {
				for(int c=2; c<15; c++) {
					S[r][c] = S[r][c-1] + S[r-1][c];
					
				}
			}
			
			System.out.println(S[k][n]);
			
		}
		
		
		
		

	}

}
