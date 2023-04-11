package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1267_핸드폰요금 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 민식 요금 - 0 ~ 30초 10원씩
		// 영식 요금 - 0 ~ 60초 15원씩
		int M = 0;
		int Y = 0;
		
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			Y += (x/30)*10 + 10;
			M += (x/60)*15 + 15;
		}
		
		if(M > Y) {
			System.out.println("Y " + Y);
		} else if(M == Y) {
			System.out.println("Y M "+M);
		} else {
			System.out.println("M "+ M );
		}
		
		
	}

}
