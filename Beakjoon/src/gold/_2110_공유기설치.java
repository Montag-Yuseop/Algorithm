package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110_공유기설치 {
	// 집의 개수 N은 2 ~ 20만
	// 공유기의 개수 C는 2 ~ N만큼
	// 집의 좌표는 0에서 1억
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] map = new int[N];

		// 집 위치 배열에 생성
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		// 배열을 정렬
		Arrays.sort(map);
		
		int start = 1; // 시작 값은 집 사이의 거리가 1
		int end = map[N - 1] - map[0] + 1; // 맨 마지막 값은 맨 처음 집 - 맨 마지막 집

		while (start < end) {
			int mid = (start + end) / 2;
			int cnt = 1; // 집의 수를 셀 변수
			int cur = map[0]; // 공유기를 설치한 집 체크

			for (int i = 1; i < map.length; i++) {
				if (map[i] - cur >= mid) {
					cnt++;
					cur = map[i];
				}
			}
			
			if (cnt < C) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		System.out.println(start-1);
	}
}
