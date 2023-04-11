package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021_회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> dq = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i < N; i++) {
			dq.offer(i+1);
		}
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(dq.getFirst() == x) {
				dq.removeFirst();
				continue;
			}
			
			int sidx = dq.indexOf(x);
			int eidx = dq.size()-sidx;
			
			if(sidx <= eidx) {
				// 앞에서부터 sidx만큼, 뒤에서부터 eidx만큼 떨어져 있다
				// 그니까 eidx가 더 크거나 같다는 것은 더 앞에 있다는 의미이다
				// 그럼 앞에걸 뒤로 옮겨주는게 빠르다
				while(true) {
					int temp = dq.getFirst();
					dq.removeFirst();
					dq.addLast(temp);
					cnt++;
					
					if(dq.getFirst() == x) {
						dq.removeFirst();
						break;
					}
					
				}
			} else {
				while(true) {
					int temp = dq.getLast();
					dq.removeLast();
					dq.addFirst(temp);
					cnt++;
					
					if(dq.getFirst() == x) {
						dq.removeFirst();
						break;
					}
					
				}
			}
			
		}
		System.out.println(cnt);
		
	}
}
