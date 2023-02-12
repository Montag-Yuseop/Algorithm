package day3;

import java.util.Scanner;

public class _2805_농작물수확하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];
			
			// 배열 생성(char -'0')은 int형			
			for (int r = 0; r < N; r++) {
				String s = sc.next();
				for (int c = 0; c < N; c++) {
					arr[r][c] = s.charAt(c) - '0';
				}
			}
		
			int mid = N/2; // 중간값
			int sum = 0; // 수확작물 담기
			// 다이아출력과 동일한 방식으로 생성
			for(int i = 0; i<N; i++) {
				int gap = Math.abs(mid-i); // mid와 i값 차이의 절댓값이 곧 거리차이
				for(int j = gap; j<=2*mid-gap; j++) { // mid - (mid - gap) 부터 mid + (mid - gap)이 범위
					sum += arr[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
		
		sc.close();

	}
}
