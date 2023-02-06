package math_algorithm;

import java.util.Scanner;

public class _2609 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		sc.close();

		int big = Math.max(a, b);
		int small = Math.min(a, b);
		int res = big % small;

		if (res == 0) {
			big = small;
		} else {
			while (res != 0) {

				big = res;
				res = small % res;

				if (res == 0)
					break;

			}
		}

		System.out.println(big);
		System.out.println(big * (a / big) * (b / big));

	}
}
