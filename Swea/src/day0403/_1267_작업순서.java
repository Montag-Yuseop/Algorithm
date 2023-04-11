package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1267_작업순서 {
	
	// 정점 V는 3 ~ 1000
	// 간선 E는 2 ~ 3000
	
	// 인접 리스트로 구현하자
	
	static class Node {
		
	}
	
	static ArrayList<ArrayList<Integer>> adj;
	static int V, E;
	static int[] degree;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			degree = new int[V+1];
			adj = new ArrayList<>();
			
			for(int i = 0; i < V+1; i++) {
				adj.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				adj.get(x).add(y);
				degree[y]++;
			}
			
			// 정렬 함 해주자
			for(int i = 0; i < V+1; i++) {
				Collections.sort(adj.get(i));
			}

			sb.append("#"+tc+" ");
			topological_sort();
			System.out.println(sb);
		}
		
	}

	private static void topological_sort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			
			for(int i = 0; i < adj.get(cur).size(); i++) {
				degree[adj.get(cur).get(i)]--;
				
				if(degree[adj.get(cur).get(i)] == 0) {
					q.offer(adj.get(cur).get(i));
				}
			}
			
		}
	}

}
