package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2116_주사위쌓기 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 주사위 배열 생성
		int[][] dice = new int[N][6];
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 6; c++) {
				dice[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		

		
		int sum = 0; // 최대합계 출력
		
		// 6번 돌려(주사위 눈만큼)
		// 1부터 6까지
		for(int i = 1; i<=6; i++) {
			int bottom = i; // 바닥값
			int top = 0; // 천장값
			int temp = 0; // 합계 임시 저장 변수
		
			for(int j = 0; j < N; j++) {// 최대값// 주사위 한줄마다 확인
				int max = Integer.MIN_VALUE; 
				for(int d = 0; d < 6; d++) { // 주사위 줄에서 탐색(바닥값 찾는중)
					// 바닥값 탐색
					if(dice[j][d] == bottom) {
						if(d == 0 || d == 5) {
							top = dice[j][Math.abs(d-5)]; // 0이면 5, 5면 0인덱스가 되어야 함(마주보는면)
						} else {
							if(d > 2) {
								top = dice[j][d-2];
							} else {
								top = dice[j][d+2];
							}
						}
					}
				}

				// 최대값 찾기
				for(int d = 0; d<6; d++) {
					if((dice[j][d] != bottom) && (dice[j][d] != top)) {
						max = Math.max(max, dice[j][d]);
					}
				}
				
				temp += max;
				bottom = top;
			}
			sum = Math.max(sum, temp);
		}
		
		System.out.println(sum);
		
	}

}
