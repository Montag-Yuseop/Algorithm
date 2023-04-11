package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 다트게임 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int ans = 0;
		char[] score = new char[s.length()];
		int[] temp = new int[3];

		for (int i = 0; i < score.length; i++) {
			score[i] = s.charAt(i);
		}

		int idx = 0;

		for (int i = 0; i < score.length; i++) {
			switch (score[i]) {

			case 'S':
				idx++;
				break;
			case 'D':
				temp[idx] = (int) Math.pow(temp[idx], 2);
				idx++;
				break;
			case 'T':
				temp[idx] = (int) Math.pow(temp[idx], 3);
				idx++;
				break;

			case '*':
				idx--;
				if (idx == 0) {
					temp[idx] *= 2;
				} else {
					temp[idx - 1] *= 2;
					temp[idx] *= 2;
				}
				idx++;
				break;

			case '#':
				idx--;
				temp[idx] *= -1;
				idx++;
				break;
			
			case '1' :
				// 10일 때
				if(score[i+1] == '0') {
					temp[idx] = 10;
					i++; // 0은 건너뛰자
				} else {
					temp[idx] = 1;
				}
				break;
			default :
				temp[idx] = score[i] - '0';
			}

		}
		for(int i = 0; i < temp.length; i++) {
			ans += temp[i];
		}
		System.out.println(ans);
	}

}
