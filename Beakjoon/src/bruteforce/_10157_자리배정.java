package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10157_자리배정 {
	public static void main(String[] args) throws IOException{
		
		// C, R 입력(공연장 크기)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken()); // 열
		int R = Integer.parseInt(st.nextToken()); // 행
		
		int[][] map = new int[R+2][C+2];
		
		for(int i = 0; i<R+2; i++) {
			map[i][0] = -1;
			map[i][C+1] = -1;
		}
		
		for(int i = 1; i<C+1; i++) {
			map[0][i] = -1;
			map[R+1][i] = -1;
		}
		
		int cnt = 1;
		
		int row = R;
		int col = 1;
		int d = 0; // 방향(상우하좌)
		int K = Integer.parseInt(br.readLine());
		
		// 상 우 하 좌 순으로
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		while(true) {
			// 좌석 K가 전체 값 보다 크면 그냥 0 출력 후 종료
			if(K>R*C) {
				System.out.println(0);
				break;
			}
			// K와 일치하는 좌석값을 찾는 경우
			// 행과 열값 출력 후 종료
			if(cnt == K) {
				System.out.printf("%d %d", col, R-row+1);
				break;
			}
			
			// 델타배열로 방향 전환
			if(map[row + dr[d]][col + dc[d]] != 0) {
				d = (d+1)%4;
			}
			map[row][col] = cnt++;
			row = row+dr[d];
			col = col+dc[d];

			
			
			if(cnt > R * C) {
				break;
			}
		}

	
	}
}