package matrix;

import java.util.Scanner;

public class MatrixPlus {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr1= new int[N][M];
		int[][] arr2= new int[N][M];
		int[][] arr3= new int[N][M];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				
				arr1[r][c] = sc.nextInt();
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				
				arr2[r][c] = sc.nextInt();
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				
				arr3[r][c] = arr1[r][c] + arr2[r][c];
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				
				System.out.printf("%d ",arr3[r][c]);
			}
			System.out.println();
		}
		
	}
}
