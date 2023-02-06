package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _스도쿠2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc=1; tc<=T; tc++) {
			int[][] game = new int[9][9];
			
			for (int r=0; r<9; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<9; c++) {
					game[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean overlap = false;
			
//			for (int c=0; c<9; c++) {
//				for (int i=0; i<9; i++) {
//					for (int j=0; j<9; j++) {
//						if (i != j && game[i][c] == game[j][c]) {
//							overlap = true;
//						}
//					}
//				}
//			}
//			
//			for (int r=0; r<9; r++) {
//				for (int i=0; i<9; i++) {
//					for (int j=0; j<9; j++) {
//						if (i != j && game[r][i] == game[r][j]) {
//							overlap = true;
//						}
//					}
//				}
//			}
			
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					for (int k=0; k<3; k++) {
						for (int l=0; l<3; l++) {
							if (!(i==k && j==l) && game[i][j] == game[k][l]) {
								
								overlap = true;
								
							}
						}
					}
				}
			}
				
			int ans = overlap ? 0 : 1;			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}