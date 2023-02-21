package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			Stack<Character> stk = new Stack<>();
			String s = br.readLine();
			stk.clear();
			if (s.equals(".")) {
				break;
			}

			boolean check = true;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				

				if (c == '(') {
					stk.push(c);
					check = false;
				} else if (c == '[') {
					stk.push(c);
					check = false;
				} else if (c == ')') {
					if (stk.isEmpty()) {
						check = false;
						break;
					} else {
						if (stk.pop() == '[') {
							check = false;
							break;
						}
						check = true;
					}
				} else if (c == ']') {
					if (stk.isEmpty()) {
						check = false;
						break;
					} else {
						if (stk.pop() == '(') {
							check = false;
							break;
						}
						check = true;
					}
				}
				
				if(!stk.isEmpty()) {
					check = false;
				}

			}
			if (check) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}
	}

}
