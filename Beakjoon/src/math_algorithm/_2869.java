package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2869 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		
//		시간 초과
		
//		int cnt = 0;
//		int high = 0;
//		
//		for(int i=1; ; i++) {
//			cnt ++;
//			high += A;
//			
//			if(high >= V) {
//				break;
//			} else {
//				
//				high = A*i - B*i;
//				
//			}
//
//		}
//		System.out.println(cnt);
		
		int day = (V-B)/(A-B);
		
		if((V-B)%(A-B) != 0) {
			day++;
		} 
		

		System.out.println(day);
	}
}
