package math_algorithm;

import java.util.Scanner;

public class _4153_직각삼각형 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0)
				break;

			else if (a * a + b * b == c * c) 
				System.out.println("right");
			
			else if (a * a + c * c == b * b) 
				System.out.println("right");
			
			else if (c * c + b * b == a * a) 
				System.out.println("right");
			
			else {
				System.out.println("wrong");
			}

		}
		
		sc.close();
		
	}
}
