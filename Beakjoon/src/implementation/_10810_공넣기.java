package implementation;

import java.util.Scanner;

public class _10810_공넣기 {
	// 바구니 N개, 1~N번 번호
	// 공도 1~N번
	// 처음 바구니는 공이 없다?
	// M번 공을 넣을 것
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			
			for(int j = x; j<=y; j++) {
				arr[j-1] = z;
			}
			
		}
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
