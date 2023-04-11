package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<String, Integer> hash = new HashMap<>(); // 해쉬맵 생성
		
		int N = Integer.parseInt(st.nextToken()); // 듣도 수
		int M = Integer.parseInt(st.nextToken()); // 보도 수
		ArrayList<String> list = new ArrayList<>();
		
		int cnt = 0;
		String s = "";
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			hash.put(s, 0);
		}
		
		for(int i = 0; i < M; i++) {
			s = br.readLine();
			if(hash.containsKey(s)) {
				list.add(s);
				cnt++;
			} else {
				hash.put(s, 0);
			}
			
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(String li : list) {
			System.out.println(li);
		}
		
	}
}
