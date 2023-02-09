package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2851_슈퍼마리오 {
	public static void main(String[] args) throws IOException{
		
		int N = 10;
		int[] arr = new int[N];
		int[] sum_arr = new int[N];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
				
		sum_arr[0] = arr[0];
		int ans = 0;
		
		for(int i=1; i<N; i++) {
			sum_arr[i] = sum_arr[i-1] + arr[i];
		}

		
		for(int i = 0; i<sum_arr.length; i++) {
			if(sum_arr[i] > 100) {
				if(Math.abs(sum_arr[i-1] - 100) < sum_arr[i] - 100) {
					ans = sum_arr[i-1];
					break;
				} else {
					ans = sum_arr[i];
					break;
				}
				
			} else if(sum_arr[i] == 100) {
				ans = 100;
				break;
			} else {
				ans = sum_arr[9];
			}
		}
		System.out.println(ans);
	}
}
