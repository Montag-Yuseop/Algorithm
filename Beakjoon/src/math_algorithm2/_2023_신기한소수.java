package math_algorithm2;

import java.util.Scanner;

public class _2023_신기한소수 {
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for(int i = 2; i<7; i++) {
			cnt = 0;
			if(i == 4 || i == 6) continue;
			digit(i, N);
		}
		
	}

	private static void digit(int i, int n) {
		
		
	}



}
