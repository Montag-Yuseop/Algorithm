package day0223;

import java.util.Scanner;

public class _7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		
		// 카드는 1번부터 N, M번
		// TC
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N*M+1];
			int max = -1;
			
			for(int i = 1; i<N+1; i++) {
				for(int j = 1; j<M+1; j++) {
					arr[i+j]++;
				}
			}
			
			for(int i = 1; i<arr.length; i++) {
				max = Math.max(arr[i], max);
			}

			System.out.print("#"+tc+" ");
			for(int i = 0; i<arr.length; i++) {
				if(arr[i] == max) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
		sc.close();
		
	}

}
