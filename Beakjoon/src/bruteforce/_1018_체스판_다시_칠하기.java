package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판_다시_칠하기 {
	public static void main(String[] args) throws IOException{
		
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken()); // M(열)
		int N = Integer.parseInt(st.nextToken()); // N(행)
		
		char[][] chess = new char[M][N];
		
		int min = Integer.MAX_VALUE; // 최소 변환 수 체크하기

		// 2차원 배열에 입력값 넣기
		for(int r = 0 ; r<M; r++) {
			String s = br.readLine();
			for(int c = 0; c<N; c++) {
				chess[r][c] = s.charAt(c);
			}
		}
		// 배열 돌리기 시작
		
		for(int r = 0; r<=M-8; r++) {
			for(int c = 0; c<=N-8; c++) {
				// 시작이 W일 때와 B일때 두 번 돌려야 함
				for(int tc = 0; tc<2; tc++) {
					char start = tc == 0 ? 'W':'B';
					int cnt = 0; // 한 타임에 한 번씩 초기화
					// W일 때 64번 돌리고, B일때도 64번 돌려야 함
					for(int dr = r; dr<r+8; dr++) {
						for(int dc = c; dc<c+8; dc++) {
							if((c+dc)%2 == 0) { // 짝수만큼 갈 때
								if(chess[dr][dc] != start) {
									cnt++;
								}
							} else { // 홀수만큼 갈 때
								if(chess[dr][dc] == start) {
									cnt++;
								}
							}
						}
						// 열 다 돌리면 start값 반전
						start = start == 'W' ? 'B' : 'W';
					}
					min = Math.min(min, cnt);
				}
				
			}
		}
		System.out.println(min);
		
	}

}
