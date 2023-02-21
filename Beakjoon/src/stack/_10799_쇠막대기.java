package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799_쇠막대기 {
	public static void main(String[] args) throws IOException {

		// 스택 사용
		Stack<Character> stk = new Stack<>();
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 한 줄 읽기
		String s = br.readLine();

		int cnt = 0; // 막대기의 수를 더할 변수
		boolean check = true; // 레이저인지 아닌지 체크용
		for (int i = 0; i < s.length(); i++) { // String s를 하나씩 따옴
			char c = s.charAt(i); // c 변수에 담기

			// (를 만나면 처음 나오는 )는 무적권 레이저
			if (c == '(') { // c가 (이면
				stk.push(c); // stack에 ( 담아두기
				check = true; // 다음 )는 무적권 레이저로 처리
			} else { // 만일 )를 만나면
				stk.pop(); // 일단 바로 직전의 (는 빼주고
				if (check) { // 만일 레이저 체크가true면
					cnt += stk.size(); // 왼쪽의 길이만큼 잘라내줌
					check = false; // 그리고 다음건 레이저가 아닌것으로 처리
				} else { // 만일 )인데 레이저 체크가 false라면?
					cnt++; // 자기 조각을 하나 추가해줌
				}

			}

		}
		System.out.println(cnt); // 출력

	}

}
