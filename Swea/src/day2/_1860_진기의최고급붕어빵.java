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

			int[] sonnom = new int[N + 1]; // 손님 도착시간 저장할 배열
			int max = 0; // 앞으로 비교를 위해 만들 배열의 크기를 정하기 위해

			String poss = "";

			// 손님 도착 시간 배열에 입력
			for (int i = 1; i <= N; i++) {
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
			for (int i = 1; i < sonnom.length; i++) {
				customer[sonnom[i]]++;
			}

			// 손님 배열 순회하면서 값 비교, 손님이 전부 0이되면 끝 가능출력
			// 손님이 0이 되기 전에 fish배열과 비교해서 모자라면 break후 불가능출력

			outer: for (int i = 1; i < customer.length; i++) {
				if (customer[i] > 0) {
					if (fish[i] == 0) {
						poss = "Impossible";
						break;
					} else {
						fish[i]--;
						customer[i]--;
					}
				}
				
				if(customer[i] != 0) {
					i--;
					continue outer;
				}
				
				poss = "Possible";
			}

			System.out.println(Arrays.toString(fish));
			System.out.println(Arrays.toString(customer));
			System.out.printf("#%d %s\n", tc, poss);
		}

	}

}
