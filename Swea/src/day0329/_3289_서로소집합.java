package day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3289_서로소집합 {
	static int n, m;
	static int[] p, rank;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc = 1; tc < T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 정점 개수
			m = Integer.parseInt(st.nextToken()); // 연산 횟수
			p = new int[n+1];
			rank = new int[n+1];
			
			sb.append("#"+tc+" ");
			
			for(int i = 1; i < p.length; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				switch(a) {
				case 0 : 
					unionSet(x, y);
					break;
				case 1 :
					if(findSet(x)== findSet(y)) sb.append("1");
					else sb.append("0");
					break;
				}
//				System.out.println(Arrays.toString(p));
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		
		return p[x];
		
	}

	private static void unionSet(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}
