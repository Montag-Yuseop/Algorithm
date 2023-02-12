package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1961_숫자배열회전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // TestCase 수 입력

		for (int tc = 1; tc < T + 1; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			int[][] arr_90 = new int[N][N];
			int[][] arr_180 = new int[N][N];
			int[][] arr_270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 90도 배열 회전에 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr_90[i][j] = arr[N-1 - j][i];
				}
			}

			// 180도는 90도를 90도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr_180[i][j] = arr_90[N-1 - j][i];
				}
			}

			// 270도는 180도를 90도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr_270[i][j] = arr_180[N-1 - j][i];
				}
			}
			
			// tc 출력
			System.out.println("#"+tc);
			
			for (int i = 0; i < N; i++) {
				// 90도 첫 줄 출력
				for(int j = 0; j<N; j++) {
					System.out.print(arr_90[i][j]);
				}
				// 한 칸 띄우기
				System.out.print(" ");
				// 180도 첫 줄 출력
				for(int j = 0; j<N; j++) {
					System.out.print(arr_180[i][j]);
				}
				//한 칸 띄우기
				System.out.print(" ");
				// 270도 첫 줄 출력
				for(int j = 0; j<N; j++) {
					System.out.print(arr_270[i][j]);
				}
				// 줄 바꿈
				System.out.println();
				
				
			}

		}

	}

}
