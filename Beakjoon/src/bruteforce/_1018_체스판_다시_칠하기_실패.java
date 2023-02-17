package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판_다시_칠하기_실패 {
	
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

		// 반복은 0번 인덱스부터 체스판 길이에서 8을 뺀 만큼(8씩 탐색)
		// 줄마다 W, B체크해서 값 넘겨주자.
		// 정배
		for(int r = 0; r<=M-8; r++) { // M-8까지 반복
			for(int c = 0; c<=N-8; c++) { // N-8까지 반복
				char startCheck = 0; // 0이면 White, 1이면 Black
				startCheck = chess[r][c] == 'W' ? 'W' : 'B';
				int cnt = 0;
				// 정상으로 돌기
				for(int dr = r; dr<r+8; dr++) { // r부터 8씩 r돌기
					for(int dc = c; dc<c+8; dc++) { // c부터 8씩 c돌기
						if((c+dc)%2 == 0) { // 짝수일때는 check값과 같아야함
							if(startCheck != chess[dr][dc]) {
								cnt++;
							}
						} else { // 홀수일 때는 check값과 달라야함
							if(startCheck == chess[dr][dc]) {
								cnt++;
							}
						}
					}
					startCheck = startCheck == 'W' ? 'B' : 'W'; // 다음 시작줄 체크값 변경
				}
				min = Math.min(min, cnt);
			}
		}
		
		// 역배
		for(int r = M-1; r>=8; r--) { // M-8까지 반복
			for(int c = N-1; c>=8; c--) { // N-8까지 반복
				char startCheck = 0; // 0이면 White, 1이면 Black
				startCheck = chess[r][c] == 'W' ? 'W' : 'B';
				int cnt = 0;
				// 정상으로 돌기
				for(int dr = r; dr>=r-7; dr--) { // r부터 8씩 r돌기
					for(int dc = c; dc>=c-7; dc--) { // c부터 8씩 c돌기
						if((c+dc)%2 == 0) { // 짝수일때는 check값과 같아야함
							if(startCheck != chess[dr][dc]) {
								cnt++;
							}
						} else { // 홀수일 때는 check값과 달라야함
							if(startCheck == chess[dr][dc]) {
								cnt++;
							}
						}
					}
					startCheck = startCheck == 'W' ? 'B' : 'W'; // 다음 시작줄 체크값 변경
				}
				min = Math.min(min, cnt);
			}
		}
		System.out.println(min);

	}
}
