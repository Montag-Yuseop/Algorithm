package string_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class _1157 {

	public static void main(String[] args) {
		// 단어공부
		
		// 단어에서 가장 많이 사용된 알파벳이 무엇인지, 대소문자 구별 X
		
		// 첫 줄 단어 입력
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next().toUpperCase();

        int[] count = new int[26];

        for (int i = 0; i < S.length(); i++) {
            int num = S.charAt(i) -'A' ;
            count[num]++;
        }
        
        int max = 0;
        char res = '?';
        for(int i=0; i<count.length; i++) {
        	if(max<count[i]) {
        		max = count[i];
        		res = (char)(i+'A');
        		
        	} else if(max==count[i]) {
        		res = '?';
        	}
        	
        }
        
        System.out.println(res);
        
		
//		int cnt = 0;
//		int max = 0;
//		int flag = 0; 
//		
//		// 배열로 저장
//		char[] char_S = new char[S.length()];
//		
//		for(int i=0; i<S.length(); i++) {
//			char_S[i] = S.charAt(i);								
//		}
//		
//		for(int i=0; i<S.length(); i++) {
//			cnt = 0;
//			for(int j=0; j<S.length(); j++) {
//				if(char_S[i] == char_S[j] || char_S[i]+32 == char_S[j] || char_S[i]-32 == char_S[j]) {
//					cnt ++;
//				}
//				
//				max = Math.max(max, cnt);
//
//			}
//			if(char_S[i] == max) {
//				flag = 1;
//			}
//		}
//		if(flag == 0) {
//			System.out.println(max);
//		}
//		else {
//			System.out.println("?");
//		}
		
		

	}

}
