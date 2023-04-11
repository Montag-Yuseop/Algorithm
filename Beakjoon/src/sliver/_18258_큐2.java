package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _18258_큐2 {
	
	// 명령 처리 프로그램 작성
	
	// push X : 정수 X를 큐에 넣는 연산
	// pop : 큐에서 가장 앞의 정수를 빼고, 정수가 없는 경우에는 -1
	// size : 큐에 있는 정수의 개수
	// empty : 큐가 비어있으면 1, 아니면 0 출력
	// front : 큐의 가장 앞에 있는 정수 출력, 정수가 없으면 -1
	// back : 큐의 가장 뒤에 있는 정수를 출력
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			
			case "push" :
				int x = Integer.parseInt(st.nextToken());
				list.add(x);
				break;
				
			case "pop" :
				if(list.size() == 0) {
					sb.append(-1 + " \n");
				} else {
					sb.append(list.getFirst()+"\n");
					list.removeFirst();	
				}
				break;
				
			case "size" :
				sb.append(list.size()+"\n");
				break;
				
			case "empty" :	
				if(list.size() == 0) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
				break;
				
			case "front" :
				if(list.size() == 0) {
					sb.append(-1+"\n");
				} else {
					sb.append(list.getFirst()+"\n");
				}
				break;
				
			case "back" :
				if(list.size() == 0) {
					sb.append(-1+"\n");
				} else {
					sb.append(list.getLast()+"\n");
				}
				break;
			}
			
			
		}
		System.out.println(sb);
	}

}
