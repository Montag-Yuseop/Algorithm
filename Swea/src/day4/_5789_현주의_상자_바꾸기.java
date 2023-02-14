package day4;

import java.util.Scanner;

public class _5789_현주의_상자_바꾸기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc < T+1; tc++) {
			int N = sc.nextInt(); // 상자의 수
			int Q = sc.nextInt(); // 범위 변경 수
			
			int[] box = new int[N];
			
			for(int i = 1; i<Q+1; i++) {
				
				int L = sc.nextInt()-1;
				int R = sc.nextInt()-1;
				
				for(int j = L; j<=R; j++) {
					
					box[j] = i;
					
				}
				
			}
			System.out.printf("#%d ", tc);
			for(int i = 0; i < N; i++) {
				System.out.print(box[i]+" ");
			}
			System.out.println();
		}
		sc.close();
	}

}
