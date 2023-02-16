package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()); // 너비
		int C = Integer.parseInt(st.nextToken()); // 높이

		int sum = 0; // 거리 담을 변수

		int N = Integer.parseInt(br.readLine());
		int[][] shop = new int[N][3];
		int[] dong = new int[3];

		// 상점 수 만큼 돌면서 상점의 좌 우 길이, 위치 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 1북 2남 3서 4동
			shop[i][0] = Integer.parseInt(st.nextToken());
			if (dir == 1) {
				shop[i][1] = R - shop[i][0];
				shop[i][2] = 1;
			} else if (dir == 2) {
				shop[i][1] = R - shop[i][0];
				shop[i][2] = 2;
			} else if (dir == 3) {
				shop[i][1] = C - shop[i][0];
				shop[i][2] = 3;
			} else {
				shop[i][1] = C - shop[i][0];
				shop[i][2] = 4;
			}
		}

		// 동근이 좌 우 거리, 위치값 저장
		st = new StringTokenizer(br.readLine());
		int dongDir = Integer.parseInt(st.nextToken());
		dong[0] = Integer.parseInt(st.nextToken());
		if (dongDir == 1) {
			dong[1] = R - dong[0];
			dong[2] = 1;
		} else if (dongDir == 2) {
			dong[1] = R - dong[0];
			dong[2] = 2;
		} else if (dongDir == 3) {
			dong[1] = C - dong[0];
			dong[2] = 3;
		} else {
			dong[1] = C - dong[0];
			dong[2] = 4;
		}

		// 동근이랑 상점의 위치가 같으면 동근이랑 상점위치만 계산
		for (int i = 0; i < N; i++) {
			if (dong[2] == 1) {
				// 동근이 위치가 북일 때
				switch (shop[i][2]) {
				// 상점이 남쪽이면
				case 2:
					sum += Math.min(dong[0] + shop[i][0] + C, dong[1] + shop[i][1] + C);
					break;
				// 상점이 서쪽이면
				case 3:
					sum += dong[0] + shop[i][0];
					break;
				// 상점이 동쪽이면
				case 4:
					sum += dong[1] + shop[i][0];
					break;

				default:
					sum += Math.abs(dong[1] - shop[i][1]);

				}
			} else if (dong[2] == 2) {
				// 동근이 위치가 남일 때
				switch (shop[i][2]) {
				// 상점이 북쪽이면
				case 1:
					sum += Math.min(dong[0] + shop[i][0] + C, dong[1] + shop[i][1] + C);
					break;
				// 상점이 서쪽이면
				case 3:
					sum += dong[0] + shop[i][1];
					break;
				// 상점이 동쪽이면
				case 4:
					sum += dong[1] + shop[i][1];
					break;
				default:
					sum += Math.abs(dong[1] - shop[i][1]);
				}
			} else if (dong[2] == 3) {
				// 동근이 위치가 서일 때
				switch (shop[i][2]) {
				// 상점이 북쪽이면
				case 1:
					sum += dong[0] + shop[i][0];
					break;
				// 상점이 남쪽이면
				case 2:
					sum += dong[1] + shop[i][0];
					break;
				// 상점이 동쪽이면
				case 4:
					sum += Math.min(dong[0] + shop[i][0] + R, dong[1] + shop[i][1] + R);
					break;
				default:
					sum += Math.abs(dong[1] - shop[i][1]);
				}
			} else {
				// 동근이 위치가 동일 때
				switch (shop[i][2]) {
				// 상점이 북쪽이면
				case 1:
					sum += dong[0] + shop[i][1];
					break;
				// 상점이 남쪽이면
				case 2:
					sum += dong[1] + shop[i][1];
					break;
				// 상점이 서쪽이면
				case 3:
					sum += Math.min(dong[0] + shop[i][0] + R, dong[1] + shop[i][1] + R);
					break;
				default:
					sum += Math.abs(dong[1] - shop[i][1]);
				}
			}

		}

		System.out.println(sum);
	}
}
