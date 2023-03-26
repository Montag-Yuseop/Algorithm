package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질_BFS {

	static class Node {
		int x;
		int cnt;

		public Node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

	}

	static boolean[] visited;
	static int N, K, ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		ans = 0;

		bfs();
		System.out.println(ans);

	}

	private static void bfs() {
		if (N == K)
			return;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			Node curNode = q.poll();

			if (curNode.x == K) {
				ans = curNode.cnt;
				break;
			}

			int nx1 = 2 * curNode.x;
			if (bc(nx1) && !visited[nx1]) {
				q.offer(new Node(nx1, curNode.cnt + 1));
				visited[nx1] = true;
			}

			int nx2 = curNode.x + 1;
			if (bc(nx2) && !visited[nx2]) {
				q.offer(new Node(nx2, curNode.cnt + 1));
				visited[nx2] = true;
			}

			int nx3 = curNode.x - 1;
			if (bc(nx3) && !visited[nx3]) {
				q.offer(new Node(nx3, curNode.cnt + 1));
				visited[nx3] = true;
			}

		}

	}

	private static boolean bc(int nx) {
		if (nx >= 0 && nx <= 100000)
			return true;

		return false;
	}

}
