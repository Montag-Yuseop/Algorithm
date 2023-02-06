package im;

import java.io.IOException;
import java.util.Scanner;

public class _1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		

		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			char[] arr = sc.next().toCharArray();

			char zero = '0';
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != zero) {
					zero = arr[i];
					cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt); // 답 출력
		}
		sc.close();
	}
}
