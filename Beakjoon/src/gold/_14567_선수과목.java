package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14567_선수과목 {
	static class Node {
		int x, w;

		public Node(int x, int w) {
			this.x = x;
			this.w = w;
		}
		
	}
	
	static int N, M;
	static int[][] adj;
	static int[] degree, count;
	static Queue<Node> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		degree = new int[N+1];
		count = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			adj[x][y] = 1; // 인접 행렬에 추가
			degree[y]++;
		}
		
		Topological_sort();
		for(int i = 1; i < count.length; i++) {
			System.out.print(count[i]+" ");
		}
		
	}

	private static void Topological_sort() {
		// 인접리스트를 돌면서, degree가 0인 시작정점만 노드에 담기
		for(int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) {
				q.add(new Node(i, 1));
			}
		}
		
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			count[curr.x] = curr.w;
			
			for(int i = 1; i < adj[curr.x].length; i++) {
				if(adj[curr.x][i] == 1) degree[i]--;
				
				if(adj[curr.x][i] == 1 && degree[i] == 0) {
					q.offer(new Node(i, curr.w+1));
				}
			}
		}
		
	}
}
