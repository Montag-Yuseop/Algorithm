package math_algorithm;

import java.util.Scanner;

public class _11050_이항계수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int n = 1;
		for(int i = N; i>N-K; i--) {
			n *= i;
		}
		
		int k = 1;
		for(int i = K; i>0; i--) {
			k *= i;
		}
		
		System.out.println(n/k);
			
	}

}
