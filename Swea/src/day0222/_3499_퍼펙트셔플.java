package day0222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _3499_퍼펙트셔플 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();
			
			int N = sc.nextInt();
			
			if(N%2 == 0) { // N이 짝수일 때
				for(int i = 0; i < N/2; i++) {
					q1.offer(sc.next());
				}
				
				for(int i = 0; i < N/2; i++) {
					q2.offer(sc.next());
				}
				
				System.out.print("#"+tc + " ");
				while(true) {
					System.out.print(q1.poll() + " ");
					System.out.print(q2.poll() + " ");
					if(q2.isEmpty()) break;
				}
				System.out.println();
				
			} else { // N이 홀수일 때
				for(int i = 0; i<N/2+1; i++) {
					q1.offer(sc.next());
				}
				
				for(int i = 0; i<N/2; i++) {
					q2.offer(sc.next());
				}
				
				System.out.print("#"+tc + " ");
				while(true) {
					System.out.print(q1.poll() + " ");
					if(q1.isEmpty()) break;
					System.out.print(q2.poll() + " ");
					
				}
				System.out.println();
			}
			
		}
		
		sc.close();
	}

}
