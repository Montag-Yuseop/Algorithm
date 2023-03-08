package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _2667_단지번호붙이기 {

	// 정사각형 모양의 지도, N * N
	// 1은 집이 있는 곳, 0은 집이 없는 곳
	// 단지에 번호를 붙이자

	static int danji; // 몇 번째 단지인지?
	static int[][] map; // 구역
	static boolean[][] visited; // 방문 배열
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 탐색할 델타배열
	static int N;
	static int cnt;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 지도 사이즈

		map = new int[N][N]; // 지도 크기 부여
		visited = new boolean[N][N]; // 방문배열 크기 부여

		// 지도 생성
		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}

		danji = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && visited[r][c] == false) {
					danji++;
					cnt = 1;
					dfs(r, c);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(danji);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		

	}

	private static void dfs(int x, int y) { // 좌표값 x, y 넘겨주기
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nr = x + d[i][0];
			int nc = y + d[i][1];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 1 && visited[nr][nc] == false) {
				cnt++;
				dfs(nr, nc);
			}

		}
		

	}

}
