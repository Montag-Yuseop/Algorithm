package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15829_Hashing {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		long ans = 0;
		int M = 1234567891;
		long temp = 1;
		
		// 96빼면 숫자처리된다
		String s = br.readLine();
		
		for(int i = 0; i < L; i++) {
			int x = s.charAt(i) - 96;
			ans += (x * temp)%M;
			temp = (temp * 31 )%M;
		}
		
		System.out.println(ans%M);
	}
}
