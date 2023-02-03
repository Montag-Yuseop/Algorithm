package math_algorithm;

import java.util.Scanner;

public class _2420_사파리월드 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long sub = Math.abs(a-b);
		
		sc.close();
		
		System.out.println(sub);
		
	}
}
