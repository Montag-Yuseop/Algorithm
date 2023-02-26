package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1222_계산기1 {
	
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc<=10; tc++) {
            stk.clear();
            stk2.clear();
 
            int N = Integer.parseInt(br.readLine());
             
            String cal = br.readLine();
            String sum = "";
            for(int i = 0; i<N; i++) {
                char ch = cal.charAt(i);
                if(ch == '+') {
                    stk.push(ch);
                } else {
                    sum += ch;
                }
            }
             
            while(!stk.isEmpty()) {
                sum+= stk.pop();
            }
             
            for(int i = 0; i<sum.length(); i++) {
                if(sum.charAt(i) == '+') {
                    int b = stk2.pop();
                    int a = stk2.pop();
                    stk2.add(a+b);
                } else {
                    stk2.add(sum.charAt(i)-'0');
                }
                 
            }
            sb.append("#"+tc+" ");
            sb.append(stk2.pop()+"\n");
             
        }
         
        System.out.println(sb);
		
	}

}
