package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2178_미로탐색_bfs {
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // Row
		int M = Integer.parseInt(st.nextToken()); // Column
		int[][] map = new int[N][M];
		
		for(int r = 0; r<N; r++) {
			String s = br.readLine();
			for(int c = 0; c<M; c++) {
				map[r][c] = s.charAt(c)-'0';
			}
		}

		
		
	}
}
