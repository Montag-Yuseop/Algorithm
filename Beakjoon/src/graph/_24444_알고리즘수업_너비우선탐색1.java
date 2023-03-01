package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _24444_알고리즘수업_너비우선탐색1 {
	static int[] visit;
	static boolean[] check;
	static List<List<Integer>> graph = new ArrayList<>();
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		cnt = 0;
		visit = new int[N+1];
		check = new boolean[N+1];
		
		for(int i = 0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			graph.get(r).add(c);
			graph.get(c).add(r);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph.get(i));
		}
		
		bfs(start);
		
		for (int i = 1; i < N + 1; i++)
			sb.append(visit[i] + "\n");
		
		System.out.println(sb);
		sc.close();
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(x);
		visit[x] = ++cnt;
		check[x] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			for(int i = 0; i<graph.get(a).size(); i++) {
				int next = graph.get(a).get(i);
				
				if(!check[next]) {
					visit[next] = ++cnt;
					check[next] = true;
					q.offer(next);
				}
			}
			
		}
		
	}
	
}
