package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5656_벽돌깨기_실패 {
	static int N, W, H, ans;
	static int[][] copy;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			int[][] map = copy = new int[H][W];
			
			for(int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					map[r][c] = copy[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 구슬 떨기기
			for(int i = 0; i < W; i++) {
				// 구슬의 첫 위치를 바꾸면서 재귀 들어가기
				drop(map, i, 1);
				// 한 번 들어가고 나서 맵을 다시 초기화해야 함.
				map = copy.clone();
			}

			System.out.println("#"+tc +" "+ ans);
		}
	}

	private static void drop(int[][] arr, int point, int cnt) {
		// 기저조건
		int[][] temp = new int[H][W];
		temp = arr.clone();
		
		if(cnt > N) {
			// 남은 맵의 벽돌을 세어 주기(끝까지 갔기 때문)
			ans = Math.min(ans, countBlock(arr));
			System.out.println(ans);
			return;
		}
		
		// 터질 블럭을 선택
		int pick = 0;
		int row = 0;
		for(int i = 0; i < H; i++) {
			if(arr[i][point] > 0) {
				pick = arr[i][point];
				row = i;
				break;
			}
		}
		
		if(pick == 0) return;
		
		// 블럭 파괴
		bomb(arr, row, point, pick);
		
		// 블럭 다 파괴되었으면 블럭 내리기
		blockDown(arr);
		
		// 파괴된 블럭을 들고 구슬 떨기기 반복
		for(int i = 0; i < W; i++) {
			drop(arr, i, cnt+1);
			
		}
		


	}
	
	private static void blockDown(int[][] arr) {
		for(int i = 0; i < W; i++) {
			int start = H-2;
			int end = H-1;
			
			while(start > 0) {
				if(arr[end][i] == 0) {
					if(arr[start][i] != 0) {
						arr[end][i] = arr[start][i];
						arr[start][i] = 0;
						end--;
						start--;
					} else {
						start--;
					}
				} else {
					end--;
					start--;
				}
			}
			
		}
		
		
	}

	// 블럭 깨기
	private static void bomb(int[][] arr, int row, int point, int pick) {
		arr[row][point] = 0;
		
		for(int i = 1; i < point; i++) {
			for(int d = 0; d < 4; d++) {
				int nr = row+dr[d]*i;
				int nc = point+dc[d]*i;
				if(bc(nr, nc) && arr[nr][nc] != 0) {
					bomb(arr, nr, nc, arr[nr][nc]);
				}
			}
		}
		
		for(int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

	private static boolean bc(int nr, int nc) {
		return nr>=0 && nc >= 0 && nr < H && nc < W;
	}

	// 블럭을 세어 줄 메서드
	private static int countBlock(int[][] arr) {
		int sum = 0;
		
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				if(arr[r][c] > 0) sum++;
			}
		}
		
		return sum;
	}


}
