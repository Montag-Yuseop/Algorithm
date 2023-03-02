package implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class _1138_한줄로서기 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = N-1; i>=0; i--) {
			list.add(arr[i], i+1);
		}
		
		for(int i = 0; i <N; i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

}
