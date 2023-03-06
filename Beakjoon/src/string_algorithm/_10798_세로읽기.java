package string_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10798_세로읽기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

			StringBuilder sb = new StringBuilder();
			Character [][] board = new Character[5][15];
			
			for(int r = 0; r<5; r++) {
				String s = br.readLine();
				for(int c = 0; c<s.length(); c++) {
					board[r][c] = s.charAt(c);
				}
			}
			
			for(int c = 0; c<15; c++) {
				for(int r = 0; r<5; r++) {
					if(board[r][c] == null) {
						continue;
					} else {
						sb.append(board[r][c]);
					}
				}
			}
			
			System.out.println(sb);

	}
}
