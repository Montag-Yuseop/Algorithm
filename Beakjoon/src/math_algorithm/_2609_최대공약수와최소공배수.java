package math_algorithm;

import java.util.Scanner;

public class _2609_최대공약수와최소공배수 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		sc.close();

		int gcd = ucl(a, b);
		int lcm = gcd * (a / gcd) * (b / gcd);

		System.out.println(gcd);
		System.out.println(lcm);

	}

	public static int ucl(int num1, int num2) {

		if (num1 % num2 == 0)
			return num2;

		else {
			return ucl(num2, num1 % num2);
		}
	}

}
