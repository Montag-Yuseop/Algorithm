package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2164_카드2 {
	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i<=N; i++) {
			q.add(i);
		}
		
		while(true) {
			if(q.size() == 1) {
				System.out.println(q.poll());
				break;
			}
			q.poll();
			int x = q.poll();
			q.add(x);
			
		}
		sc.close();
	}
}
