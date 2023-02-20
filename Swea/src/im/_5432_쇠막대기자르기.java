package im;

import java.util.Scanner;
import java.util.Stack;

public class _5432_쇠막대기자르기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc < T+1; tc++) {
			Stack<Character> stack = new Stack<>();
			
			String s = sc.next();
			
			char[] ch = new char[s.length()];
			for(int i = 0; i < ch.length; i++) {
				ch[i] = s.charAt(i);
			}
			
			int sum = 0;
			boolean check = true;
			
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == '(') {
					stack.push('(');
					check = true;
				} else {			
					stack.pop();
					if(check == true) {
						sum += stack.size();
					} else {
						sum++;
					}
					check = false;
				}

			}
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}
		
	}

}
