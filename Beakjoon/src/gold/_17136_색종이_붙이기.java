package gold;

import java.util.Scanner;

public class _17136_색종이_붙이기 {
	
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[10][10];
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		dfs(0);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
	}

	private static void dfs(int cnt) {
		// 덮어야 할 위치를 찾기
		int sR = -1;
		int sC = -1;
		
		// 배열 탐색하면서 1인 곳을 찾아 나서자
		outer: for(int r = 0 ; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				if(map[r][c] == 1) {
					// 1이면 저장
					sR = r;
					sC = c;
					// 1인 곳을 찾았으면 반복문 전체를 종료하기
					break outer;
				}
			}
		}
		
		// 모두 0이라 못찾게 되면 - 기저조건
		if(sR == -1 && sC == -1) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		// 1을 찾은 경우엔
		int max = 5; // 색종이는 5x5부터 시작
		while(max > 0) {
			boolean check = true;  // boolean값 생성
			for(int r = 0; r < max; r++) {
				for(int c = 0; c < max; c++) {
					if(sR+r >= 10 || sC+c >= 10 || map[sR+r][sC+c] == 0) { // 범위 초과 또는 0일 때 불가능
						check = false;
						break;
					}
				}
			}
			if(check) break;
			
			max--;
		}
		
		// dfs 재귀
		for(int i = 0; i <= max; i++) {
			if(paper[i] == 0) continue;
			
			paste(sR, sC, i, 0); // 종이 붙이기
			paper[i]--;
			dfs(cnt+1);
			
			paste(sR, sC, i, 1);
			paper[i]++;
		}
		
		
	}

	private static void paste(int sR, int sC, int i, int num) {
		for(int r = sR; r < sR+i; r++) {
			for(int c= sC; c < sC+i; c++) {
				map[r][c] = num;
			}
		}
	}
}
