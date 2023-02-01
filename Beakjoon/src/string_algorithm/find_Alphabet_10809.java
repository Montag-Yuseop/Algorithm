package string_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class find_Alphabet_10809 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 알파벳 배열 선언
//		char [] alphabet = new char[26];
//		for(int i = 0; i< 26; i++) {
//			alphabet[i] = (char)(i+97);
//		}
		
		int[] alphabetcnt = new int[26];
		for(int i=0; i<26; i++) {
			alphabetcnt[i] = -1;
		}
		
//		System.out.println(Arrays.toString(alphabetcnt));

		// 입력단어
		String S = sc.nextLine();
		

//		단어 쪼개기		
		for(int i=0; i<S.length(); i++) {
			char s = S.charAt(i);
			
			//있는지 검사하기 아스키코드 활용
			if(alphabetcnt[s-'a'] == -1) {
				alphabetcnt[s-'a'] = i;
			}
			
		}
		for(int arr: alphabetcnt) {
			System.out.print(arr + " ");
		}
		
		
//		for(int i=0; i<S.length(); i++) {
//			s[i] = S.charAt(i);
//		}
//		
//		for(int i=0; i<S.length(); i++) {
//			if(alphabet.equals(s)) {
//								
//			}
//		}

	}

}
