package dynamicprogramming;

import java.util.Scanner;

public class _24416_알고리즘수업 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.printf("%d %d", fibonacci(n)[0], fibonacci(n)[1]);
		sc.close();
	}
		
	public static int[] fibonacci(int n) {
	    
		int[] ans = {0, 0};
		
		int[] arr = new int[n];
		int cnt = 0;
		
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=2; i<n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
			cnt++;
		}
		
		ans[0] = arr[n-1];
		ans[1] = cnt;
		
		return ans;
	    
	}
}

