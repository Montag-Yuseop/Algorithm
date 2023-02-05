package bruteforce;

import java.util.Scanner;

public class _7568_덩치 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[N][2];
		int[] rank = new int[N];
		// 몸무게와 키 등록(2차원 배열)

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 2; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			int ans = 1;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					ans++;
				}
			}
			rank[i] = ans;

		}
		
		for(int i=0; i<rank.length; i++)
			System.out.printf("%d ", rank[i]);
		
		sc.close();

	}
}
