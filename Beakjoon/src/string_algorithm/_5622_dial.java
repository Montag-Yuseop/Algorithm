package string_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622_dial {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());

		String s = bf.readLine();

		int time = 0;
		for (int i = 0; i < s.length(); i++) {

			switch (s.charAt(i)) {

			case 'A':
			case 'B':
			case 'C':
				time += 2;
				break;

			case 'D':
			case 'E':
			case 'F':
				time += 3;
				break;

			case 'G':
			case 'H':
			case 'I':
				time += 4;
				break;

			case 'J':
			case 'K':
			case 'L':
				time += 5;
				break;

			case 'M':
			case 'N':
			case 'O':
				time += 6;
				break;

			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				time += 7;
				break;

			case 'T':
			case 'U':
			case 'V':
				time += 8;
				break;

			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				time += 9;
				break;
			}

		}
		time += s.length();
		System.out.println(time);
	}
}
