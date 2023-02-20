package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012_괄호 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// T만큼 테스트케이스
		for(int tc = 1; tc<T+1; tc++) {
			Stack<Character> sta = new Stack<>();
			String s = br.readLine();
			int n = s.length();
			
			boolean check = true;
			for(int i = 0; i<n; i++) {
				char c = s.charAt(i);
				
				if(c == '(') {
					sta.push(c);
				} else {
					if(!sta.isEmpty()) {
						sta.pop();
					} else {
						check = false;
						break;
					}
					
				}

			}
			if(!sta.isEmpty()) {
				check = false;
			}
			if(check) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);
	}

}