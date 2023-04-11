package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11723_집합 {
	
	// add : S에 x 추가(x가 이미 있으면 연산 무시)
	// remove x : S에서 x를 제거, 없는 경우에는 무시
	// check x : S에 x가 있으면 1, 없으면 0
	// toggle : S에 x가 있으면 x를 제거, 없으면 x 추가
	// all : S를 {1, 2, ... 20}으로 바꾼다
	// empty : S를 공집합으로 바꾼다
	
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		list = new ArrayList<>();
		int M = Integer.parseInt(br.readLine());
		int x = 0;
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
			
			case "add" :
				x = Integer.parseInt(st.nextToken());
				add(x);
				break;
				
			case "remove" :
				x = Integer.parseInt(st.nextToken());
				remove(x);
				break;
				
			case "check" :
				x = Integer.parseInt(st.nextToken());
				sb.append(check(x)+"\n");
				break;
				
			case "toggle" :
				x = Integer.parseInt(st.nextToken());
				toggle(x);
				break;
				
			case "all" :
				list.clear();
				for(int k = 0; k < 20; k++) {
					list.add(k+1);
				}
				break;
				
			case "empty" :
				list.clear();
				break;

			}
		}
		System.out.println(sb);
		
	}

	private static void toggle(int x) {
		if(check(x) == 1) {
			remove(x);
		} else {
			add(x);
		}
	}

	private static void remove(int x) {
		if(check(x) == 0) {
			return;
		} else {
			list.remove(list.indexOf(x));
		}
	}

	private static void add(int x) {
		if(check(x) == 1 ) {
			return;
		} else {
			list.add(x);
		}
		
	}

	private static int check(int x) {
		if(list.contains(x)) {
			return 1;
		} else {
			return 0;
		}
		
	}

}
