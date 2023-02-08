package greedy;

import java.util.Scanner;

public class _2810_컵홀더 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String S = sc.next();
		sc.close();
		int[] arr = new int[N + 1];

		arr[0] = 1;
		arr[N] = 1;
		
		int check_L = 0;

		for (int i = 1, idx = 0; i < N; i++) {
			if (S.charAt(idx) == 'L') {
				check_L++;
				
				if(check_L%2 != 0) {
					arr[i] = 0;
				} else {
					arr[i] = 1;
				}

			} else {
				arr[i] = 1;
			}
			idx++;
		}
		
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		sum = Math.min(N, sum);
		System.out.println(sum);
		
	}

}
