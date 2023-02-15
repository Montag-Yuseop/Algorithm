package string_algorithm;

import java.util.Scanner;

public class _1259_팰린드롬수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			int N = sc.nextInt();
			if(N == 0) {
				break;
			} else {
				String s = String.valueOf(N);
				
				int start = 0;
				int end = s.length()-1;
				
				boolean check = true;
				
				while(start <= end) {
					if(s.charAt(start) == s.charAt(end)) {
						start++;
						end--;
					} else {
						check = false;
						break;

					}
				}
				
				if(check == true) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
				
			}
			
			
		}
		
	}
}
