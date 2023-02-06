package day1;

import java.util.Scanner;

public class _1948_날짜_계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] arr = new int[13];
		for (int i = 1; i < arr.length; i++) {
			if (i == 4 || i == 6 || i == 9 || i == 11) {
				arr[i] = 30;
			} else {
				arr[i] = 31;
			}
			arr[2] = 28;
		}

		for (int tc = 1; tc < T + 1; tc++) {

			int day = 0;

			int a_m = sc.nextInt();
			int a_d = sc.nextInt();
			int b_m = sc.nextInt();
			int b_d = sc.nextInt();

			if (a_m == b_m) {
				day = b_d - a_d + 1;
			} else {
				for (int a = a_m; a < b_m; a++) {
					day += arr[a];
				}
				day = day + 1 + b_d - a_d;
			}

			System.out.printf("#%d %d\n", tc, day);
		}
		sc.close();

	}

}
