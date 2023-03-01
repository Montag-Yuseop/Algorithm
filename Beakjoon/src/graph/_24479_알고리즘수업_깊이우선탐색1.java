package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _24479_알고리즘수업_깊이우선탐색1 {
	static int[] visit;
	static boolean[] check;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt(); // 정점의 수
		int M = sc.nextInt(); // 간선의 수
		int start = sc.nextInt(); // 시작 정점의 수

		visit = new int[N + 1];
		check = new boolean[N+1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			graph.get(r).add(c);
			graph.get(c).add(r);
		}

		cnt = 0;

		for (int i = 1; i < N+1; i++)
			Collections.sort(graph.get(i));
		
		dfs(start);

		for (int i = 1; i < N + 1; i++)
			sb.append(visit[i] + "\n");
		
		System.out.println(sb);
		sc.close();
	}

	public static void dfs(int x) {
		check[x] = true;
		visit[x] = ++cnt;
		
		for (int i = 0; i < graph.get(x).size(); i++) {
			int newV = graph.get(x).get(i);

			if (!check[newV]) {
				dfs(newV);
			}
		}
	}

}
