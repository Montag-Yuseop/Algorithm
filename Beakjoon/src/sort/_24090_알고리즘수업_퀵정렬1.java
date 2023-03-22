package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24090_알고리즘수업_퀵정렬1 {
	static int[] arr;
	static int N;
	static int K;
	static int cnt;
	static boolean check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		cnt = 0;
		check = false;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(0, arr.length - 1);
		if (check) {
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}

	}

	private static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = Lpartition(left, right);

			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);

		}

	}

	// 로무토
	private static int Lpartition(int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				swap(++i, j);

			}

		}
		if(i+1 != right) {
			swap(i+1, right);
		}
		return i + 1;
	}

	private static void swap(int i, int j) {
		cnt++;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		if(cnt == K) {
			sb.append(arr[i]+" "+arr[j]);
			check = true;
		}
		
	}

}
