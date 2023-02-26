package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5356_의석이의_세로로말해요 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<T+1; tc++) {
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
			
			System.out.print("#"+tc+" ");
			System.out.println(sb);
		}
		
	}

}
