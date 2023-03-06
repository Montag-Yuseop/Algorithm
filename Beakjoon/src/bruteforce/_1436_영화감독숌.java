package bruteforce;

import java.util.Scanner;

public class _1436_영화감독숌 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 666;
		int cnt = 1;
		
		int N = sc.nextInt();
		
		while(cnt != N) {
			num++;
			
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
			
		}
		System.out.println(num);
		sc.close();
	}
}
