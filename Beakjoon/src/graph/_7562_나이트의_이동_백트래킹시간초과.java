package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7562_나이트의_이동_백트래킹시간초과 {
	// 체스판의 목적지까지 이동하는 최소 횟수를 구하는 문제

	static int[][] del = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, 
			{ 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } }; // 체스말이 이동하는 경로 델타배열
	static int[][] map;
	static int[][] copy;
	static boolean[][] visited;
	static int l, targetR, targetC, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testCase

		for (int tc = 1; tc < T + 1; tc++) {
			l = Integer.parseInt(br.readLine());

			copy = map = new int[l][l];
			visited = new boolean[l][l];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			targetR = Integer.parseInt(st.nextToken());
			targetC = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;

			move(startR, startC, 0);
			System.out.println(ans);


		}

	}

	private static void move(int startR, int startC, int cnt) {
		
		if(cnt >= ans) return;
		
		if((startR == targetR) && (startC == targetC)) {
			
			ans = Math.min(ans, cnt);
			return;
		} 
		
//		visited[startR][startC] = true;
		
		for (int d = 0; d < 8; d++) {
			if (startR + del[d][0] >= 0 && startC + del[d][1] >= 0 && startR + del[d][0] < l && startC + del[d][1] < l
					&& !visited[startR + del[d][0]][startC + del[d][1]]) {
				visited[startR +del[d][0]][startC + del[d][1]] = true;
				System.out.println(cnt);
				move(startR + del[d][0], startC + del[d][1], cnt + 1);
				visited[startR +del[d][0]][startC + del[d][1]] = false;
			}
		}
	}

}
