package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11866_요세푸스문제0 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 큐 생성
		Queue<Integer> q = new LinkedList<>();
		
		// 큐에 입력
		for(int i = 0; i < N; i++) {
			q.add(i+1);
		}
		
		int cnt = 0;
		System.out.print("<");
		while(!q.isEmpty()) {
			cnt++;
			int a = q.poll();
			if(cnt%K != 0) {
				q.add(a);
			} else {
				if(!q.isEmpty()) {
					System.out.print(a+", ");
				} else {
					System.out.print(a);
				}
				
			}
			
		}
		System.out.print(">");
		sc.close();
	}

}
