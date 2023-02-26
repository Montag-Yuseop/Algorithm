package day0223;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1225_암호생성기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 0; tc<10; tc++) {
			
			int testCase = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 0; i<8; i++) {
				q.offer(sc.nextInt());
			}
			int cnt = 1;
			while(true) {
				if(cnt>5) {
					cnt = 1;
				}
				
				int x = q.poll();
				if(x-cnt <= 0) {
					q.offer(0);
					break;
				} else {
					q.offer(x-cnt);
				}
				cnt++;
			}
			
			System.out.print("#"+testCase);
			for(int i = 0; i<8; i++) {
				System.out.print(" "+q.poll());
			}
			System.out.println();
			
		}
		sc.close();
	}

}
