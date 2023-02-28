package im;

import java.util.Arrays;
import java.util.Scanner;

public class _IM모의고사 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // testCase의 수

		for(int tc = 1; tc<T+1; tc++) {

			int N = sc.nextInt(); // 신입사원의 수
			int k_min = sc.nextInt(); // 분반 최소 인원
			int k_max = sc.nextInt(); // 분반 최대 인원

			int[] score = new int[101]; // 점수별 사원 수
			int[][] dp = new int[101][101]; // 배열 생성

			int max = Integer.MIN_VALUE; // 최대 인원 반
			int min = Integer.MAX_VALUE; // 최소 인원 반

			for(int i = 0; i<N; i++) { // 어학성적 배열 사용
				int x = sc.nextInt();
				score[x]++;
			}

			for(int r=1; r<101; r++) {
				for(int c = r+1; c<101; c++) {
					int cnt = 0;
					for(int i = 0; i<r; i++) {
						cnt += score[i];
					}
					if(cnt<k_min || cnt>k_max) {
						dp[r][c] = -1;
						continue;
					}

					int cnt2 = 0;
					for(int i = r; i<c; i++) {
						cnt2 += score[i];
					}
					if(cnt2<k_min || cnt2>k_max) {
						dp[r][c] = -1;
						continue;
					}

					max = Math.max(cnt, cnt2);
					min = Math.min(cnt, cnt2);

					int cnt3 = 0;
					for(int i = c; i<101; i++) {
						cnt3 += score[i];
					}
					if(cnt3<k_min || cnt3>k_max) {
						dp[r][c] = -1;
						continue;
					}

					max = Math.max(max, cnt3);
					min = Math.min(min, cnt3);

					dp[r][c] = max-min;

				}
			}
			//			System.out.println(Arrays.toString(score));
			//			
			//			for(int i = 0; i<101; i++) {
			//				System.out.println(Arrays.toString(dp[i]));
			//			}

			boolean check = false;
			int ans = Integer.MAX_VALUE;
			for(int r = 1; r<101; r++) {
				for(int c = r+1; c<101; c++) {
					if(dp[r][c] == -1) {
						continue;
					} else {
						ans = Math.min(ans, dp[r][c]);
						check = true;
					}
				}
			}

			System.out.print("#"+tc+" ");
			if(check) {
				System.out.println(ans);
			} else {
				System.out.println(-1);
			}

		}

	}

}
