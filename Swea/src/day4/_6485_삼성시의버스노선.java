package day4;

import java.util.Scanner;

public class _6485_삼성시의버스노선 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			
			int bus[] = new int[5000];
			
			int N = sc.nextInt();
			
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				
				for(int j = a; j <= b; j++) {
					bus[j]++;
				}	
			}
			
			int P = sc.nextInt();
			int busStop[] = new int[P];
			for(int i = 0; i<P; i++) {
				int a = sc.nextInt()-1;
				
				busStop[i] = bus[a];
				
			}
			System.out.printf("#%d ", tc);
			for(int i = 0; i < P; i++) {
				System.out.print(busStop[i]+" ");
				
			}
			System.out.println();
			
		}
		
		sc.close();
	}

}
