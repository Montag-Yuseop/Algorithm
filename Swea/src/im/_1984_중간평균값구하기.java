package im;

import java.util.Scanner;

public class _1984_중간평균값구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {
			int[] arr = new int[10];
			double avg = 0;
			double cnt = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
			}
			
			for (int i = 0; i < 10; i++) {
				if (arr[i] == max || arr[i] == min) {
					continue;
				} else {
					avg += arr[i];
					cnt++;
				}

			}
			
			System.out.printf("#%d %d\n",tc, Math.round(avg/cnt));
			
		}

	}
}
