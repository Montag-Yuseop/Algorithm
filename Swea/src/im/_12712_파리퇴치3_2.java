package im;

import java.util.Scanner;

public class _12712_파리퇴치3_2 {
	// 상하좌우 델타배열
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 대각선 방향 델타배열
	static int[] dr2 = {-1, -1, 1, 1};
	static int[] dc2 = {-1, 1, -1, 1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 스캐너 생성
		int T = sc.nextInt(); // TestCase입력
		
		// T만큼 반복
		for(int tc = 1; tc<T+1; tc++) {
			int N = sc.nextInt(); // 배열 크기
			int M = sc.nextInt(); // 스프레이 세기
			
			int[][] map = new int[N][N]; // 2차원 배열 생성
			
			// 배열에 값 집어넣기
			for(int r= 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			// 최대값 찾기 한다
			int max = Integer.MIN_VALUE; // 최대값 찾기 위한 초기화
			
			// 탐색 시작
			for(int r = 0; r<N; r++) {
				for(int c = 0; c<N; c++) {
					// 첫 번째 합(+방향)
					int sum = 0;
					sum += map[r][c]; // 시작값 더해주기
					for(int d = 0; d<4; d++) { // 4방 탐색 시작
						for(int i = 1; i<M; i++) {
							int nr = r + dr[d] * i;
							int nc = c + dc[d] * i;
							// 경계 조건 체크
							if(nr >= 0 && nr <N && nc>=0 && nc<N) {
								sum += map[nr][nc];
							}
						}
					}
					// 최대값 업데이트
					max = Math.max(sum, max);
										
					// 두 번째 합(x방향)
					sum = 0;
					sum += map[r][c]; // 시작값 더해주기
					for(int d = 0; d<4; d++) { // 8방 탐색 시작
						for(int i = 1; i<M; i++) {
							int nr = r + dr2[d] * i;
							int nc = c + dc2[d] * i;
							// 경계 조건 체크
							if(nr >= 0 && nr <N && nc>=0 && nc<N) {
								sum += map[nr][nc];
							}
						}
					}
					
					max = Math.max(sum, max);
				}
			}
			System.out.printf("#%d ", tc);
			System.out.println(max);
			
		}

	}

}
