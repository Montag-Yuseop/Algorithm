package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_DFS와_BFS {

	// 탐색을 시작할 정점의 번호 V
	// M개의 줄에 간선이 연결하는 두 정점의 번호

	static boolean[] visited; // 방문 체크 배열 - 정점의 수 만큼
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()); // 시작 번호
		
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			map.add(new ArrayList<>());
		}
		
		for(int i = 0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map.get(x).add(y);
			map.get(y).add(x);
		}
		
		for(int i = 1; i<N+1; i++)
			Collections.sort(map.get(i));
		
		for(ArrayList<Integer> arr : map) {
			System.out.println(arr);
		}
		
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false); // false로 초기화하는 기능
		
		bfs(V);
		
		
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v); // 맨 처음원소 q에 넣기
		visited[v] = true; // 방문처리 해주기
		
		while(!q.isEmpty()) { // q가 비어있지 않을 때까지
			int x = q.poll(); // x는 q의 가장 처음 넣은 원소를 뽑아온 것
			ArrayList<Integer> list = map.get(x); // q의 x번째 배열을 가져온다
			System.out.print(x+" ");
			for(int i = 0; i<list.size(); i++) { // 1부터 map.get(x)의 사이즈만큼 반복
				if(!visited[list.get(i)]) { // map의 x번째 인덱스의 i번째 원소가 방문이 아니면 
					q.add(list.get(i)); // q에 추가한다
					visited[list.get(i)] = true; // 그리고 방문처리
					
				}
				
				
			}
			
		}
		
	}

	public static void dfs(int v) {
		visited[v] = true; // 방문 배열 을 체크
		System.out.print(v + " "); // 방문한 노드 출력
		for(int i = 0; i<map.get(v).size(); i++ ) {
			int y = map.get(v).get(i);
			if(!visited[y]) { // i번째를 방문한 적이 없다면
				dfs(y); // 탐색
			}
		}
	}
}
