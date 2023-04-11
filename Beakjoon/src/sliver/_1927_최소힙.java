package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1927_최소힙 {

	// 1. 배열에 자연수 x를 넣는다
	// 2. 배열에서 가장 작은 값을 출력하고 배열에서 제거
	// priorityQueue와 같다

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x > 0) {
				pq.offer(x);
			} else {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			}

		}
		System.out.println(sb);

	}

}
