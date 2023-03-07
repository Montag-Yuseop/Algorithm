package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654_랜선_자르기_실패 { // 메모리초과
	public static void main(String[] args) throws IOException {

		// N개의 랜선을 만들기
		// K개의 랜선 보유
		// 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
		// K는 1이상 10,000 이하 , N은 1 이상 백만 이하
		// 랜선의 최대길이
		// 0부터 제일 긴 길이까지의 배열 생성

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 랜선 보유
		int N = Integer.parseInt(st.nextToken()); // 만들어야 할 개수

		int[] arr1 = new int[K];
		int longLan = Integer.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			arr1[i] = Integer.parseInt(br.readLine());
			longLan = Math.max(longLan, arr1[i]);
		}

		Arrays.sort(arr1);

		int[] arr2 = new int[longLan + 1];

		for (int i = 1; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				arr2[i] += (arr1[j] / i);
			}
		}
		
		int start = 1;
		int end = arr2.length - 1;
		long key = 0;
//				System.out.println(Arrays.toString(arr2));
		while (start < end) {
			int mid = (start + end) / 2;
//					System.out.println(start+" "+ end+" "+ mid);
			key = mid;

			if (arr2[mid] < N) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		System.out.println(key);

	}

}
