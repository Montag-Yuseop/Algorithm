package string_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941_2 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		int cnt = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == 'c') {
				if(i < s.length() - 1) {
					if(s.charAt(i+1) == '=') {
						i++;
					} else if(s.charAt(i+1) == '-') {
						i++;
					}
				}
			} else if(c == 'd') {
				if(i<s.length()-1) {
					if(s.charAt(i+1) == 'z') {
						if(i < s.length()-2) {
							if(s.charAt(i+2) == '=')
							i += 2;
						}
					} else if(s.charAt(i+1) == '-') {
						i++;
					}
				}
			} else if(c == 'l' || c == 'n') {
				if(i<s.length()-1){
					if(s.charAt(i+1) == 'j') {
						i++;
					}
				}
			} else if(c == 's' || c == 'z') {
				if(i<s.length()-1) {
					if(s.charAt(i+1) == '=') {
						i++;
					}
				}
			}
			
			cnt++;
			
		}
		System.out.println(cnt);
			
				
	}

}
