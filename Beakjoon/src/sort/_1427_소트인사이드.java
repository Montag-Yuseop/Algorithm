package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1427_소트인사이드 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] arr = br.readLine().toCharArray();
			
		for(int i = 0; i<arr.length; i++) {
			int maxIdx = i;
			for(int j = i+1; j<arr.length; j++) {
				if(arr[j] > arr[maxIdx]) {
					maxIdx = j;
				}
			}
			
			char temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}
		
		
		for(int i =0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}
