package implementation;

import java.util.Scanner;

public class _10813_공바꾸기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 바구니 개수
		int M = sc.nextInt(); // 바꿀 횟수
		
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = i+1;
		}
		
		for(int i = 0; i<M; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			int temp = 0;
			
			temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
			
		}
		
		for(int i = 0; i<N; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
