package math_algorithm2;

import java.util.Scanner;

public class _5086_배수와_약수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(N == 0 && M == 0) break;
			
			check(N, M);
			
		}
		sc.close();
		
	}

	private static void check(int N, int M) {
		
		if(M%N == 0) System.out.println("factor");
		else if(N%M == 0) System.out.println("multiple");
		else System.out.println("neither");
		
	}

}
