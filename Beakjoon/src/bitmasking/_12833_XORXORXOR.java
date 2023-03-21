package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12833_XORXORXOR {
	// A, B, C 입력 후 A XOR B ) XOR B를 C회 반복
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int ans = A ^ B;
		
		for(int i = 0; i<C-1; i++) {
			ans = ans ^ B;
		}
		
		System.out.println(ans);
	}
}
