package math_algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class _1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		
		// M이상 N이하의 소수를 모두 출력하는 프로그램 작성
		
		// BufferedReader 사용
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		// 반복문은 시간초과
//		int a = 0; // 나눠지는 수
//		for(int i=0; i<=N-M; i++) {
//			a = M+i;
//			int cnt = 0;
//			for(int j=2; j<=a; j++) {
//				if(a%j == 0) {
//					cnt++;
//				}
//			}
//			if(cnt == 1) {
//				System.out.println(a);
//			}
//			
//		}

		// 에라토스테네스의 체 공부
		
		// 1. 배열 생성 및 초기화
		
		boolean arr[] = new boolean[N+1]; // 허용 범위 만큼의 배열 생성 = boolean형
		arr[1] = true; //1은 소수가 아니므로 패스
		
		// 2. 구하고자 하는 숫자의 범위? M ~ N
		
		// 3. 반복문을 돌며 i=2부터 시작, 배수들을 모두 true값으로 변경
		for(int i=2; i<=N; i++) {
			for(int j=2; i*j<=N; j++) {
				arr[i*j] = true;
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		for(int i=M; i<=N; i++) { // M부터 N까지
			if(!arr[i]) { // arr[i]가 false일 때 true로
				System.out.println(i);
			}
		}

		

	}

}
