package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2116_주사위쌓기_실패 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dice = new int[3][4];// 주사위 배열 생성
		int[][] sDice = new int[3][4];// 주사위 배열 생성
		int[][] value = new int[N][6];

		int sum = 0; // 옆면 최대값의 합 구하기

		int max = Integer.MIN_VALUE; // 옆 면 최대값 저장



		// 주사위 값 전체 배열에 저장
		for(int r = 0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c<6; c++) {
				value[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 시작 주사위 저장
		sDice[0][1] = value[0][0];
		for (int i = 0; i < 4; i++) {
			sDice[1][i] = value[0][i+1];
		}
		sDice[2][1] = value[0][5];
		
		
		// 처음 주사위 생성해서 6번 돌려야함(1부터 6까지의 눈)
		for (int d = 1; d <= 6; d++) {
			sum = 0;
			int dNum = d; // 밑면
			int check = 0; // 윗면 다음 주사위로 넘길 값 저장

			// 윗 면 찾기
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 4; c++) {
					if (sDice[r][c] == dNum) { // 주사위 탐색에서 밑변을 찾았으면
						if (c + 1 < 4 && sDice[r][c + 1] != 0) { // c+1이 4보다 작고, 주사위 다음 칸 숫자가 0이 아닐 때,
							check = sDice[r][((c + 2) % 4)]; // c가 0일때는 2, 1일 때는 3, 2일 때는 0, 3일때 1
						} else {
							check = sDice[(r + 2) % 3][c]; // r이 0일때는 2, r이 2일 때는 0
						}
					}
				}
			}


			// 옆 면의 최대값 찾기, 밑면과 윗면이 아닐때 최대값
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 4; c++) {
					if (dice[r][c] != dNum && dice[r][c] != check) {
						max = Math.max(max, dice[r][c]);
					}
				}
			}
			sum += max;
			max = 0;

			// 남은 주사위 개수만큼 돌기
			for (int n = 1; n < N; n++) {
				
				// 다음 주사위 저장
				dice[0][1] = value[n][0];
				for (int i = 0; i < 4; i++) {
					dice[1][i] = value[n][i+1];
				}
				dice[2][1] = value[n][5];
				
				dNum = check;

				// 윗 면 찾기
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 4; c++) {
						if (dice[r][c] == dNum) { // 주사위 탐색에서 밑변을 찾았으면
							if (c + 1 < 4 && dice[r][c + 1] != 0) { // c+1이 4보다 작고, 주사위 다음 칸 숫자가 0이 아닐 때,
								check = dice[r][((c + 2) % 4)]; // c가 0일때는 2, 1일 때는 3, 2일 때는 0, 3일때 1
							} else {
								check = dice[(r + 2) % 3][c]; // r이 0일때는 2, r이 2일 때는 0
							}
						}
					}
				}
				
				// 옆 면의 최대값 찾기, 밑면과 윗면이 아닐때 최대값
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 4; c++) {
						if (dice[r][c] != dNum && dice[r][c] != check) {
							max = Math.max(max, dice[r][c]);
						}
					}
				}
				sum += max;
				max = 0;

			}
			// 다시 start 주사위로 초기화

			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 4; c++) {
					dice[r][c] = sDice[r][c];
				}
			}

		}

		System.out.println(sum);

	}

}
