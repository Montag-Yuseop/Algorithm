package implementation;

import java.util.Scanner;

public class _2567_색종이2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int [100][100];
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 색종이를 배열에 입력
			for(int r = b; r < b+10; r++) {
				for(int c = a; c < a+10; c++) {
					arr[r][c] = 1;
				}
			}

		}
		
		int cnt = 0; // 얘로 변 수 셀 예정
		
		// 열탐색
		for(int r = 0; r<100; r++) {
			for(int c = 0; c<100; c++) {
				if(arr[r][c] == 1) {
					
					if(r == 0 || r == 99) {
						cnt++;
					} else {
						
						for(int d = -1; d < 2; d = d+2) {
							if(arr[r+d][c] == 0) {
								cnt++;
							}
						}
						
					}
					
				}
			}
		}
		
		for(int c = 0; c<100; c++) {
			for(int r = 0; r<100; r++) {
				if(arr[r][c] == 1) {
					
					if(c == 0 || c == 99) {
						cnt++;
					} else {
						
						for(int d = -1; d < 2; d = d+2) {
							if(arr[r][c+d] == 0) {
								cnt++;
							}
						}
						
					}
					
				}
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
