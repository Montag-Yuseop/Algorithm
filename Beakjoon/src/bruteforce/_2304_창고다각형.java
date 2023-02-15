package bruteforce;

import java.util.Scanner;

public class _2304_창고다각형 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 기둥 수

		int[][] map = new int[1001][1001];

		int maxH = Integer.MIN_VALUE; // 가장 높은 r
		int maxL = Integer.MIN_VALUE; // 가장 긴 c
//		int minH = Integer.MAX_VALUE;
		int minL = Integer.MAX_VALUE; // 가장 짧은 c
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			cnt += H;

			maxH = Math.max(maxH, H);
			maxL = Math.max(maxL, L);
//			minH = Math.min(minH, H);
			minL = Math.min(minL, L);

			
			for (int r = 0; r < H; r++) {
				map[r][L] = 1;
			}
		}
		// 오른쪽으로 가면서 1 계속 칠하기
		for (int i = maxH-1; i >=0 ; i--) {
			for (int j = minL; j <= maxL; j++) {
				if(map[i][j] == 1) {
					for(int k = 1; k+j <= maxL; k++) {
						if(map[i][j+k] == 1) {
							for(int l = j+1; l<j+k; l++) {
								map[i][l] = 1;
								cnt++;
							}
							break;
						}
						else continue;
					}
				}

			}
		}
		
		System.out.println(cnt);

//		for(int  i = maxH-1; i >=0 ; i--) {
//			for(int j = minL; j <= maxL; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

	}

}
