package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1193_분수찾기 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(bf.readLine());
		int a = 0; // 분자
		int b = 0; // 분모
		int line = 0;
		int c = 0; // 얼마나갈지
		
		for(int i=0; ; i++) {
			if(X > (i*(i+1))/2 && X <= ((i+1)*(i+2))/2) {
				
				line = i+1;
				c = X - ((i*(i+1))/2)-1;

				if(line % 2 == 0) {
					a = 1+c;
					b = line - c;

					break;

					
			
				} else {
					a = line-c;
					b = 1+c;
					
					break;
					
				}
			}
		}
		System.out.printf("%d/%d",a,b);
		
	}

}
