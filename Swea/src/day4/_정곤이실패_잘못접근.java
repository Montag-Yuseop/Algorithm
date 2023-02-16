package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _정곤이실패_잘못접근 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[] num = new int[N]; // 숫자 저장
			List<Integer> su = new ArrayList<Integer>(); // 숫자 곱 저장
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					su.add(num[i] * num[j]);

				}

			}

			int dan = -1;

			for (int i = 0; i < su.size(); i++) {

				String s = String.valueOf(su.get(i));
				if (s.length() == 1) {
					dan = su.get(i);
				}

				char[] c = s.toCharArray();
				boolean check = true;
				for (int j = i + 1; j < c.length - 1; j++) {

					if (c[j] > c[j + 1]) {
						check = false;
						break;
					}

				}
				if (check == true) {
					dan = Math.max(dan, su.get(i));
				}

			}

			System.out.printf("#%d %d\n", tc, dan);

		}

	}
}