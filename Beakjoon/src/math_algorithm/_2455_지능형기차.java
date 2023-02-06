package math_algorithm;

import java.util.Scanner;

public class _2455_지능형기차 {
	public static void main(String[] args) {

		int max = Integer.MIN_VALUE;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();

			sum -= a;
			max = Math.max(max, sum);
			sum += b;
			max = Math.max(max, sum);

		}
		sc.close();
		System.out.println(max);
	}

}
