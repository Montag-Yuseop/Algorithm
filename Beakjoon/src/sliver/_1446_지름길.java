package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1446_지름길 {
	// 지름길 개수 N개
	// 거리는 D
	// 시작 / 도착 / 지름길 길이

	static class Node implements Comparable<Node> { // 정보를 저장
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	static int N, D;
	static int[] distance = new int[10001]; // D의 길이는 10000까지
	static ArrayList<Node> list;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		distance[0] = 0; // start 값은 0으로 초기화
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작정점
			int e = Integer.parseInt(st.nextToken()); // 종료
			int c = Integer.parseInt(st.nextToken()); // cost

			if (e > D)
				continue; // 종료 지점이 D를 넘어버리는 경우
			if (e - s <= c)
				continue; // 지름길이 아닌 경우

			list.add(new Node(s, e, c));
		}

		Collections.sort(list, new Comparator<>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.start == o2.start)
					return o1.end - o2.end;
				return o1.start - o2.start;
			}
		});
		
		for(int i = 0; i < D+1; i++) {
			distance[i] = i;
		}
		
		for (int i = 1; i < D + 1; i++) {
			for (Node cur : list) {
				if (i == cur.end) {
					distance[i] = Math.min(distance[i], distance[cur.start]+cur.cost);
				}
			}
			distance[i] = Math.min(distance[i], distance[i-1]+1);
		}
		System.out.println(distance[D]);

	}

}
