package im;

import java.util.Scanner;

public class _1206_View {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<11; tc++) {
			
			int N = sc.nextInt(); // 건물 수
			
			int[][] arr = new int[255][N]; // 아파트 배열
			
			int house = 0; // 조망권 확보된 집 수
			
			for(int c = 0; c<N; c++) {
				int high = sc.nextInt();
				for(int r = 0; r < high; r++) {
					arr[r][c] = 1;
				}
			}
			
			for(int r = 0; r<255; r++) {
				for(int c = 2; c < N-2; c++) {
					if(arr[r][c] == 1) {
						int cnt = 0;
						for(int dc = -2; dc <= 2; dc++) {
							if(arr[r][c+dc] == 0) {
								cnt++;
							}
						}
						if(cnt == 4) {
							house++;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, house);
			
		}
		sc.close();
	}
	
}
