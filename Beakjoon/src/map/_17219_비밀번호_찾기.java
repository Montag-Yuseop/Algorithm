package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _17219_비밀번호_찾기 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 
		int M = Integer.parseInt(st.nextToken()); // 찾으려는 주소의 수
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i<M; i++) {
			sb.append(map.get(br.readLine())+"\n");
		}
		
		System.out.println(sb);
		
	}

}
