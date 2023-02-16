package implementation;

import java.util.Scanner;

public class _2477_참외밭 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cham = sc.nextInt(); // 참외 수
		int[] ground = new int[6];
		
		// maxH와 maxW값 구하기
		int maxH = Integer.MIN_VALUE;
		int maxW = Integer.MIN_VALUE;
		int r = 0;
		int c = 0;
		
		// 네 방향 돌면서 사각형 점검
		for(int i = 0; i < 6; i++) {
			int dir = sc.nextInt(); // 방향이요(dir의 인덱스로)
			int go = sc.nextInt(); // 가는 거리요 동 서 남 북
			ground[i] = go; // 땅에 적기( 좌우를 비교해요)
			
			// 최대 길이 생성
			if(dir == 1 || dir == 2) {
				maxH = Math.max(maxH, go);
				if(maxH == go) {
					r = i;
				}
			} else {
				maxW = Math.max(maxW, go);
				if(maxW == go) {
					c = i;
				}
			}
		}

		// 가장 긴 값 중 좌우를 비교, 근데 배열 끝이면 처음부터 돌려야 한다
		int h1 = ground[(r+3)%6];
		int w1 = ground[(c+3)%6];
		
		
		// 넓이 구하기
		
		int sq = ((maxW*maxH)-(h1*w1))*cham;
		System.out.println(sq);
		
	}

}
