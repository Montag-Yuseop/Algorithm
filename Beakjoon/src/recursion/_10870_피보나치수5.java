package recursion;

import java.util.Scanner;

public class _10870_피보나치수5 {
	
	public static int fivo(int n) {
		if(n < 2) {
			return n;
		} else {
			return fivo(n-1) + fivo(n-2);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(fivo(n));
		sc.close();
	}

}
