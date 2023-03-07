package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654_랜선자르기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 랜선 보유
		int N = Integer.parseInt(st.nextToken()); // 만들어야 할 개수
		
		Long[] arr = new Long[K];

		// 배열에 값 집어넣기
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		// 정렬
		Arrays.sort(arr);
		
		long longLan = arr[K-1]; // 가장 긴 길이의 랜선
		long start = 1; // 자르기 시작은 1부터
		
		while(start<=longLan) { //마지막 지점까지
//			System.out.println("start: "+ start +" longLan  "+ longLan);
			long mid = (longLan+start)/2;
			long sum = 0;
			for(int i = 0; i<K; i++) {
				sum += (arr[i]/mid);
			}
			
			if(sum<N) {
				longLan = mid-1;
			} else {
				start = mid+1;
			}
			
			
		}
		
		System.out.println(longLan);
		
	}
}
