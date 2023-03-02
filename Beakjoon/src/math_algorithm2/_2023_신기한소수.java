package math_algorithm2;

import java.util.Scanner;

public class _2023_신기한소수 {
<<<<<<< HEAD
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for(int i = 2; i<7; i++) {
			cnt = 0;
			if(i == 4 || i == 6) continue;
			digit(i, N);
		}
		
	}

	private static void digit(int i, int n) {
		
		
=======
	public static int N;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 자리 수 받기
		dfs(0, 0); // 탐색
		System.out.println(sb); // 출력
		sc.close();
	}

	private static void dfs(int num, int cnt) { // 탐색 메서드
		if (cnt == N) { // 자리수 바꿀 때마다 1씩 올라가고, N과 같아지면 종료
			if (isPrime(num)) { // 소수라면
				sb.append(num + "\n"); // 덮어쓰기
			}
			return;
		}

		for (int i = 0; i < 10; i++) { // 0부터 9까지 순회
			int nextNum = 10 * num + i; // 다음 숫자는 한 자리 증가
			if (isPrime(nextNum)) { // 다음 숫자가 소수면
				dfs(nextNum, cnt + 1); // 다시 진행 cnt 1회 늘려주고
			}
		}

	}

	// 소수 판별 메서드
	private static boolean isPrime(int num) { // 소수 판별
		if (num < 2)
			return false; // 0과 1은 소수가 아님

		for (int i = 2; i <= Math.sqrt(num); i++) { // 소수는 제곱근까지만 순회
			if (num % i == 0)
				return false;
		}

		return true;
>>>>>>> 7956b2419fd80e71bbf846d34865e9d94a5787a6
	}



}
