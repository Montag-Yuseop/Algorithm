package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13549_숨바꼭질3 {
	// 수빈이 위치 N
	// 동생 위치 K의 최단거리를 구해라

	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int[] dist = new int[100001];
	static int N, M;
	static ArrayList<ArrayList<Node>> adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Arrays.fill(dist, INF);
		dist[N] = 0;
		adj = new ArrayList<>();

		for (int i = 0; i < 100001; i++) {
			adj.add(new ArrayList<Node>());
		}

		dijkstra();
		
//		for (int i = 0; i < M + 1; i++) {
//			System.out.println("i: "+i +" dist: " + dist[i]);
//		}
		System.out.println(dist[M]);
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
//		boolean [] visited = new boolean[100001];
		pq.add(new Node(N, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.v;
			if (cur == 100001)
				break;
//			if(visited[cur]) continue;
//			visited[cur] = true;

			if (cur + 1 <= 100000 && dist[cur + 1] > dist[cur] + 1) {
				dist[cur + 1] = dist[cur] + 1;
				pq.offer(new Node(cur + 1, dist[cur] + 1));
			}

			if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1) {
				dist[cur - 1] = dist[cur] + 1;
				pq.offer(new Node(cur - 1, dist[cur] + 1));
			}
			if (cur <= 50000 && dist[2 * cur] > dist[cur]) {
				dist[2 * cur] = dist[cur];
				pq.offer(new Node(2 * cur, dist[cur]));
			}

		}

	}
}
