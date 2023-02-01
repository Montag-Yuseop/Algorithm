package string_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1316 {

	public static void main(String[] args) throws IOException {
		// 그룹 단어 체커
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		int cnt = 0;
		
		for(int tc=0; tc<T; tc++) {
			
			String s = bf.readLine();
			outer : for(int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				
				if(i+1<s.length()) {
					if(ch != s.charAt(i+1)) {
						for(int j=i+2; j<s.length(); j++) {
							if(ch == s.charAt(j)) {
								break outer;
							} 
						}
						
					}
					
				} else {
					cnt++;
				}

			}
		
			
		} System.out.println(cnt);
		

	}

}
