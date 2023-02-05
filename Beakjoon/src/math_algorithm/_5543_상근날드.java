package math_algorithm;

import java.util.Scanner;

public class _5543_상근날드 {
	public static void main(String[] args) {
		
		int burger = Integer.MAX_VALUE;
		int drink = Integer.MAX_VALUE;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++)
			burger = Math.min(burger, sc.nextInt());
		
		
		for(int i=0; i<2; i++)
			drink = Math.min(drink, sc.nextInt());
			
		System.out.println(burger+drink-50);
		
	}
}
