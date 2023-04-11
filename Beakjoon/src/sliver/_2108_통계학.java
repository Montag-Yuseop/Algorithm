package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _2108_통계학 {
	// 1. 산술평균 값(avg N)
	// 2. 중앙값 N 나열 후 중간 값
	// 3. 최 빈값
	// 4. 최대와 최소 차이
	static int[] count = new int[8001]; // 최빈값 담을거
	static ArrayList<Integer> num = new ArrayList<>(); // 이건 뭐지? 최빈값?
	static int[] arr;
	static int sum;
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		sum = 0;
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			arr[i] = x;
			sum += x;
			count[x+4000]++;
		}
		
		Arrays.sort(arr);
		
		avg();
		mid();
		mode();
		range();
		
	}
	
	// 범위
	private static void range() {
		System.out.println(arr[N-1] - arr[0]);
	}
	
	// 최빈값 찾기
	private static void mode() {
		int max = -1;
		for(int i = 0; i < count.length; i++) {
			max = Math.max(max, count[i]);
		}
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] == max) {
				num.add(i-4000);
			}
		}
		
		Collections.sort(num);
		
		if(num.size() > 1) {
			System.out.println(num.get(1));
		} else {
			System.out.println(num.get(0));
		}
	}
	
	// 중앙값
	private static void mid() {
		System.out.println(arr[N/2]);
	}
	
	// 산술 평균
	private static void avg() {
		System.out.println(((int) Math.round((double) sum/N)));
		
	}
	
}
