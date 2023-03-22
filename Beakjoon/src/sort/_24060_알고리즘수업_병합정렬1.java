package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24060_알고리즘수업_병합정렬1 {
	static int[] arr;
	static int K;
	static int cnt;
	static int[] new_arr;
	static int ans = -1;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime(); // 코드 시작 시간

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new int[N];
		new_arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0, arr.length-1);
		System.out.println(ans);
		
		long endTime = System.nanoTime(); // 코드 끝난 시간
        long durationTimeSec = endTime - startTime;
        System.out.println(durationTimeSec/Math.pow(10, 9) + "n/s"); // 나노세컨드 출력
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
			cnt++;
			if(cnt == K) {
				ans = arr[i-1];
				break;
			} 
		}
		
	}
	
}