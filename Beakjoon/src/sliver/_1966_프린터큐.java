package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class _1966_프린터큐 {
	
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if(o.w == this.w) return o.v - this.v;
			return o.w - this.w;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서
			
			Queue<Node> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				q.offer(new Node(i, x));
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				boolean check = true;
				// q에서 하나를 뽑아온다
				Node curr = q.poll();
				
				// 뽑아온 녀석보다 가중치가 큰 애들이 있다면? 남은 애들 중에?
				for(Node node : q) {
					if(node.w > curr.w) {
						// 다시 큐에 집어넣는다
						q.offer(curr);
						check = false; // false는? 다시 q에 넣었다는 뜻
//						System.out.println(curr.v + ": add");
						break;
					}
				}
				// 다시 넣는건 카운트에 안세알려줄 것
				if(check) {
					cnt++;
					// 다시 안넣었는데 M과 같다면? 종료하고 출력
					if(curr.v == M) {
						break;
					}
				}
				
				

			}
			
			System.out.println(cnt);
		}
		
	}
}
