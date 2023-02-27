package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class _11726_2xn타일링 {
	
	static int[] arr = new int[1001];
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println(tiling(sc.nextInt()));
		
	}

	public static int tiling(int x) {
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		if(x>2) {
			for(int i = 3; i<arr.length; i++) {
				arr[i] = (arr[i-1] + arr[i-2]) % 10007;
				
				
			}
		}
		
		return arr[x];
		
	}
	
	

}
