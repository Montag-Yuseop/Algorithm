package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753_최단경로 {

	static class Node implements Comparable<Node> {
		int v; // 종료 지점
		int w; // 가중치

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
		
	}
	
	static ArrayList<ArrayList<Node>> list;
	static int[] dis;
	static int V, E, S;
	static int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 노드 수
		E = Integer.parseInt(st.nextToken()); // 간선 수
		dis = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList<>();
		// 새로운 인접리스트 생성
		for(int i = 0; i < V+1; i++) {
			list.add(new ArrayList<>());
		}
		
		S = Integer.parseInt(br.readLine()); // 시작 정점
		Arrays.fill(dis, INF);
		dis[S] = 0;
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, cost));
		}
	
		
		dijkstra();
		for(int i = 1; i < dis.length; i++) {
			if(dis[i] == INF) System.out.println("INF");
			else {
				System.out.println(dis[i]);
			}
		}
		
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(S, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.v;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(Node node : list.get(cur)) {
				if(dis[node.v] > dis[cur] + node.w) {
					dis[node.v] = dis[cur] + node.w;
					pq.add(new Node(node.v, dis[node.v]));
				}
			}
			
			
		}
	}	
}