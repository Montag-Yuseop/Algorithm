package bruteforce;

import java.util.Scanner;

public class _9663_NQueen {
	// N*N 체스판에 퀸 N개를 서로 공격할 수 없게 놓기
	static int N;
	static boolean[][] map = new boolean[N][N];
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}, // 상하좌우
						{-1,-1},{-1,1},{1,-1},{1,1}}; // 좌상 우상 좌하 우하
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N값 입력
		int cnt = 0; // 경우의 수를 출력할 변수
		
		move(0, 0, N);
		System.out.println(cnt);
	}
	// 첫 줄에 퀸을 한 개 놓았을 때 map에 퀸을 놓을 수 없는 경우 false처리
	// i 는 r, j는 c(행열의 좌표) N은 퀸의 개수를 입력
	// 퀸은 한 줄에 한 개씩 놓는다
	
	private static void move(int i, int j, int N) {
		// 종료조건은 i, j가 배열의 끝, N-1에 둘 다 도달했을 때?
		if(i == 0) return;
		
	}
	
	

	
}
