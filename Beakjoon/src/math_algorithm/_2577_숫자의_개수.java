package math_algorithm;

import java.util.Scanner;

public class _2577_숫자의_개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		sc.close();
		
		int N = A * B * C;
		
		String n = Integer.toString(N);
		
		int[] arr1 = new int[n.length()];
		int[] arr2 = new int[10];
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = n.charAt(i)-'0';
		}
		
		for(int i=0; i<arr1.length; i++) {
			arr2[arr1[i]]++;
		}
		
		for(int i=0; i<arr2.length; i++) {
				System.out.println(arr2[i]);
			}
	}
}
