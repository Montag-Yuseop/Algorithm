package math_algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11653_소인수분해 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine()); // N값 받기
		
		outer: for(int i=2; i<=N; ) { // i를 2부터 N까지 나눈다, i++는 수행하지 않기!
			if(N%i == 0) { // 만약 나머지가 0이면 실행 
				N = N/i; // N은 N을 i로 나눈 몫으로 수정
				System.out.println(i); // i 출력
				continue outer; // 다시 반복문 시작으로(i값 증가 없이)
			} else { // 만일 나눠지지 않으면
				i++; // 그 때 i를 증가
			}
			
			
		}
		

	}

}
