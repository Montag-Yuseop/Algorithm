package queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _1715_카드정렬하기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Long> priQ = new PriorityQueue<>();
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			priQ.offer(sc.nextLong());
		}
		
		long num = 0;
		
		while(priQ.size()>1) {
			Long a = priQ.poll();
			Long b = priQ.poll();
			
			num += a+b;
			
			priQ.add(a+b);
		}
		
		System.out.println(num);
		sc.close();
	}

}
