package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _5658_보물상자_비밀번호 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // TC 입력

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N개의 숫자 입력
			int K = Integer.parseInt(st.nextToken()); // K번 째로 큰 수

			ArrayList<Character> list = new ArrayList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			String s = br.readLine();
			for (int i = 0; i < N; i++) {
				list.add(s.charAt(i));
			}

			for (int i = 0; i <= N/4; i++) { // 총 4회 반복
				for (int j = 0; j <= N / 4; j++) { // N/4 자리씩
					String num = "";
					for (int k = 0; k < N / 4; k++) { // N/4번 반복
						num += list.get(3 * j + k);
					}
					int x = Integer.parseInt(num, 16);
					boolean check = true;
					for (int v : pq) {
						if (x == v) {
							check = false;
						}
					}
					if (check)
						pq.add(x);
//					System.out.println(pq);
//					System.out.println(list);

				}
				char temp = list.get(list.size() - 1);
				list.remove(list.size() - 1);
				list.add(0, temp);

			}
			int cnt = 0;
			int value = 0;
			while (true) {
				cnt++;
				value = pq.poll();
				if (cnt == K) {
					break;
				}
			}

			System.out.println("#" + tc + " " + value);

		}

	}

}
