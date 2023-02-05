package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11866_요세푸스 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
	
		for(int i=0; i<N; i++) 
			q.add(i+1);
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			
			int a = q.poll();
			if(cnt%K == 0)
				q.add(a);
			
		}
		
	}
}
