package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _9012_괄호 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Character> ch = new Stack<>();
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			
			String s = sc.next();
			
			for(int i = 0; i < s.length(); i++) {
				ch.add(s.charAt(i));
			}
			
			
		}
		
	}

}
