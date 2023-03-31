package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1238_Contact {

	static class Node {
		int s, w;

		public Node(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

	static int N, S, ans;
	static ArrayList<ArrayList<Node>> adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 데이터 입력 수
			S = Integer.parseInt(st.nextToken()); // 시작 정점
			adj = new ArrayList<>();
			visited = new boolean[101];
			ans = 0;

			for (int i = 0; i < 101; i++) {
				adj.add(new ArrayList<Node>());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				// 처음 연결되는 애들은 거리가 다 0입니다
				adj.get(A).add(new Node(B, 1));
			}

			bfs();
			System.out.println("#"+tc+" " + ans);
		}

	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
//		q.offer(new Node(S, 0));
		q.addAll(adj.get(S));
		visited[S] = true;
		int[] dist = new int[101];
		dist[S] = 0;
		int temp = 0;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			dist[curr.s] = curr.w;
			temp = Math.max(temp, dist[curr.s]);
			if (visited[curr.s])
				continue;
//			System.out.println("위치: " + curr.s + " 거리: " + curr.w);
			visited[curr.s] = true;

			for (Node node : adj.get(curr.s)) {
				int nextNode = node.s;
				if (visited[nextNode])
					continue;
				q.add(new Node(nextNode, curr.w + 1));
	
				
			}

		}
		for(int i = 1; i < 101; i++) {
			if(dist[i] == temp) {
				ans = Math.max(ans, i);
			}
		}
		
	}
}
