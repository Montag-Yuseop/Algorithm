package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _10828_스택 {
	public static void main(String[] args) {
		
		// push X: 정수 X를 스택에
		// pop: 가장 위에 있는 정수 빼기. 정수가 없으면 -1 출력
		// size 정수 개수 출력
		// empty : 비었으면1, 아니면 0
		// top: 가장 위 정수 출력, 없으면 -1
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = sc.nextInt();
		int n = -1;
		
		for(int i = 0; i < N; i++) {
			String s = sc.next();

			switch(s) {
			
			case "push":
				n = sc.nextInt();
				stack.add(n);
				break;
			
			case "pop":
				if(stack.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					int p = stack.pop();
					sb.append(p+"\n");
				}
				break;
			
			case "size":
				sb.append(stack.size()+"\n");
				break;
				
			case "empty":
				if(stack.isEmpty()) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
				break;
			
			case "top":
				if(stack.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(stack.peek()+"\n");
				}
				break;
			}
			
		}
		System.out.println(sb);
		
	}
}
