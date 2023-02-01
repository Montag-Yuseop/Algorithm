package math_algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9020_골드바흐의추측 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 0; tc < T; tc++) {
			int x = Integer.parseInt(bf.readLine());
			boolean[] arr = new boolean[x + 1];
			arr[1] = true;

			for (int i = 2; i < arr.length; i++) {
				for (int j = 2; i * j < arr.length; j++) {
					arr[i * j] = true;
				}
			}

			int a = x / 2;
			int b = x / 2;

			while (true) {
				if (!arr[a] && !arr[b]) {
					System.out.printf("%d %d", a, b);
					System.out.println();
					break;
				}
				a--;
				b++;
			}

		}

	}
}
