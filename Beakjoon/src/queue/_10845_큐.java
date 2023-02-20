package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _10845_큐 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		int n = -1;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < N; tc++) {
			String s = sc.next();
			
			switch(s) {
			case "push" :
				n = sc.nextInt();
				queue.offer(n);
				break;
				
			case "pop" :
				if(queue.isEmpty()) {
					sb.append("-1\n");
				}
				else{
					sb.append(queue.poll()+"\n");
				}
				break;
				
			case "size" :
				sb.append(queue.size()+"\n");
				break;
			case "empty" :
				sb.append((queue.isEmpty() ? 1 : 0)+"\n");
				break;
				
			case "front" :
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.peek()+"\n");
				}
				break;
				
			case "back" :
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(n+"\n");
				}
				break;
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
