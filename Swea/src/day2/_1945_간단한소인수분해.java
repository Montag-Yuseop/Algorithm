package day2;

import java.util.Scanner;

public class _1945_간단한소인수분해 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {
			int[] arr = new int[5];
			int[] arr2 = { 2, 3, 5, 7, 11 };
			int N = sc.nextInt();

			for (int i = 0; i < arr2.length; i++) {

				while (true) {
					if (N % arr2[i] == 0) {
						N = N / arr2[i];
						arr[i]++;
					} else if (N % arr2[i] != 0)
						break;

				}

			}
			System.out.printf("#%d", tc);
			for (int i = 0; i < arr.length; i++) {
				System.out.printf(" %d", arr[i]);
			}
			System.out.println();

		}

		sc.close();

	}

}
