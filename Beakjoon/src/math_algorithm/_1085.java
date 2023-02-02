package math_algorithm;

import java.util.Scanner;

public class _1085 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		sc.close();
		
		int a = Math.min(x-0, w-x);
		int b = Math.min(y-0, h-y);
		int res = Math.min(a, b);
		
		System.out.println(res);
		
	}
}
