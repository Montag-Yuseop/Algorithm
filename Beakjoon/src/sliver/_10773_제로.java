package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) stk.pop();
			
			else stk.push(x);
			
		}
		
		while(!stk.isEmpty()) {
			sum += stk.pop();
		}
		
		System.out.println(sum);
		
	}
}
