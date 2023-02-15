package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2231_분해합 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = 1; i<=N; i++) {
			String s = String.valueOf(i);
			for(int j = 0; j < s.length(); j++) {
				sum += s.charAt(j)-'0';
			}
			
			if(sum+i == N) {
				sum = i;
				break;
			}
			sum = 0;
		}
			
		System.out.println(sum);
		
		
	}

}
