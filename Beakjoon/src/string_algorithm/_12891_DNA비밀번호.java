package string_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891_DNA비밀번호 {

	static int[] myArr;
	static int[] checkArr;
	static int checkPass; // 4개 다 일치하는지 확인하기

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 읽기

		int S = Integer.parseInt(st.nextToken()); // 문자열 수
		int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
		int result = 0;

		char[] dnaArr = new char[S]; // 입력받는 dna
		myArr = new int[4]; // dnaArr에 몇 개씩 있는지 확인
		checkArr = new int[4]; // 체크할 배열
		checkPass = 0;
		
		dnaArr = br.readLine().toCharArray(); // 입력받은 DNA값 배열로 저장

		// 체크할 배열에 숫자 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {
				checkPass++;
			}
		}

		// dna배열 숫자로 전환(함수 써보기)
		for (int i = 0; i < P; i++) {
			Add(dnaArr[i]);
		}

		if (checkPass == 4) {
			result++;
		}
		

		// 슬라이딩 윈도우 사용
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(dnaArr[i]);
			Remove(dnaArr[j]);
			if (checkPass == 4) {
				result++;
			}

		}

		System.out.println(result);
		br.close();

	}

	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if (myArr[0] == checkArr[0]) {
				checkPass--;
			}
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) {
				checkPass--;
			}
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) {
				checkPass--;
			}
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) {
				checkPass--;
			}
			myArr[3]--;
			break;

		}

	}

	private static void Add(char c) {
		switch (c) {

		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) {
				checkPass++;
			}
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) {
				checkPass++;
			}
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) {
				checkPass++;
			}
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) {
				checkPass++;
			}
			break;

		}

	}

}
