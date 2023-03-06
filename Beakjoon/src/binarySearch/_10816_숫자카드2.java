package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			sb.append(find_up(arr, num) - find_down(arr, num)+" ");
		}
		System.out.println(sb);

	}

	private static int find_up(int[] arr, int num) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (num < arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		return start;
	}

	private static int find_down(int[] arr, int num) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (num <= arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		return start;
	}

}
