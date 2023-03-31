package day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7465_창용마을_무리의_개수 {
	
	static int N, M, cnt;
	static int[] p;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 사람 수
			M = Integer.parseInt(st.nextToken()); // 관계 수
			
			p = new int[N+1]; // 집합 정보를 담을 배열 생성
			for(int i = 0; i < p.length; i++) {
				p[i] = i;
			}
			
			visited = new boolean[N+1];
			cnt = 0; // 수를 담을 변수 초기화
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				unionSet(x, y);
			}
			
			for(int i = 1; i < N+1; i++) {
				findSet(i);
				if(!visited[p[i]]) {
					cnt++;
					visited[p[i]] = true;
				}
			}
			
//			System.out.println(Arrays.toString(p));
			System.out.println("#"+tc+" "+cnt);
		}
		
		
	}

	private static void unionSet(int x, int y) {
		p[findSet(y)] = findSet(x); 
	}

	private static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}
