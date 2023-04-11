package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630_색종이만들기 {
	static int N, cntWhite, cntBlue;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int size = N;
		map = new int[N][N];
		cntWhite = cntBlue = 0;
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		findPaper(0, 0, size);
		System.out.println(cntWhite +"\n"+cntBlue);
	}

	private static void findPaper(int r, int c, int size) {
//		System.out.println(r+" "+c+" "+size);
		// size가 1이면 더 검색할 것도 없음
		if(size*size == 1) {
			if(map[r][c] == 0) {
				cntWhite++;
			} else {
				cntBlue++;
			}
			return;
		}
		// 전체가 1 또는 0인 경우 1장으로 처리
		int temp0 = 0;
		int temp1 = 0;
		
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(map[i][j] == 1 ) {
					temp1++;
				} else {
					temp0++;
				}
			}
		}
		
		if(temp0 == size * size) {
			cntWhite++;
			return;
		} else if(temp1 == size * size) {
			cntBlue++;
			return;
		}
		
		// 아닌 경우 4분면 탐색으로 쪼개서 진행
		if(r+size/2 < N && c + size/2 < N) {
			findPaper(r, c, size/2); // 
			findPaper(r, c+size/2, size/2);
			findPaper(r+size/2, c, size/2);
			findPaper(r+size/2, c+size/2, size/2);
		}
		
	}
}
