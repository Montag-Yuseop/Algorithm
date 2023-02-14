package implementation;

import java.util.Scanner;

public class _1244_스위치_켜고_끄기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 스위치 길이

		int[] sw = new int[N]; // 스위치 배열 생성

		// 스위치 내용 삽입
		for (int i = 0; i < N; i++) {
			sw[i] = sc.nextInt();
		}

		// 학생 수 입력
		int stdNum = sc.nextInt();

		// 학생 검사
		for (int i = 0; i < stdNum; i++) {
			int type = sc.nextInt();
			int swNum = sc.nextInt() - 1;

			// 남학생일 때
			if (type == 1) {
				for (int c = 0; c < N; c++) {
					if ((c + 1) % (swNum + 1) == 0) {
						if (sw[c] == 0) {
							sw[c] = 1;
						} else {
							sw[c] = 0;
						}
					}
				}

			}

			// 여학생일 때
			else {
				int start = swNum - 1;
				int end = swNum + 1;

				if (sw[swNum] == 0) {
					sw[swNum] = 1;
				} else {
					sw[swNum] = 0;
				}

				while (start >= 0 && end < N) {
					if (sw[start] != sw[end]) {
						break;
					} else {
						if (sw[start] == 0) {
							sw[start] = 1;
							sw[end] = 1;
						} else {
							sw[start] = 0;
							sw[end] = 0;
						}

						start--;
						end++;
					}

				}

			}

		}

		for (int i = 0; i < sw.length; i++) {
			System.out.printf("%d ", sw[i]);
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
		sc.close();

	}

}
