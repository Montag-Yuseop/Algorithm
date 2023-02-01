package math_algorithm2;

import java.util.Arrays;
import java.util.Scanner;

public class _2581 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(); // 시작 입력 M
		int N = sc.nextInt(); // 끝 입력 N
		
		
		int[] arr = new int[N-M+1]; // 소수를 저장할 배열 생성(크기는 N~M까지)
		int sum = 0; // 소수의 합 저장할 변수
		int min = Integer.MAX_VALUE; // 최솟값을 저장할 변수
		
		
		
		// 소수를 담을 배열 생성
		for(int i=0; i<=N-M; i++) {
			arr[i] = M+i;
		}
		
		// 배열에 저장된 값들을 2부터 자신까지 나누기 수행
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;
			for(int j=2; j<=arr[i]; j++) {
				if(arr[i]%j == 0) { // 나눈 나머지가 0일 경우 cnt를 증가
					cnt++;
				}
			} if(cnt == 1) { // 반복문 종료 후 cnt가 1이면 소수로 판단(0이 되는 경우가 자신 뿐)
				sum += arr[i]; // sum 변수에 저장
				min = Math.min(arr[i], min); // min값을 비교하여 출력
			} 
		}
		if(sum == 0) { // 더한 수가 하나도 없으면 -1 출력
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}
}
