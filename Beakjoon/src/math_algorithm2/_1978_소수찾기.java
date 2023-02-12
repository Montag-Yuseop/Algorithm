package math_algorithm2;

import java.util.Scanner;

public class _1978_소수찾기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
//		int[] arr = new int[N];

		int so = 0;
		
//		for(int i=0; i<N; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			 if(x != 1) {
				int cnt = 0;
				 for(int j=2; j<=x; j++) {
					 if(x%j == 0) {
						 cnt++;
					 }
				 }
				if(cnt==1) 
					so += 1;	
			 }
			
		}
		System.out.println(so);
		sc.close();

	}
}
