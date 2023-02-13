package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class _11399_ATM {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] arr2 = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		arr2[0] = arr[0];
		
		for(int i = 1; i<N; i++) {
			arr2[i] = arr[i] + arr2[i-1];
		}
		
		int sum = 0;
		
		for(int i=0; i<arr2.length; i++) {
			sum += arr2[i];
		}
		
		System.out.println(sum);
	}

}
