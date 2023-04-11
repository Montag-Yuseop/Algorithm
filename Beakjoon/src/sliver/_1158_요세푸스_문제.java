package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스_문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			q.offer(i+1);
		}
		
		sb.append("<");
		int cnt = 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(cnt % K != 0) {
				q.offer(x);
			} else {
				if(q.size() == 0) {
					sb.append(x+">");
				} else {
					sb.append(x+", ");
				}
			}
			cnt++;
		}
		System.out.println(sb);
	}

}
