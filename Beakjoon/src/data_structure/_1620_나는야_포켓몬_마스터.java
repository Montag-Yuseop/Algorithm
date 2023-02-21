package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620_나는야_포켓몬_마스터 {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 입력받을 숫자
		int M = Integer.parseInt(st.nextToken()); // 답을 말할 숫자

		HashMap<Integer, String> poketNum = new HashMap<>();
		HashMap<String, Integer> poketName = new HashMap<>();
		
		for (int i = 0; i < N; i++) { // 포켓몬 저장
			String x = br.readLine();
			poketNum.put(i, x);
			poketName.put(x, i);
		}

		for (int i = 0; i < M; i++) { // 포켓몬 검색
			String pFind = br.readLine();
			char ch = pFind.charAt(0);
			if (Character.isDigit(ch)) { // 숫자일 때
				int n = Integer.parseInt(pFind);
				sb.append(poketNum.get(n-1)+"\n");
			} else {
				sb.append(poketName.get(pFind)+1+"\n");
			}

		}
		System.out.println(sb);
	}
	

}
