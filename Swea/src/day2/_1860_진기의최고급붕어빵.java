package day2;

import java.util.Arrays;
import java.util.Scanner;

public class _1860_진기의최고급붕어빵 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 붕어빵 만드는데 걸리는 시간
			int K = sc.nextInt(); // M초동안 만드는 붕어빵의 수

			int[] sonnom = new int[N]; // 손님 도착시간 저장할 배열
			int max = 0; // 앞으로 비교를 위해 만들 배열의 크기를 정하기 위해

			String poss = "";

			// 손님 도착 시간 배열에 입력
			for (int i = 0; i < N; i++) {
				sonnom[i] = sc.nextInt();
				max = Math.max(max, sonnom[i]);
			}

			// 배열 생성
			int[] fish = new int[max + 1];
			int[] customer = new int[max + 1];

			// 붕어빵 개수 배열에 입력
			for (int i = 1; i < fish.length; i++) {
				if (i % M == 0) {
					fish[i] = (i / M) * K;
				} else {
					fish[i] = fish[i - 1];
				}
			}

			// 손님 도착하는 인덱스 증가
			for (int i = 0; i < sonnom.length; i++) {
				customer[sonnom[i]]++;
			}
			
			System.out.println(Arrays.toString(fish));
			System.out.println(Arrays.toString(sonnom));
			System.out.println(Arrays.toString(customer));

			// 손님 배열 순회하면서 값 비교, 손님이 전부 0이되면 끝 가능출력
			// 손님이 0이 되기 전에 fish배열과 비교해서 모자라면 break후 불가능출력

			outer: for (int i = 0; i < customer.length; i++) {
				if (customer[i] > 0) { // 손님이 1 이상이면
					if (fish[i] == 0) { // 붕어빵이 대기줄에 없을 때
						poss = "Impossible"; // 불가능처리
						break; // 종료
					} else {
						customer[i]--; // 손님 줄 1 감소
						// 현재 인덱스부터 뒤의 붕어빵 전부 1 감소
						for (int j = i; j < fish.length; j++) {
							fish[j]--;
						}

					}
				}

				// 만일 손님이 중복이라 대기줄이 0이 아니라면? i 감소하고 다시 순회
				if (customer[i] != 0) {
					i--;
					continue outer;
				}

				poss = "Possible";
			}

			System.out.printf("#%d %s\n", tc, poss);
		}
		sc.close();
	}

}
