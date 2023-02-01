package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int bee = 1;

		for (int i = 1;; i++) {
			if (N == 1) {
				System.out.println(bee);
				break;
			} else if (bee+1 <= N && N <= bee+(6*i)) {
				System.out.println(i+1);
				break;
			}
				bee += 6*i;  

		}

	}

}
