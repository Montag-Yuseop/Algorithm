package math_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1712_bene {

	public static void main(String[] args) throws IOException {
		
		// A는 고정비용, B는 가변비용 C는 노트북 가격
		// 손익분기점 구하기
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		// 손익 분기점
		
		try {
			long break_even_point = A/(C-B)+1;
			
			if(break_even_point <= 0) {
				System.out.println(-1);
			} else if (break_even_point > 0){
				System.out.println(break_even_point);
			}
		} catch (Exception e) {
			System.out.println(-1);
		}
		

	}

}
