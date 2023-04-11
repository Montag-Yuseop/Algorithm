package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()); // 인벤토리의 수
		
		int[][] map = new int[N][M]; // 맵
		
		int max = Integer.MIN_VALUE; // 가장 높은 높이
		int min = Integer.MAX_VALUE; // 가장 낮은 높이
		int ans = Integer.MAX_VALUE; // 정답 시간
		int hight = Integer.MIN_VALUE; // 정답 높이
		
		// 맵 생성
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[r][c]);
				max = Math.max(max, map[r][c]);
			}
		}
		
		// 최소부터 최대로 맞추면서 진행하기
		for(int i = min; i <= max; i++) { // 가장 낮은 높이 i부터 가장 높은 높이 i까지
			int temp = B;
			int cnt = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[r][c] == i) continue;
					else if(map[r][c] > i) {
						temp += map[r][c] - i;
						cnt += (2*(map[r][c]-i)); // 땅 까는 작업은 높이 당 2초 걸림
					} else { // 같거나 더 크지 않으면? 즉 작으면
						temp -= (i-map[r][c]); // 배낭에서 모자라는 만큼 빼오고
						cnt += (i-map[r][c]); // 높이 차이만큼 시간이 걸림
					}
				}
			}
			if(temp < 0) continue; // 임시 배낭이 음수면 만들 수 없는 지형, 건너뛰기
			ans = Math.min(ans, cnt);
			if(ans == cnt) {
				hight = Math.max(hight, i);
			}
			
		}
		
		System.out.println(ans +" "+hight);
		
	}
}
