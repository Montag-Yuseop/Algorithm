package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_최소비용_구하기 {
	
	static class Node implements Comparable<Node>{
		int end, cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", cost=" + cost + "]";
		}

		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, S, E;
	static ArrayList<ArrayList<Node>> adj;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 마을의 수
		M = Integer.parseInt(br.readLine()); // 버스의 수(경로)
		adj = new ArrayList<>(); // 인접리스트 초기화
		dist = new int[N+1]; // 거리 초기화
		Arrays.fill(dist, INF);
		
		// 인접 리스트 생성
		for(int i = 0; i < N+1; i++) {
			adj.add(new ArrayList<Node>());
		}
		
		// 노드 정보 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj.get(s).add(new Node(e, c));
		}
		
		// 시작 마을과 끝 마을의 번호 받아오기
		st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(dist[E]);
		
	}

	private static void dijkstra() {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[S] = 0;
		pq.add(new Node(S, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(Node node : adj.get(cur)) {
				int x = node.end;
				int w = node.cost;
				if(dist[x] > dist[cur] + w) {
					dist[x] = dist[cur] + w;
					pq.add(new Node(x, dist[x]));
				}
				
			}
			
		}
		
		
	}

}
