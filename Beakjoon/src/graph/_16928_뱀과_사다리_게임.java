package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16928_뱀과_사다리_게임 {
	
	static class Node {
		int x;
		int cnt;
		
		public Node(int x, int cnt) {
			this.x = x; // 현재 위치
			this.cnt = cnt; // 이동한 횟수
		}
		
	}
	
	static int N, M, ans;
	static int[][] ladder, snake;
	static boolean[] visited = new boolean[101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사다리의 개수
		M = Integer.parseInt(st.nextToken()); // 뱀의 수
		ladder = new int[N][2];
		snake = new int[M][2];
		
		// 사다리 배열에 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<2; j++) {
				ladder[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 뱀 배열에 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<2; j++) {
				snake[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(); // 1칸부터 시작
		System.out.println(ans); // 최소값 출력
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		Node node = new Node(1, 0);
		visited[1] = true;
		q.offer(node);
		
		outer: while(!q.isEmpty()){
			Node curNode = q.poll();
//			System.out.println("curNode : " + curNode.x + " curCnt: "+curNode.cnt);			
			for(int i = 1; i < 7; i++) { // 주사위 굴리고
				// 다음 x좌표는 현재 노드의 x위치 +i(주사위)
				int nextX = curNode.x+i;
				boolean check = true;
				
				// 종료조건
				if(nextX == 100) { 
					ans = curNode.cnt+1;
					break outer;
				}
				
				for(int j = 0; j < N; j++) {
					if(nextX == ladder[j][0]) {
						q.offer(new Node(ladder[j][1], curNode.cnt+1));
						check = false;
						break;
					}
				}
				
				for(int j = 0; j < M; j++) {
					if(nextX == snake[j][0]) {
						q.offer(new Node(snake[j][1], curNode.cnt+1));
						check = false;
						break;
					}
				}
				
				if(!visited[nextX] && check) {
					q.offer(new Node(nextX, curNode.cnt+1));
					visited[nextX] = true;
				}
					
			}
		}
		
	}
}
