package day0223;

import java.util.Scanner;

public class _2007_패턴마디의길이 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			
			String s = sc.next();
			
			for(int i=1; i<30; i++) {
				String s1 = s.substring(0,i);
				String s2 = s.substring(i,2*i);
				
				if(s1.equals(s2)) {
					System.out.print("#"+tc+" ");
					System.out.print(s1.length());
					System.out.println();
					break;
				}
				
			}
			
		}
		sc.close();
	}

}
