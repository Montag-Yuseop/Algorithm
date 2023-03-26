package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663_NQueen {
	static int N;
	static int[] map;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		map = new int[N];
		
		dfs(0);
		System.out.println(ans);
		
	}

	private static void dfs(int cnt) {
		if(cnt == N) { // 해당 배열 줄이 마지막 줄이면 정답 1개 늘리기
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) { // N개의 줄 검사
			map[cnt] = i;
			if(possible(cnt)) {
				dfs(cnt+1);
			}
		}
		
		
	}

	private static boolean possible(int cnt) {
		for(int i = 0; i<cnt; i++) {
			if(map[i] == map[cnt] || Math.abs(cnt-i) == Math.abs(map[cnt]-map[i])) {
				return false;
			} 
		}
		return true;
	}

}
