package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6190_정곤이의_단조증가하는수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[] num = new int[N]; // 숫자 저장
			int dan = -1; // 최대크기 계산

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {

					int su = num[i] * num[j];

					String s = String.valueOf(su);

					boolean check = true;
					for (int k = 1; k < s.length(); k++) {
						if (s.charAt(k - 1) > s.charAt(k)) {
							check = false;
							break;
						}

					}
					if (check == true) {
						dan = Math.max(dan, su);
					}

				}

			}
			System.out.println("#" + tc + " " + dan);

		}

	}
}
