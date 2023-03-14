package implementation;

import java.util.Scanner;

public class _25314_코딩은체육과목입니다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N/4; i++) {
			System.out.print("long ");
		}
		
		System.out.print("int");
		
		sc.close();
	}

}
