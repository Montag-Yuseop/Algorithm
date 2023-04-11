package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1931_회의실배정 {
	static class Node implements Comparable<Node>{
		int s, e, w;

		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if(this.e == o.e) {
				return o.w - this.w;
			}
			
			return this.e - o.e;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = e-s;
			
			pq.offer(new Node(s, e, w));
		}
		
		Node curr = pq.poll();
		int start = curr.s;
		int end = curr.e;
		cnt++;
		while(!pq.isEmpty()) {
			curr = pq.poll();
			if(curr.s >= end || curr.e <= start) {
				cnt++;
				start = Math.min(curr.s, start);
				end = Math.max(curr.e, end);
			}
		}
		System.out.println(cnt);
	}

}
