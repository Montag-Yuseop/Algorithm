package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1012_유기농_배추 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		// 인접해 있어야 한다
		// TestCase T
		// 가로 M, 세로 N, 배추 수 K
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		
	}

}
