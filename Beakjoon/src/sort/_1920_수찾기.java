package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920_수찾기 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			int sIdx = 0;
			int eIdx = N-1;
			
			while(true) {
				int mid = (sIdx+eIdx)/2;
				
				if(a > A[mid]) {
					sIdx = mid+1;
				} else if(a < A[mid]) {
					eIdx = mid-1;
				} else if(A[mid] == a) {
					System.out.println(1);
					break;
				}
				
				if(sIdx > eIdx) {
					System.out.println(0);
					break;
				}

			}
			
		}
		
	}

}
