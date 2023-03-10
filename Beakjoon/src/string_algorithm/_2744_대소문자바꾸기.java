package string_algorithm;

import java.util.Scanner;

public class _2744_대소문자바꾸기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isUpperCase(c)) {
				System.out.print(Character.toLowerCase(c));
			} else {
				System.out.print(Character.toUpperCase(c));
			}
		}
		sc.close();

	}

}
