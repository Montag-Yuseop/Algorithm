package day0224;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _1230_암호문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<= 10; tc++) {
			List<Integer> list = new LinkedList<>();
		
			int N = sc.nextInt();
			
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt());
			}
			int M = sc.nextInt();
			
			for(int i = 0; i<M; i++) {
				String s = sc.next();
				int x;
				int y;
				switch(s) {
				case "I":
					x = sc.nextInt();
					y = sc.nextInt();
					for(int j = 0; j<y; j++) {
						list.add(x+j,sc.nextInt());
					}
					break;
				case "D":
					x = sc.nextInt();
					y = sc.nextInt();
					for(int j = 0; j<y; j++) {
						list.remove(x);
					}
					break;	
				case "A":
					y = sc.nextInt();
					for(int j = 0; j<y; j++) {
						list.add(sc.nextInt());
					}
					break;
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i = 0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
