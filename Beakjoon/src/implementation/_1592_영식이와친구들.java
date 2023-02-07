package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class _1592_영식이와친구들 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		sc.close();

		int[] arr = new int[N];
		int ball = 0;
		int cnt = 0;

		while (true) {

			arr[ball]++;
			if (arr[ball] >= M)
				break;
			cnt++;
			if (arr[ball] % 2 == 0) {
				if (ball - L < 0) {
					ball = N - Math.abs(ball - L);
				} else {
					ball = ball - L;
				}

			} else {
				ball += L;
				if (ball >= N) {
					ball -= N;
				}
			}

		}

		System.out.println(cnt);

	}

}
