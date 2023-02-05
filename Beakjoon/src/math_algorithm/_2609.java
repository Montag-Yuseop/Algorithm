package math_algorithm;

import java.util.Scanner;

public class _2609 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
<<<<<<< HEAD
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		int x = 0;
		int y = 0;
		int res1 = big%small;
		int res2 = small%res1;
		
		while(true) {

			big = Math.max(res1, res2);
			small = Math.min(res1, res2);
			
			if(res1 == 0 || res2 == 0) {
				x = Math.max(res1, res2);
				break;
			}
		}
				
		y = x * (a/x) * (b/x);
		System.out.println(x);
		System.out.println(y);
		
=======
>>>>>>> 5ca8547f3a0fe89410ed5566d3143585f686098b

	}
}
