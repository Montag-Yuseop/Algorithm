package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2805_나무_자르기 {
	// 나무의 수 N개
	// 가져가야 할 나무의 길이 M
	// 나무의 높이 입력
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		
		// 나무 배열 입력
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		// 나무 정렬하기
		Arrays.sort(tree);
		
		int start = 0;
		int end =  tree[N-1];
		
		while(start<=end) {
			int mid = (start+end) / 2;
			long sum = 0;
			for(int i = 0; i<tree.length; i++) {
				if(tree[i] >= mid) {
					sum += (tree[i]-mid);
				}
			}
			
			if(sum < M) {
				end = mid - 1; 
			} else {
				start = mid + 1;
			}
			
		}
		
		System.out.println(end);
		
	}

}
