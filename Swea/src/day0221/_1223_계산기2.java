package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1223_계산기2 {
	public static void main(String[] args) throws IOException {

		// 10회 반복
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> st = new Stack<>();
			int N = Integer.parseInt(br.readLine()); // 글자의 길이 N
			String s = br.readLine();
			String res = "";

			for (int i = 0; i < N; i++) {
				char ch = s.charAt(i);
				if (ch == '*') { // 연산자가 *라면
					if (st.isEmpty()) { // 비어있을 때는 push
						st.push(ch);
					} else if (st.peek() == '*') { // 그게 곱하기라면?
						res += st.pop();
						st.push(ch);
					} else if (st.peek() == '+') { // 더하기라면?
						st.push(ch);
					}

				} else if (ch == '+') { // 연산자가 +라면
					if (st.isEmpty()) {
						st.push(ch);
					} else if (st.peek() == '+') {
						res += st.pop();
						st.push(ch);
					} else if (st.peek() == '*') {
						while (!st.isEmpty() && st.peek() == '*') {
							res += st.pop();
						}
						st.push(ch);
					}

				} else {
					res += ch;
				}
			}
			
			while (!st.isEmpty()) {
				res += st.pop();
			}
			
			Stack<Integer> st2 = new Stack<>();
			for (int i = 0; i < res.length(); i++) {
				if (res.charAt(i) == '*') {
					int b = st2.pop();
					int a = st2.pop();
					st2.add(a * b);

				} else if (res.charAt(i) == '+') {
					int b = st2.pop();
					int a = st2.pop();
					st2.add(a + b);
				} else {
					st2.add(res.charAt(i) - '0');
				}
			}
			sb.append("#" + tc + " ");
			sb.append(st2.pop() + "\n");
		}
		System.out.println(sb);
	}

}
