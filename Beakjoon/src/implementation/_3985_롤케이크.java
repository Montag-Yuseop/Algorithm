package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3985_롤케이크 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 케이크의 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수

		int[] roll = new int[L]; // 롤케익 배열 생성
		int max = 0; // 가장 많이 가져갈 수 있는 수량
		int max_a = 0; // 많이 가져가는 방청객 입력
		int real_max = 0; // 실제로 많이 가져간 사람 담기
		int real_a = 0; // 실제로 많이 가져간 방청객 번호

		// 방청객이 원하는 케이크 번호 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 원하는 처음 숫자
			int end = Integer.parseInt(st.nextToken()); // 원하는 마지막 숫자

			// max는 이전 최댓값, end-start+1은 현재 최댓값 현재 최댓값이 더 크면 갱신
			if (max < end - start + 1) {
				max_a = i + 1;
			}

			max = Math.max(max, end - start + 1); // 가져갈 수 있는 최대크기 갱신

			// 입력받은 숫자 두개에 각 방청객 번호 입력
			for (int j = start - 1; j < end; j++) {
				// 근데 roll에 이미 숫자가 적혀있으면, 즉 0이 아니면?
				if (roll[j] != 0) {
					continue; // 건너뛰기
				} else {
					roll[j] = i + 1; // 비어있으면? 방청객 숫자 입력
				}

			}

		}

		// 롤케익 입력 끝났으니까 이젠 안에 숫자 읽어오기

		for (int i = 0; i < roll.length; i++) {
			int cnt = 1;
			if (roll[i] != 0) {
				for (int j = i + 1; j < roll.length; j++) {
					if (roll[i] == roll[j]) {
						cnt++;
					} else {
						real_max = Math.max(cnt, real_max);
						break;
					}
					if (real_max < cnt) {
						real_a = roll[i];
					}

				}
			}
		}

		System.out.println(max_a);
		System.out.println(real_a);

	}
}
