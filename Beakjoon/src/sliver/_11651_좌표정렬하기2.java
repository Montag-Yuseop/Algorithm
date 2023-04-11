package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11651_좌표정렬하기2 {
	
	static class Node implements Comparable<Node> {
		int x, y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if(this.y == o.y) return this.x - o.x;
			return this.y - o.y;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		PriorityQueue<Node> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			System.out.println(curr.x +" "+curr.y);
		}
		
	}

}
