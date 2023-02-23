package queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _1417_국회의원_선거 {
	public static void main(String[] args) {
		
		// 첫째 줄 후보의 수 N
		// 기호 x번을 찍는 사람의 수
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int me = sc.nextInt();
		int cnt = 0;
		
		for(int i = 1; i < N; i ++) {	
			pq.offer(sc.nextInt());			
		}
		
		if(pq.isEmpty()) {
			cnt = 0;
		} else {
			while(pq.peek() >= me) {
				if(pq.peek() >= me) {
					me++;
					pq.add(pq.poll()-1);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
