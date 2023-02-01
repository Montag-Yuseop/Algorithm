package math_algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _4948_베르트랑공준 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) { // 계속 반복
			int N = Integer.parseInt(bf.readLine());
			int cnt = 0;
			
			if(N == 0) { // N이 0이면 종료
				break;
			} else {
				
				boolean arr[] = new boolean[2*N+1]; // 배열 크기는 0~2*N까지 들어가야 함
				arr[1] = true; // 1은 안쓴다
				
				for(int i=2; i<=2*N; i++) {
					for(int j=2; i*j<=2*N; j++) {
						arr[i*j] = true;
					}
				}
				
				for(int i=N+1; i<=2*N; i++) {
					if(!arr[i]) {
						cnt++;
					}
				}
				
				
			}
			
			System.out.println(cnt);
			
		}
		
		
		
	}
}
