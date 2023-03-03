package backtracking;

import java.util.Scanner;

public class _15649_N과M1 {
	static int N;
	static int M;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // N은 자연수 x개(1~N까지)
		M = sc.nextInt(); // M은 번 출력할건지?
		int cnt = 0;
		
		for(int i = 1; i<N+1; i++) {
			print(i, cnt, "");
		}
		
		
	}

	private static void print(int num, int cnt, String str) {
		if(cnt == M) {
			System.out.println(str);
			return;
		}
			
		
		for(int i = 1; i<N+1; i++) {
			print(i, cnt+1, str +" " + Integer.toString(i));
		}
		
	}

}
