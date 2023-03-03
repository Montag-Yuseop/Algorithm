package im;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _14510_나무_높이 {
	public static void main(String[] args) {
		// N개의 나무(2~100)
		// 나무의 키가 주어진다(1~120)
		// 홀수일에는 나무의 키가 1 상승, 짝수일에는 나무의 키가 0 상승

		// N 입력
		// 나무 키 배열에 입력
		// 최대 나무와 최소나무 변수에 담기(인덱스)
		// 차이값을 통해 반복돌리기
		// 언제까지? 나무 인덱스의 벨류값이 같을 때 까지

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc < T + 1; tc++) {
			int N = sc.nextInt();
			int[] tree = new int[N];
			int maxTree = Integer.MIN_VALUE; // 최대높이의 나무
			int cnt = 0; // 답 출력

			for (int i = 0; i < N; i++) { // 나무배열에 나무 키 입력
				int x = sc.nextInt(); // 입력받는 나무의 키 변수
				tree[i] = x;

				// 최대 그냥 입력해버리기
				maxTree = Math.max(x, maxTree);
			}

			int[] treeHight = new int[N];
			// 나무의 차이를 이용해 배열 생성(최대 높이 - 해당 인덱스의 값)
			// 차이 배열 생성
			for (int i = 0; i < N; i++) {
				treeHight[i] = maxTree - tree[i];
			}

			Arrays.sort(treeHight);

			outer: while (true) {

				int sum = 0;
				for (int i = 0; i < N; i++) {
					sum += treeHight[i];
				}

				if (sum == 0)
					break;

				cnt++;
				System.out.println(cnt);
				System.out.println("start: " + Arrays.toString(treeHight));
				for (int i = 0; i < N; i++) {
					if (cnt % 2 != 0) { // 1씩 자랄 때

						if (i == N - 1) {
							if (treeHight[i] == 2) {

								continue outer;
							}
						}

						if (treeHight[i] > 0) {
							treeHight[i]--;
							System.out.println("end: "+Arrays.toString(treeHight));
							continue outer;
						}
					} else {
						if (treeHight[i] < 2) {
							continue;
						} else {
							treeHight[i] = treeHight[i] - 2;
							System.out.println("end: "+Arrays.toString(treeHight));
							continue outer;
						}
					}
				}

				if (cnt % 2 != 0) { // 홀수일 때
					for (int i = 0; i < N; i++) {
						if (treeHight[i] == 1) {
							treeHight[i]--;
							System.out.println("end: "+Arrays.toString(treeHight));
							continue outer;
						}

					}

				} else {
					for (int i = 0; i < N; i++) {
						if (treeHight[i] == 2) {
							treeHight[i] -= 2;
							System.out.println("end: "+Arrays.toString(treeHight));
							continue outer;
						}
					}
				}

				System.out.println("end: "+Arrays.toString(treeHight));

			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

}
