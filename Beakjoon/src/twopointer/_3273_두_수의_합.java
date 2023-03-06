package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273_두_수의_합 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;

		Arrays.sort(arr);

		int start = 0;
		int end = n - 1;

		while (start < end) {
			if(arr[start] + arr[end] == x) {
				cnt++;
				start++;
				end--;
			} else if(arr[start] + arr[end] > x) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(cnt);
	}

}
