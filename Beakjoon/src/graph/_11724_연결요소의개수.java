package graph;

import java.util.Scanner;

public class _11724_연결요소의개수 {
	static int N; // 정점의 수
	static int M; // 간선의 수
	static boolean[][] tree; // 연결 2차원 배열 생성
	static boolean[] visit; // 방문 배열 생성
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점 입력
		M = sc.nextInt(); // 간선 입력
		tree = new boolean[N+1][N+1]; // 0은 안쓰고, N까지 입력
		visit = new boolean[N+1]; // 마찬가지
		
		// 연결
		for(int i = 0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			tree[r][c] = true; // r,c 값 참으로
			tree[c][r] = true; // c,r 도 값 참으로
		}
		

		
		int cnt = 0; // 몇 개가 연결되어있는지 확인
		for(int i = 1; i<N+1; i++) {
			// 만일 방문하지 않았으면, 깊이 우선탐색
			if(!visit[i]) {
				dfs(i);
				cnt++; // 연결 추가
			}
		
			
		}
		System.out.println(cnt);
		sc.close();
	}

	public static void dfs(int x) {
		visit[x] = true; // 방문처리 해주기
		
		for(int i = 1; i<=N; i++) { // 1부터 N까지 돌리기
			if(tree[x][i] && !visit[i]) { // 만약 x,i를 방문했는데, i번째를 방문하지 않았으면
				dfs(i); // 재귀로 돌리기
			}
		}
	}
	
	

}
