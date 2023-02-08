package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _2309_일곱난쟁이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 난쟁이 키 배열
		int[] hight = new int[9];

		// 난쟁이 키 저장
		int[] save = new int[7];

		int sum = 0;

		// 난쟁이 키 입력
		for (int i = 0; i < 9; i++) {
			hight[i] = sc.nextInt();
			sum += hight[i];
		}

		for (int i = 0; i < 8; i++) {
			int ans = sum - hight[i];
			for (int j = i + 1; j < 9; j++) {
				if (ans-hight[j] == 100) {
					for (int k = 0, idx = -1; k < 9; k++) {
						if (k == j || k == i) {
							continue;
						} else {
							save[++idx] = hight[k];
						}
					}
					break;
					
				} else {
					continue;
				}
			}

		}
		Arrays.sort(save);
		for (int i = 0; i < save.length; i++) {
			System.out.println(save[i]);

//		for (int i = 0; i < 3; i++) {
//			for (int j = i + 6; j < 9; j++) {
//				int sum = 0;
//				int idx = -1;
//				for (int k = i; k < i + 6; k++) {
//					System.out.println(Arrays.toString(save));
//					save[++idx] = hight[k];
//					sum += hight[k];
//				}
//				save[6] = hight[j];
//				System.out.println(Arrays.toString(save));
//				sum += hight[j];
//				
//				System.out.println(sum);
//
//				if (sum == 100) {
//					break;
//				} else {
//					save = new int[7];
//				}
//
//			}
//		}

			// System.out.println(Arrays.toString(save));

		}

	}

}
