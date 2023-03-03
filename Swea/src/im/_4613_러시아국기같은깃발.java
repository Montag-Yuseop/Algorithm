package im;

import java.util.Scanner;

public class _4613_러시아국기같은깃발 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<T+1; tc++) {
			int N = sc.nextInt(); // 행의 수
			int M = sc.nextInt(); // 열의 수
			
			char[][] map = new char[N][M]; // 배열 생성
			
			for(int r = 0; r<N; r++) {
				String s = sc.next();
				for(int c = 0; c<M; c++) {
					map[r][c] = s.charAt(c);
				}
			}
		
			int min = Integer.MAX_VALUE; // 최소값 
			
			// b : 파란색이 시작되는 인덱스
			// r : 빨간색이 시작되는 인덱스
			// i : r과 겹치지 않게, 행의 인덱스를 i로
			// j : 열의 인덱스
			
			
			// 완전 탐색
			for(int b =1; b<N-1; b++) {
				for(int r = 2; r<N; r++) {
					// b와 r이 정해질 때 마다 세 구간이 정해짐
					// 새로운 구간마다 카운트
					int cnt = 0;
					// [0, b)
					for(int i = 0; i<b; i++) {
						for(int j = 0; j<M; j++) {
							if(map[i][j] != 'W') cnt++;
						}
					}
					
					// [b,r)
					for(int i = b; i<r; i++) {
						for(int j = 0; j<M; j++) {
							if(map[i][j] != 'B') cnt++;
						}
					}
					
					// [r,N)
					for(int i = r; i<N; i++) {
						for(int j = 0; j<M; j++) {
							if(map[i][j] != 'R') cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
			}
			System.out.println("#"+tc+" "+min);
		}
		
	}
}
