package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1517_버블소트 {
	static long cnt;
	static int[] arr;
	static int[] new_arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		new_arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		
		mergeSort(0, arr.length-1);
		System.out.println(cnt);

	}

	private static void mergeSort(int start, int end) {
		if(start < end) {
			int mid = (start+end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start, mid, end);
			
		}
	}

	private static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int idx = i;
		
		
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				new_arr[idx++] = arr[i++];
			} else {
				new_arr[idx++] = arr[j++];
				cnt += mid + 1 - i;
			}
		}
		
		while(i<=mid) {
			new_arr[idx++] = arr[i++];
		}
		
		while(j<=end) {
			new_arr[idx++] = arr[j++];
		}
		
		i = start;
		idx = i;
		
		while(i<=end) {
			arr[i++] = new_arr[idx++];
		}
		
	}

}
